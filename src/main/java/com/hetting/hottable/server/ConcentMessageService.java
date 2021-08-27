package com.hetting.hottable.server;

import com.hetting.hottable.connect.TcpService;
import com.hetting.hottable.entity.*;
import com.hetting.hottable.export.Entity.ExportConcentUserMessage;
import com.hetting.hottable.mapper.*;
import com.hetting.hottable.server.impl.IConcentMessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("concentMessageService")
public class ConcentMessageService implements IConcentMessageService {

    @Autowired
    private ConcentMessageMapper concentMessageMapper;

    @Autowired
    private ConcentMapper concentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HotMapper hotMapper;

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private PlotMessageMapper plotMessageMapper;

    @Autowired
    private MeterLogMapper meterLogMapper;

    @Autowired
    private HotAndValveMapper hotAndValveMapper;


    /**
     * @Author ZhangWenTao
     * @Description //TODO 集中器下住户信息展示
     * @Date 2020/4/15
     * @Param [concentMessageVO]
     * @return java.util.List<com.hetting.hottable.entity.ConcentMessageVO>
     **/
    @Override
    public List<ConcentMessageVO> concentUserList(ConcentMessageVO concentMessageVO) throws Exception{
            List<ConcentMessageVO> listvo = concentMessageMapper.concentUserList(concentMessageVO);
            return listvo;
    }


    /**
     * @Author ZhangWenTao
     * @Description //TODO  删除和批量删除
     * @Date 2020/4/16
     * @Param [list]
     * @return java.lang.Integer
     **/
    @Override
    public Integer deleteAll(List id) throws Exception{
        Map<String,List<String>> map = new HashMap<>();
        map.put("id",id);
        return concentMessageMapper.deleteAll(map);
    }

    @Override
    @Transactional
    public Integer deleteById(Integer userId) throws Exception{
        hotMapper.deleteById(userId);
        valveMapper.deleteById(userId);
        return userMapper.deleteById(userId);
    }


    @Override
    public List<PlotMessage> listPlotMessage() throws Exception{
        return plotMessageMapper.plotList();
    }

    @Override
    @Transactional
    public Integer updateUserConcent(UserVO userVO) throws Exception{
        //添加用户信息
        User user = new User();
        user.setUserId(userVO.getUserId());
        user.setUserName(userVO.getUserName());
        user.setUserType(userVO.getUserType());
        user.setUserBuilding(userVO.getUserBuilding());
        user.setUserCell(userVO.getUserCell());
        user.setUserDoornum(userVO.getUserDoornum());
         user.setUserArea(userVO.getUserArea());
        userMapper.updateByPrimaryKeySelective(user);

        //添加热表信息
        Hot hot = new Hot();
        hot.setUserId(userVO.getUserId());
        hot.setHotVenderName(userVO.getHotVenderName());
        hot.setHotManuCode(userVO.getHotManuCode());
        hot.setHotAisle(userVO.getHotAisle());
        hot.setHotAddress(userVO.getHotAddress());
        hotMapper.updateByPrimaryKeySelective(hot);

        //添加阀门信息
        Valve valve = new Valve();
        valve.setUserId(userVO.getUserId());
        valve.setValveVenderName(userVO.getValveVenderName());
        valve.setVenderCode(userVO.getVenderCode());
        valve.setValveChn(userVO.getValveChn());
        valve.setValveAddress(userVO.getValveAddress());
        valve.setValveWorkMode(userVO.getValveWorkMode());
        valve.setSetIndoorTemp(userVO.getSetIndoorTemp());
        valve.setOpening(userVO.getOpening());
        valve.setMinOpen(userVO.getMinOpen());
        valve.setMaxOpen(userVO.getMaxOpen());
        valve.setTempUpper(userVO.getTempUpper());
        valve.setTempLower(userVO.getTempLower());
        valve.setSetTempValue(userVO.getSetTempValue());
        valve.setSetPower(userVO.getSetPower());
        valve.setSetFlow(userVO.getSetFlow());
        valve.setApportionHot(userVO.getApportionHot());
        valve.setPowerOpening(userVO.getPowerOpening());
        valve.setTrimClosing(userVO.getTrimClosing());
        valve.setRustSport(userVO.getRustSport());
        valve.setTempInterval(userVO.getTempInterval());
        valve.setTempAdjust(userVO.getTempAdjust());
        valveMapper.updateByPrimaryKeySelective(valve);

        return 1;
    }

    @Override
    public Valve valveList(Valve valve) throws Exception {
        return valveMapper.selectByPrimaryKey(valve.getUserId());
    }

    @Override
    public Integer saveMeterAdd(MeterLog meterLog) {
        return meterLogMapper.insertSelective(meterLog);
    }

    @Override
    public String saveMeterAddrs(List addrList) throws Exception {
        System.err.println(addrList);
        return hotMapper.selectByUserId(addrList);
//        return meterLogMapper.saveMeterAddrs(addr,resultType,meters);
    }

    @Override
    public List<HotAndValve> selectHotMessage(List addrList) {
        return hotAndValveMapper.selectHotMap(addrList);
    }

    @Override
    public List<ConcentMessageVO> listexcel() {
        return concentMessageMapper.exportUserMessage();
    }

    @Override
    public List<DataContrastVO> selectUserBuilding() {
        return userMapper.selectUserBuilding();
    }

    @Override
    public List<DataContrastVO> selectUserDoorNum() {
        return userMapper.selectUserDoorNum();
    }


    /**
 * @Author ZhangWenTao
 * @Description //TODO   根据上报集中器代码 查询集中器是否存在
 * @Date 2020/9/7
 * @Param [message]
 * @return java.util.List<com.hetting.hottable.entity.ConcentMessage>
 **/
    public List<ConcentMessage> findList2(ConcentMessageVO message) {
        return concentMapper.findList2(message);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 如果不存在 把上报信息存入集中器信息表
     * @Date 2020/9/7
     * @Param [qf]
     * @return void
     **/
    @Transactional(readOnly = false)
    public void save(ConcentMessage qf) {
    concentMessageMapper.insertSelective(qf);
    }

    public List<ConcentMessage> findList(ConcentMessageVO qct) {
        return concentMessageMapper.findList(qct);
    }

    public List<FacilityAllMessage> findList3(FacilityAllMessage qr) {
    return ConcentMessageMapper.findList3(qr);
    }

    public List<String> selectNewHot(String yibiaodizhidm) {
        return concentMessageMapper.selectNewHot(yibiaodizhidm);
    }

    public Integer updateRunStatus(FacilityAllMessage amm) {
        return concentMessageMapper.updateRunStatus(amm);
    }

}
