package com.hetting.hottable.server;

import com.hetting.hottable.entity.*;
import com.hetting.hottable.mapper.*;
import com.hetting.hottable.server.impl.IConcentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service("concentService")
public class ConcentService implements IConcentService {

    @Autowired
    private ConcentMapper concentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HotMapper hotMapper;

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private ValveMessageMapper valveMessageMapper;

    @Autowired
    private HotMessageMapper hotMessageMapper;

    @Autowired
    private PlotMessageMapper plotMessageMapper;


    /**
     * @Author ZhangWenTao
     * @Description //TODO  集中器信息查询
     * @Date 2020/4/13
     * @Param [concent]
     * @return java.util.List<com.hetting.hottable.entity.Concent>
     **/
    @Override
    public List<Concent> concentList(Concent concent) throws Exception{
        return concentMapper.listConcent(concent);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  集中器信息添加
     * @Date 2020/4/13
     * @Param [concent]
     * @return java.lang.Integer
     **/
    @Override
    public Integer addConcent(Concent concent) throws Exception{
        plotMessageMapper.plotList();
        return concentMapper.insertSelective(concent);
    }


    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据id删除集中器一条信息
     * @Date 2020/4/13
     * @Param [concentId]
     * @return java.lang.Integer
     **/
    @Override
    @Transactional
    public Integer deleteConcent(Integer concentId) throws Exception{

        hotMapper.deleteByConcentId(concentId);

        valveMapper.deleteByConcentId(concentId);

        userMapper.deleteByConcentId(concentId);

        return concentMapper.deleteByConcentId(concentId);
    }
    /**
     * @Author ZhangWenTao
     * @Description //TODO     修改集中器信息
     * @Date 2020/4/13
     * @Param [concent]
     * @return java.lang.Integer
     **/
    @Override
    public Integer updateConcent(Concent concent) throws Exception{
        concentMapper.updateByPrimaryKeySelective(concent);
        concentMapper.updateByAddress(concent);
        return userMapper.updateByAddress(concent);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  修改时,根据集中器id回显小区信息
     * @Date 2020/4/13
     * @Param [concent]
     * @return com.hetting.hottable.entity.Concent
     **/
    @Override
    public Concent updateConcentList(Concent concent) throws Exception{
        return concentMapper.selectByPrimaryKey(concent.getConcentId());
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  批量删除集中器信息
     * @Date 2020/4/13
     * @Param [id]
     * @return java.lang.Integer
     **/
    @Override
    public Integer deleteAllConcent(List<String> id) throws Exception{
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return concentMapper.deleteAllConcent(map);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  配置用户 热表 阀门 信息
     * @Date 2020/4/13
     * @Param [user, hot, value]
     * @return java.lang.Integer
     **/
    @Override
    @Transactional
    public Integer addMaterMessage(UserVO userVO) throws Exception{

            //添加用户信息
            User user = new User();
            user.setPlotId(userVO.getPlotId());
            user.setConcentId(userVO.getConcentId());
            user.setUserName(userVO.getUserName());
            user.setUserType(userVO.getUserType());
            user.setUserBuilding(userVO.getUserBuilding());
            user.setUserCell(userVO.getUserCell());
            user.setUserDoornum(userVO.getUserDoornum());
            user.setUserArea(userVO.getUserArea());
            user.setUserConcentCode(userVO.getUserConcentCode());
            userMapper.insertSelective(user);
            Integer userId = user.getUserId();
            System.err.println(userId);

            //添加热表信息
            Hot hot = new Hot();
            hot.setUserId(userId);
            hot.setConcentId(userVO.getConcentId());
            hot.setHotVenderName(userVO.getHotVenderName());
            hot.setHotAisle(userVO.getHotAisle());
            hot.setHotAddress(userVO.getHotAddress());
            hotMapper.insertSelective(hot);
            Integer hotId = hot.getHotId();
            System.err.println(userId);

            //添加阀门信息
            Valve valve = new Valve();
            valve.setUserId(userId);
            valve.setConcentId(userVO.getConcentId());
            valve.setConcentId(userVO.getConcentId());
            valve.setValveVenderName(userVO.getValveVenderName());
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
            valve.setSetFlow(userVO.getSetFlow());
            valve.setApportionHot(userVO.getApportionHot());
            valve.setSetPower(userVO.getSetPower());
            valve.setPowerOpening(userVO.getPowerOpening());
            valve.setTrimClosing(userVO.getTrimClosing());
            valve.setRustSport(userVO.getRustSport());
            valve.setTempInterval(userVO.getTempInterval());
            valve.setTempAdjust(userVO.getTempAdjust());
            valveMapper.insertSelective(valve);
            Integer valveId = valve.getValveId();
            System.err.println(valveId);
        return 1;
    }

    @Override
    public List<Concent> concentTerm(Concent concent) throws Exception{
        return concentMapper.concentTerm(concent);
    }

    public Object findHistory(String addr) {
        return concentMapper.findHistory(addr);
    }

    public Object findByJzqCode(String addr) {
        return concentMapper.findConcentCode(addr);
    }

    public Object findDateMessage(String addr) {
        return null;
    }

    public void insertValveMessage(ValveMessage valveMessage) {
        valveMessageMapper.saveMeterMessage(valveMessage);
    }

    public void insertHotMessage(HotMessage hotMessage) {
        hotMessageMapper.saveHotMessage(hotMessage);
    }

    public List<Valve> uploadValveMessage(Valve valve) {
        return valveMapper.queryLastMessage(valve);
    }

    public void insertValve(Valve valve) {
        valveMapper.saveValveLastMessage(valve);
    }

    public void updateValve(Valve valve) {
        valveMapper.updateLastValveMessage(valve);
    }

   public List<Valve> selectValve() {
        return valveMapper.selectValve();
    }

     public List<User> selectUserIdAndConcentId() {
        return userMapper.selectUserIdAndConcentId();
    }

    public List<Hot> selectHotIdAndUserId() {
        return hotMapper.selectHotIdAndUserId();
    }



    //------------------     Send Mqtt concentMessage ----------------------------------------------



}
