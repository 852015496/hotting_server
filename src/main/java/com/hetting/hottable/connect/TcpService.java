package com.hetting.hottable.connect;


import com.hetting.hottable.entity.*;
import com.hetting.hottable.server.*;
import com.hetting.hottable.utils.ByteUtil;
import com.hetting.hottable.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 集中器与服务器通信报文收发处理
 *
 * @author Mr.J
 * @Date 2019/12/6 - 9:37
 */
@Component
public class TcpService {

    private final Logger logger = LoggerFactory.getLogger(TcpService.class);

    //集中器
    private ConcentService concentService;
    //历史记录
    private HistoryService historyService;
    //热表和阀门
    private HotAndValveServe hotAndValveServe;
    //点名抄表
    private MeterDataService meterDataService;
    //点名阀控
//    private CallControlService callControlService;
    //小区
    private PlotMessageMainService plotMessageMainService;

    @Autowired
    public void setConcentService(ConcentService concentService) {
        this.concentService = concentService;
    }

    @Autowired
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Autowired
    public void setHotAndValveServe(HotAndValveServe hotAndValveServe) {
        this.hotAndValveServe = hotAndValveServe;
    }

    @Autowired
    public void setMeterDataService(MeterDataService meterDataService) {
        this.meterDataService = meterDataService;
    }

 /*   @Autowired
    public void setCallControlService(CallControlService callControlService) {
        this.callControlService = callControlService;
    }*/

    @Autowired
    public void PlotMessageMainService(PlotMessageMainService plotMessageMainService) {
        this.plotMessageMainService = plotMessageMainService;
    }

    /**
     * 主动下发地址表
     *
     * @param isAll   是否全部下发（0只下发修改项，1全部下发）
     * @param address 集中器地址
     */
    public void sendAddress(int isAll, String address) {
        loadAddress(1, isAll, address);
    }

    /**
     * 请求上传历史数据
     *
     * @param addr 集中器号
     */
    public void requestHistory(String addr) {
        byte[] bytes = ByteUtil.formatSendBytes(addr, Agreement.SEND_REQ_DATA, (byte) 1);
        logger.info("----------请求集中器" + addr + "上传抄表数据");
        NettyServer.sendMessage(addr, bytes);
    }

    public void handleMessage(TcpPackage basePackage) {
        String address = basePackage.getJzq();
        byte cmd = basePackage.getCmd();
        byte[] data = basePackage.getData();
        switch (cmd) {
            case Agreement.REC_LOGIN:
                responseHeartbeat(Agreement.REC_LOGIN, address, data);
                break;
            case Agreement.REC_HEART:
                responseHeartbeat(Agreement.REC_HEART, address, data);
                break;
            case Agreement.REC_DATA:
                saveHistory(address, data, basePackage.getPackageCount(), basePackage.getPackageIndex());
                break;
            case Agreement.REC_ADDRESS_REQ:
                loadAddress(0, 1, address);
                break;
            case Agreement.REC_ADDRESS_RES:
                sendAddress(address, data[0]);
                break;
            case Agreement.REC_CALL_READ:
                repCallReading(address, data);
                break;
            case Agreement.REC_CALL_CTRL:
//                repCallControl(address, data);
                break;
            case Agreement.REC_UPDATE:
                sendUpdateCode(address, data);
                break;
            default:
                break;
        }
    }

    /**
     * 响应集中器的登录和心跳请求
     *
     * @param cmd  命令码
     * @param addr 集中器地址
     * @param data 数据包
     */
    private void responseHeartbeat(byte cmd, String addr, byte[] data) {
        if (cmd == Agreement.REC_LOGIN) {
            logger.info("集中器 " + addr + " 登录服务器");
        } else {
            logger.debug("收到集中器 " + addr + " 心跳数据");
        }
            //根据集中器地址去查询是否有此集中器的数据
            Concent concentMessage = (Concent) concentService.findByJzqCode(addr);
            if (null == concentMessage) {
                logger.error("数据库中找不到集中器号为：" + addr + " 的记录");
                return;
            }
        byte[] bytes;
         //回复登陆或者心跳的时候，不能每次都下发主机地址，只在有修改的时候下发，
        // 这个字段就是用来标识要不要下发的，这是业务层的，和协议无关
        if (StringUtils.isNotEmpty(concentMessage.getPhoneId()) && "1".equals(concentMessage.getPhoneId())) {
            bytes = ByteUtil.concentratorInfoToBytes(ByteUtil.LEN_WITH_ADDRESS, concentMessage);
        } else {
            bytes = ByteUtil.concentratorInfoToBytes(ByteUtil.LEN_WITHOUT_ADDRESS, concentMessage);
        }
        bytes = ByteUtil.formatSendBytes(addr, cmd == Agreement.REC_LOGIN ? Agreement.SEND_LOGIN : Agreement.SEND_HEART, bytes);
            /*//集中器登录信息
            ByteUtil.bytesToQxnConcentratorInfo(concentMessage, data);
            hotAndValveServe.SaveConcentMessage(concentMessage, data);
            //集中器心跳信息
            ByteUtil.bytesToQxnConcentratorStatus(concentMessage, data);
            hotAndValveServe.SaveConcentMessage(concentMessage, data);*/
        NettyServer.sendMessage(addr, bytes);
        if (cmd == Agreement.REC_LOGIN) {
            //集中器登录信息
            ByteUtil.bytesToQxnConcentratorInfo(concentMessage, data);
            hotAndValveServe.SaveConcentMessage(concentMessage, data);
        } else {
            //集中器心跳信息
            ByteUtil.bytesToQxnConcentratorStatus(concentMessage, data);
            hotAndValveServe.SaveConcentMessage(concentMessage, data);
        }
        if (StringUtils.isNotEmpty(concentMessage.getValveStatus())) {
            concentMessage.setValveVolstatus(concentMessage.getValveStatus());
            concentMessage.setValveStatus("");
        }
    }

    /**
     * 分集中器主动请求和服务器主动发送，如果是集中器请求的，
     * 那你肯定是在收到03命令的时候调用这个方法，在那个地方传0过来就好了，
     * 如果是你通过界面按钮调用的这个方法，那就传1
     * 收到集中器地址表请求，加载地址表
     * @param flag    标志（0集中器请求，1主动下发）
     * @param all     是否全部下发（0只下发修改项，1全部下发）
     * @param address 集中器地址
     */
    public void loadAddress(int flag, int all, String address) {
        byte[][] sendBytes;
        if (flag == 0) {
            logger.info("收到集中器：" + address + " 的地址表请求");
            NettyServer.sendMessage(address, ByteUtil.formatSendBytes(address, Agreement.SEND_RES_ADDR, (byte) 0));
        } else {
            logger.info("准备向集中器：" + address + " 发送地址表");
        }
        //根据集中器地址查询是否有阀门表的记录
        List<HotAndValve> list = hotAndValveServe.findByJzqCode(address);
        System.err.println("下行查询数据"+list);
        if (list == null || list.size() == 0) {
            logger.error("集中器：" + address + " 下没有找到表阀记录");
            return;
        }
        //集中器下热表和阀门共多少个
        int countAll = list.size();
        //集中器地址和热表阀门共多少个
        Agreement.ADDRESS_COUNT_MAP.put(address, countAll);
        //根据集中器地址查询集中器偏移地址
//        Integer max = historyService.selectMaxPydzByJzqCode(address);
        //若最大偏移地址和数量不匹配，则说明有新增或者删除表，要重新生成偏移地址
        /*if (max == null || max + 1 != countAll) {
            //设置每个档案的偏移地址
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setPydz(i + "");
            }
            //将时间面积法和温度面积法的用户共享热表号换成偏移号
            for (HotAndValve qxn : list) {
                if (MessageUtil.stringToInt(qxn.getFileType()) == 3 || MessageUtil.stringToInt(qxn.getFileType()) == 4) {
                    String meter = qxn.getShareTableNum();
                    for (HotAndValve qxn1 : list) {
                        if (meter.equals(qxn1.getMeterAddr())) {
                            qxn.setShareTableNum(qxn1.getPydz());
                        }
                    }
                }
            }
            //如果重新生成了偏移地址，不能再只下发修改部分，只能全部下发
            all = 1;
        }*/
        //若只下载修改部分，则将不需要修改项删除
        if (all == 0) {
            //若修改标志不是1（有修改），则不需要更新
            list.removeIf(HotAndValve -> !"1".equals(HotAndValve.getRemarks()));
            if (list.size() == 0) {
                logger.info("集中器：" + address + " 的地址表没有修改，不下发");
                return;
            }
        }

//        CacheUtils.put(Agreement.TCP_METERS_LIST + address, list);
        sendBytes = ByteUtil.formatSendAddress(address, list, countAll);
        Agreement.ADDRESS_MAP.put(address, sendBytes);
        Agreement.ADDRESS_INDEX_MAP.put(address, 0);
        logger.info("加载地址表完成，共" + sendBytes.length + "包,开始向集中器下发");
//        发送第一包
        logger.info("发送第：" + 1 + "/" + sendBytes.length + "包");
        for (int i = 0; i < sendBytes.length ; i++) {
            NettyServer.sendMessage(address, sendBytes[i]);
        }
    }

    /**
     * 收到集中器的地址表确认信息，发送下一包数据
     *
     * @param addr 集中器地址
     * @param data 数据
     */
    private void sendAddress(String addr, byte data) {
        byte[][] bytes = Agreement.ADDRESS_MAP.get(addr);
        int index = Agreement.ADDRESS_INDEX_MAP.get(addr);
        //集中器回复1重发，否则发送下一包
        if (data == 1) {
            logger.debug("集中器 " + addr + " 接收地址表错误，重发第" + (index + 1) + "包");
            NettyServer.sendMessage(addr, bytes[index]);
            return;
        }
        index++;
        if (index == bytes.length) {
            int count = Agreement.ADDRESS_COUNT_MAP.get(addr);
            //更新集中器中的地址表相关信息
            Concent concent = new Concent();
            concent.setAddrStatus("1");
            concent.setAddrCount(String.valueOf(count));
            concent.setAddrDate(DateUtil.getDateString());
//            QxnConcentrator qxnConcentrator = (QxnConcentrator) CacheUtils.get(Agreement.TCP_CONCENTRATOR + addr);
//            qxnConcentrator.setAddrStatus("1");
//            qxnConcentrator.setAddrCount(String.valueOf(count));
//            qxnConcentrator.setAddrDate(DateUtil.getDateString());
//            CacheUtils.put(Agreement.TCP_CONCENTRATOR + addr, qxnConcentrator);
            Agreement.ADDRESS_INDEX_MAP.remove(addr);
            Agreement.ADDRESS_COUNT_MAP.remove(addr);
            Agreement.ADDRESS_MAP.remove(addr);
            //将更新标志改为0
//            @SuppressWarnings("unchecked")
//            List<QxnTableValveIntegration> list = (List<QxnTableValveIntegration>) CacheUtils.get(Agreement.TCP_METERS_LIST + addr);
//            CacheUtils.remove(Agreement.TCP_METERS_LIST + addr);
//            for (QxnTableValveIntegration qxn : list) {
//                qxn.setRemarks("0");
//                qxn.setValveFlag("0");
//            }
            try {
                //更新阀门表
                hotAndValveServe.updateBatchById(concent);
            } catch (Exception e) {
                logger.error("修改表阀信息更新标志失败:" + e.getMessage(), e);
            }
            logger.info("全部地址表发送完成");
        } else {
            Agreement.ADDRESS_INDEX_MAP.put(addr, index);
            logger.info("发送第：" + (index + 1) + "/" + bytes.length + "包");
            NettyServer.sendMessage(addr, bytes[index]);
        }
    }

    /**
     * 集中器上传历史数据
     *
     * @param addr 集中器地址
     * @param data 数据包
     */
    private void saveHistory(String addr, byte[] data, int count, int index) {
        logger.info("收到集中器：" + addr + " 上传的第 " + index + "/" + count + " 包抄表数据");
        byte[] bytes = ByteUtil.formatSendBytes(addr, Agreement.SEND_RES_DATA, count, index, (byte) 0);
        NettyServer.sendMessage(addr, bytes);  //把上传得到的数据包发送给集中器
        //判断当前包号是否已经收到过，若收到说明是集中器重复发送，则不作处理 返回int
        Integer index_o = (Integer) concentService.findHistory(addr);
        System.err.println(index_o);
//        Integer index_o = (Integer) CacheUtils.get(Agreement.HISTORY_INDEX_FLAG + addr);
        if (index_o != null && index_o == index) {
            return;
        }
//        CacheUtils.putTimeFlag(Agreement.HISTORY_INDEX_FLAG + addr, index);

        //根据集中器地址查詢热表和阀门信息
//        @SuppressWarnings("unchecked")
//        List<QxnTableValveIntegration> entities = (List<QxnTableValveIntegration>) CacheUtils.get(Agreement.TCP_METERS_LIST + addr);
//        if (entities == null || entities.size() == 0) {
//            logger.debug("无可用缓存，进行数据库查询");
            List<HotAndValve> entities = historyService.findByJzqCode(addr);
            System.err.println(entities);
            if (entities == null || entities.size() == 0) {
                logger.debug("集中器" + addr + " 下没有表阀信息");
                return;
            }
//            entities.get(0).getCreateBy();
//            CacheUtils.put(Agreement.TCP_METERS_LIST + addr, entities);
//        }
        List<QxnHistory> histories = ByteUtil.bytesToHistory(addr, data);
        for (QxnHistory history : histories) {
            /*List<HotAndValve> stream = entities.stream()
                    .filter(e -> e.getPydz().equals(history.getMeterAddr()))
                    .collect(Collectors.toList());   //java.lang.Integer cannot be cast to com.hetting.hottable.entity.HotAndValve
            if (stream.size() == 0) {
                continue;
            }*/
//        HotAndValve entity = stream.get(0);
        //阀门信息表获取阀门id和用户id
        List<Valve> valveId = concentService.selectValve();
        for (Valve id: valveId) {
            MeterData meterData = new MeterData();
            meterData.setValveId(id.getValveId());
            meterData.setUserId(id.getUserId());
            //阀门信息数据
            ValveMessage valveMessage = new ValveMessage();
            //获取阀门下的阀门id和用户id
            System.err.println(meterData.getValveId());
            System.err.println(meterData.getValveId());
            valveMessage.setUserId(meterData.getUserId());
            valveMessage.setValveId(meterData.getValveId());
            valveMessage.setSetPower(history.getMeterPower());
            valveMessage.setSetFlux(history.getMeterFlux());
            valveMessage.setValveWorkMode(history.getMeterWorkTime());
            concentService.insertValveMessage(valveMessage);
        }

        //阀门表获取用户id和集中器id
        /*List<User> userAndConcent = concentService.selectUserIdAndConcentId();
        //查看阀门表是否有数据,如果有数据则覆盖最新数据,如果没有就新增
            for (User id:userAndConcent) {

            }*/
        Valve valve = new Valve();
//        valve.setUserId(userAndConcent.getUserId());
//        valve.setConcentId(userAndConcent.getConcentId());
        valve.setLastPower(history.getMeterPower());
        valve.setLastFlux(history.getMeterFlux());
        valve.setValveWorkMode(history.getMeterWorkTime());
        valve.setLastUpdatedate(new Date());
        /*List<Valve> message = concentService.uploadValveMessage(valve);
        System.err.println(message);
        if(null == message){
            concentService.insertValve(valve);
        }else{
            concentService.updateValve(valve);
        }*/
        //热表信息表获取用户id和热表id
        List<Hot> hotIdAndUserId = concentService.selectHotIdAndUserId();
            for (Hot id:hotIdAndUserId) {
                //热表信息数据
                HotMessage hotMessage = new HotMessage();
                //获取热表下的热表id和用户id
                hotMessage.setUserId(id.getUserId());
                hotMessage.setHotId(id.getHotId());
                hotMessage.setCooling(history.getMeterCold());
                hotMessage.setHotting(history.getMeterHot());
                hotMessage.setVol(history.getMeterVol());
                hotMessage.setWorktime(history.getMeterWorkTime());
                hotMessage.setPower(history.getMeterPower());
                hotMessage.setHotEntrance(history.getMeterIntemp());
                hotMessage.setHotExit(history.getCwqTemp());
                concentService.insertHotMessage(hotMessage);
            }

        /*System.err.println(histories);
        List<PlotMessage> xiaoqus = plotMessageMainService.selectByCreateBy();
        System.err.println(xiaoqus);
        for (QxnHistory history : histories) {
            List<HotAndValve> stream = entities.stream()
                    .filter(e -> e.getPydz().equals(history.getMeterAddr()))
                    .collect(Collectors.toList());
            if (stream.size() == 0) {
                continue;
            }
            HotAndValve entity = stream.get(0);
            history.setXiaoqu(entity.getXiaoqu());
            if (xiaoqus != null) {
                List<PlotMessage> stream1 = xiaoqus.stream()
                        .filter(e -> e.getPlotId().equals(entity.getXiaoqu()))
                        .collect(Collectors.toList());
                if (stream1.size() > 0) {
                    history.setXiaoqu(stream1.get(0).getPlotName());
                }
            }*/
            /*history.setLouhao(entity.getLouhao());
            history.setDanyuan(entity.getDanyuan());
            history.setMenpai(entity.getMenpai());
            history.setHuming(entity.getHuming());
            history.setArea(entity.getArea());
            history.setMeterAddr(entity.getMeterAddr());
            history.setValveAddr(entity.getValveAddr());
            history.setTypeFile(entity.getFileType());
            history.setValveMode(entity.getValveMode());
            history.setCreateBy(entity.getCreateBy());
            history.setPlotId(entity.getPlotId());*/
//            history.setId(UUIDUtil.randomUUID32());
        }

        /*@SuppressWarnings("unchecked")
//        List<QxnHistory> historiesTmp = (List<QxnHistory>) CacheUtils.get(Agreement.TCP_HISTORY_LIST + addr);
        //历史记录
        List<QxnHistory> historiesTmp = historyService.findHistoryMessage(addr);
        if (historiesTmp == null || historiesTmp.size() == 0) {
            historiesTmp = histories;
        } else {
            historiesTmp.addAll(histories);
        }
        if (index != count) {
//            CacheUtils.putHistoryTmp(Agreement.TCP_HISTORY_LIST + addr, historiesTmp);
            logger.info("第 " + index + "/" + count + " 包抄表数据处理完成");
            return;
        }
//        CacheUtils.remove(Agreement.TCP_HISTORY_LIST + addr);
//        CacheUtils.remove(Agreement.HISTORY_INDEX_FLAG + addr);
//        String dateStr = ((QxnConcentrator) CacheUtils.get(Agreement.TCP_CONCENTRATOR + addr)).getAddrDate();
        String dateStr = ((Concent) concentService.findDateMessage(addr)).getAddrDate();
        if (new Date().getTime() - DateUtil.getTimeFromString(dateStr) < (3 * 60000)) {
            return;
        }
        String lastTime = histories.get(0).getReadDate();
        historiesTmp.forEach(e -> e.setReadDate(lastTime));
        try {
            HotAndValveServe.updateByJzqcodeAndPydz(historiesTmp);
        } catch (Exception e) {
            logger.error("上传历史数据：更新基本信息表失败" + e.getMessage(), e);
        }
        try {
            historyService.saveBatch(historiesTmp);
            historyService.saveHistoryToSolr(historiesTmp);
        } catch (Exception e) {
            logger.error("上传历史数据：保存历史记录失败" + e.getMessage(), e);
        }*/
        logger.info("集中器 " + addr + " 的上传数据存储完成");
    }

    /**
     * 发起点名抄表
     *
     * @param addr       集中器地址
     * @param resultType 要返回的数据类型
     * @param meters     要抄表的表信息
     * @return 错误码（-1=当前集中器正忙，-2=传入参数有误，-3=生成点抄信息时出错）
     */
    public int callReading(String addr, int resultType, List<HotAndValve> meters) {
        logger.info("准备向集中器 " + addr + " 发起点名抄表");
        if (StringUtils.isEmpty(addr) || resultType > 1 || meters == null || meters.size() == 0) {
            logger.error("发起点名抄表出错：参数有误");
            return -2;
        }
//        Object timeFlag = CacheUtils.get(Agreement.CALL_READ_WRITE_FLAG + addr);
        Object timeFlag = meterDataService.findMetaData(addr);
        if (null != timeFlag) {
            logger.error("发起点名抄表出错：集中器正忙");
            return -1;
        }
//        CacheUtils.putTimeFlag(Agreement.CALL_READ_WRITE_FLAG + addr, System.currentTimeMillis());
        int recordCount = Math.min(10, meters.size());
        List<MeterData> callReadings = new ArrayList<>();
        for (int i = 0; i < recordCount; i++) {
            MeterData callReading = new MeterData();
            callReading.setNum(i + "");                                         //数量
            callReading.setResultType(resultType + "");                         //返回类型
            callReading.setRequestTime(DateUtil.getDateString());             //请求时间
            callReading.setJzqCode(addr);                                   //集中器地址
            callReading.setHotAisle(meters.get(i).getHotAisle());        //通道号
            callReading.setHotVenderCode(meters.get(i).getHotVenderCode());       //厂家地址代码
            callReading.setHotType(meters.get(i).getHotType());         //热表类型
            callReading.setHotAddress(meters.get(i).getHotAddress());         //热表地址
            callReading.setStatus("0");                                     //状态
//            callReading.setCreateBy(UserUtil.getLoginUserId());
            callReadings.add(callReading);
        }
        try {
            MeterDataService.insertList(callReadings);
        } catch (Exception e) {
            logger.error("发起点名抄表出错：写入数据库失败 " + e.getMessage(), e);
            return -3;
        }
        byte[] bytes = ByteUtil.callMetersToBytes((byte) resultType, callReadings);
        bytes = ByteUtil.formatSendBytes(addr, Agreement.SEND_CALL_READ, bytes);
        NettyServer.sendMessage(addr, bytes);
        return 0;
    }

    /**
     * 集中器上传点抄数据
     *
     * @param addr 集中器地址
     * @param data 数据包
     */
    private void repCallReading(String addr, byte[] data) {
        logger.info("收到集中器 " + addr + " 的点抄数据，准备存储");
        List<MeterData> qxnCallReadings = ByteUtil.bytesToCallReadData(addr, data);
        try {
            MeterDataService.updateResponse(qxnCallReadings);
            logger.debug("保存集中器 " + addr + " 的点抄数据成功");
        } catch (Exception e) {
            logger.error("保存集中器 " + addr + " 的点抄数据失败 " + e.getMessage(), e);
        }
    }

    /**
     * 发起点名控阀
     *
     * @param addr   集中器地址
     * @param valves 要控制的阀门信息
     * @return 错误码（-1=当前集中器正忙，-2=传入参数有误，-3=生成点控信息时出错）
     */
    public int callControl(String addr, List<MeterData> valves) {
        logger.info("准备向集中器 " + addr + " 发起点名控阀");
        if (StringUtils.isEmpty(addr) || valves == null || valves.size() == 0) {
            logger.debug("发起点名控阀出错：参数有误");
            return -2;
        }
        Object timeFlag = meterDataService.findMetaData(addr);
        if (null != timeFlag) {
            logger.error("发起点名抄表出错：集中器正忙");
            return -1;
        }
//        CacheUtils.putTimeFlag(Agreement.CALL_READ_WRITE_FLAG + addr, System.currentTimeMillis());
//        meterDataService.findPutTimeFlag(addr,System.currentTimeMillis());
        List<MeterData> callControls = new ArrayList<>();
        try {
            String date = DateUtil.getDateString();
            for (MeterData qxnCallControl : valves) {
                qxnCallControl.setJzqCode(addr); //集中器地址
                qxnCallControl.setRequestTime(date);  //请求时间
//                qxnCallControl.setCreateBy(UserUtil.getLoginUserId());
                qxnCallControl.setStatus("0");
                callControls.add(qxnCallControl);
            }
            meterDataService.insertListValveContol(callControls);
        } catch (Exception e) {
            logger.error("发起点名控阀出错：写入数据库失败 " + e.getMessage(), e);
            return -3;
        }
        byte[] bytes = ByteUtil.callValvesToBytes(valves);
        bytes = ByteUtil.formatSendBytes(addr, Agreement.SEND_CALL_CTRL, bytes);
        NettyServer.sendMessage(addr, bytes);
        return 0;
    }

    /**
     * 集中器上传点名控阀信息
     *
     * @param addr 集中器地址
     * @param data 数据包
     */
    private void repCallControl(String addr, byte[] data) {
        logger.info("收到集中器 " + addr + " 的点控数据，准备存储");
        List<MeterData> qxnCallControls = ByteUtil.bytesToCallControlData(addr, data);
        try {
            MeterDataService.updateByJzqCodeAndAddr(qxnCallControls);
            logger.debug("保存集中器 " + addr + " 的点控数据成功");
        } catch (Exception e) {
            logger.error("保存集中器 " + addr + " 的点控数据失败 " + e.getMessage(), e);
        }
    }
    /**
     * 加载升级固件
     *
     * @param path 固件路径
     * @return 读取结果（-1=文件不存在，-2=文件错误，-3=读取失败，0=成功）
     */
    public int loadFirmware(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return -1;
        }
        int len = (int) file.length();
        byte[] buffer = new byte[len];
        try {
            InputStream in = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(in);
            if (bis.read(buffer, 0, buffer.length) == -1) {
                bis.close();
                in.close();
                return -2;
            }
            in.close();
        } catch (IOException e) {
            logger.error("读取文件失败：" + e.getMessage(), e);
            return -3;
        }
        byte[] fileBuffer = new byte[buffer.length / 2];
        for (int i = 0; i < buffer.length; i += 2) {
            String str = ((char) buffer[i]) + "" + ((char) buffer[i + 1]);
            int hex = Integer.parseInt(str, 16);
            fileBuffer[i / 2] = (byte) hex;
        }
        int sum = ByteUtil.cs(fileBuffer, 0, fileBuffer.length);
        Agreement.FIRMWARE_MAP.put("buffer", fileBuffer);
        Agreement.FIRMWARE_MAP.put("len", fileBuffer.length);
        Agreement.FIRMWARE_MAP.put("sum", sum);
        Agreement.FIRMWARE_MAP.put("date", DateUtil.getDateString());
        return 0;
    }

    /**
     * 通知集中器进行升级
     *
     * @param addresses 集中器地址
     * @return true=通知成功，false=未加载升级文件
     */
    public boolean sendUpdateKey(List<String> addresses) {
        if (Agreement.FIRMWARE_MAP.size() < 4) {
            return false;
        }
        int len = (int) Agreement.FIRMWARE_MAP.get("len");
        int sum = (int) Agreement.FIRMWARE_MAP.get("sum");
        byte[] bytes = ByteUtil.generateUpdateKey(len, sum);
        for (String addr : addresses) {
            bytes = ByteUtil.formatSendBytes(addr, Agreement.SEND_UPDATE_FLAG, bytes);
            logger.info("通知集中器" + addr + "代码升级：");
            NettyServer.sendMessage(addr, bytes);
        }
        return true;
    }

    /**
     * 下发升级系统固件
     *
     * @param addr 集中器地址
     * @param data 数据包
     */
    private void sendUpdateCode(String addr, byte[] data) {
        int offset = (data[0] & 0xff) + ((data[1] & 0xff) << 8) + ((data[2] & 0xff) << 16) + ((data[3] & 0xff) << 24);
        int packetLen = (data[4] & 0xff) + ((data[5] & 0xff) << 8);
        logger.info("收到集中器 " + addr + " 请求升级代码指令：本次偏移地址:" + offset + ",  本次请求字节数：" + packetLen);
        if (Agreement.FIRMWARE_MAP.size() < 4) {
            logger.error("服务器升级文件未准备好");
            return;
        }
        int bufferLen = (int) Agreement.FIRMWARE_MAP.get("len");
        int sum = (int) Agreement.FIRMWARE_MAP.get("sum");
        byte[] fileBytes = (byte[]) Agreement.FIRMWARE_MAP.get("buffer");
        if (offset == 0) {
            int count = bufferLen / packetLen;
            if (bufferLen % packetLen != 0) {
                count++;
            }
        }
//        暂时存入缓存中
//        int packetCount = (int) CacheUtils.get(Agreement.UPDATE_FIRMWARE_COUNT + addr);
        int packetCount = Integer.parseInt(Agreement.PACKED_COUNT + addr);
        int index = (offset / packetLen) + 1;
        byte[] bytes = new byte[11 + packetLen];
        bytes[0] = data[0];
        bytes[1] = data[1];
        bytes[2] = data[2];
        bytes[3] = data[3];
        bytes[4] = (byte) packetLen;
        bytes[5] = (byte) (packetLen >> 8);
        bytes[10] = (byte) packetCount;
        if (index == packetCount) {
            int len = bufferLen - offset;
            System.arraycopy(fileBytes, offset, bytes, 11, len);
            for (int i = 11 + len; i < bytes.length; i++) {
                bytes[i] = (byte) 0xFF;
                sum += bytes[i] & 0xFF;
            }
            bytes[6] = (byte) sum;
            bytes[7] = (byte) (sum >> 8);
            bytes[8] = (byte) (sum >> 16);
            bytes[9] = (byte) (sum >> 24);
        } else {
            System.arraycopy(fileBytes, offset, bytes, 11, packetLen);
        }

        bytes = ByteUtil.formatSendBytes(addr, Agreement.SEND_FIRMWARE, bytes);

        //总包数
        bytes[12] = (byte) packetCount;
        bytes[13] = (byte) (packetCount >> 8);
        //当前包号
        bytes[14] = (byte) index;
        bytes[15] = (byte) (index >> 8);
        int tmp = ByteUtil.getCrc16(bytes, 4, bytes.length - 3);
        bytes[bytes.length - 3] = (byte) tmp;
        bytes[bytes.length - 2] = (byte) (tmp >> 8);
        logger.info("准备向集中器" + addr + "下发第" + index + "/" + packetCount + "包升级代码：");
        NettyServer.sendMessage(addr, bytes);
        if (index == packetCount) {
            logger.info("集中器 " + addr + " 升级完成！");
        }
    }

}
