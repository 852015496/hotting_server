package com.hetting.hottable.server;

import com.hetting.hottable.entity.*;
import com.hetting.hottable.mapper.*;
import com.hetting.hottable.server.impl.IUserTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service
public class UserTemperatureService implements IUserTemperatureService {

    @Autowired
    private UserTemperatureMapper userTemperatureMapper;

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private ValveMessageMapper valveMessageMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MeterDataMapper meterDataMapper;


    @Override
    public List<UserTemperature> userTemperatureList(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.userTemperatureList(userTemperature);
    }

    /**
     * @return java.lang.Integer
     * @Author ZhangWenTao
     * @Description //TODO  阀门工作模式设定
     * @Date 2020/5/18
     * @Param [valve]
     **/
    @Override
    public Integer updateValveWorkMode(Valve valve) throws Exception{
        return valveMapper.updateByValveWorkMode(valve);
    }

    /**
     * @return java.lang.Integer
     * @Author ZhangWenTao
     * @Description //TODO  自定义阀门开度设定
     * @Date 2020/5/18
     * @Param [valve]
     **/
    @Override
    public Integer addDefinedVavlve(Valve valve) throws Exception{
        return valveMapper.settingIndoorTemp(valve);
    }
    /**
     * @Author ZhangWenTao
     * @Description //TODO  设定用户温度
     * @Date 2020/5/22
     * @Param [valve]
     * @return java.lang.Integer
     **/
    @Override
    public Integer addIndoorTemp(Valve valve) throws Exception{
        return valveMapper.settingIndoorTemp(valve);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 18℃以下用户7日比例趋势曲线
     * @Date 2020/5/22
     * @Param [userTemperature]
     * @return java.util.List<com.hetting.hottable.entity.UserTemperature>
     **/
    @Override
    public List<UserTemperature> eighteenUnderUserMap(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.eighteenUnderUserMap(userTemperature);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 24℃以上用户7日比例趋势曲线
     * @Date 2020/5/22
     * @Param [userTemperature]
     * @return java.util.List<com.hetting.hottable.entity.UserTemperature>
     **/
    @Override
    public List<UserTemperature> twentyFourUnderUserMap(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.twentyFourUnderUserMap(userTemperature);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 每天室内温度日平均温度
     * @Date 2020/5/22
     * @Param [userTemperature]
     * @return java.util.List<com.hetting.hottable.entity.UserTemperature>
     **/
    @Override
    public List<UserTemperature> indoorTempAvg(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.indoorTempAvg(userTemperature);
    }

    @Override
    public List<UserTemperature> indoorTempValveData(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.indoorTempValveData(userTemperature);
    }

    @Override
    public List<UserTemperature> allUserAvgTemp(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.allUserAvgTemp(userTemperature);
    }

    @Override
    public List<UserTemperature> userSum(User user) throws Exception{
        return  userMapper.userSum(user);
    }

    @Override
    public List<UserTemperature> toAndForTemp(UserTemperature userTemperature) {
        return userTemperatureMapper.toAndForTemp(userTemperature);
    }

    @Override
    public String selectConcentCodeByWorkModal(Valve valve) {
        return userTemperatureMapper.selectConcentCodeByWorkModal(valve);
    }

    @Override
    public List<MeterData> selectValveMessage(String addr) {
        return meterDataMapper.selectValveMessage(addr);
    }
}