package com.hetting.hottable.server;

import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.PlotMessage;
import com.hetting.hottable.entity.UserTemperature;
import com.hetting.hottable.mapper.*;
import com.hetting.hottable.server.impl.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService implements IMainService {

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private UserTemperatureMapper userTemperatureMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HotMessageMapper hotMessageMapper;

    @Autowired
    private ValveMessageMapper valveMessageMapper;

    @Autowired
    private ConcentMapper concentMapper;

    @Autowired
    private PlotMessageMapper plotMessageMapper;

    @Override
    public List<UserTemperature> userTempDayAvg(UserTemperature userTemperature) throws Exception{
        return userTemperatureMapper.userTempDayAvg(userTemperature);
    }

    @Override
    public List<String> userNumArea() throws Exception{
        return userMapper.userNumArea();
    }

    @Override
    public List<String> hotSum() throws Exception{
        return hotMessageMapper.hotSum();
    }

    @Override
    public List<String> hotSingleSum() throws Exception{
        return hotMessageMapper.hotSingleSum();
    }

    @Override
    public List<String> avgTemp() throws Exception{
        return valveMessageMapper.avgTemp();
    }

    @Override
    public List<String> hotAndValveNum() throws Exception{
        return valveMessageMapper.hotAndValveNum();
    }

    @Override
    public List<String> concentNum() throws Exception{
        return concentMapper.concentNum();
    }

    @Override
    public List<String> faultNum() throws Exception{
        return concentMapper.faultNumber();
    }

    @Override
    public List<Concent> allNumberCount(Concent concent) throws Exception{
        return concentMapper.allNumberCount(concent);
    }

    @Override
    public Concent concentNormalAndFault() throws Exception{
        return concentMapper.concentNormalAndFault();
    }

    @Override
    public List<PlotMessage> plotList() throws Exception{
        return plotMessageMapper.plotList();
    }

    @Override
    public Concent valveHotFault() throws Exception{
        return concentMapper.valveHotFault();
    }

    @Override
    public List<String> setTemp() {
       return valveMapper.setTemp();
    }

}
