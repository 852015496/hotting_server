package com.hetting.hottable.server;

import com.hetting.hottable.entity.IndoorTemp;
import com.hetting.hottable.entity.UserTemperature;
import com.hetting.hottable.mapper.IndoorTempMapper;
import com.hetting.hottable.mapper.UserTemperatureMapper;
import com.hetting.hottable.mapper.ValveMapper;
import com.hetting.hottable.server.impl.IIndoorTempServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service
public class IndoorTempService implements IIndoorTempServiceImpl {

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private IndoorTempMapper indoorTempMapper;

    @Autowired
    private UserTemperatureMapper userTemperatureMapper;


    @Override
    public String avgIndoorTemp(String plotAddress) {
        return valveMapper.avgIndoorTemp(plotAddress);
    }

    @Override
    public String avgInflowTemp(String plotAddress) {
        return valveMapper.avgInflowTemp(plotAddress);
    }

    @Override
    public String avgOutflowTemp(String plotAddress) {
        return valveMapper.avgOutflowTemp(plotAddress);
    }

    @Override
    public String avgInflowTempMinusOutflowTemp(String plotAddress) {
        return valveMapper.avgInflowTempMinusOutflowTemp(plotAddress);
    }

    @Override
    public Map<String,List<IndoorTemp>> builidingList(String plotAddress) {
        List<IndoorTemp> indoorTemps = indoorTempMapper.buildingList(plotAddress);
        Map<String,List<IndoorTemp>> indoorTempList = indoorTemps.stream().collect(Collectors.groupingBy(IndoorTemp::getUserBuilding));
        return indoorTempList;
    }

    @Override
    public List<UserTemperature> indoorTemp() {
        return userTemperatureMapper.indoorTemp();
    }

    @Override
    public Map<String, List<IndoorTemp>> cellList(String userBuilding) {
        List<IndoorTemp> cells = indoorTempMapper.cellList(userBuilding);
        Map<String,List<IndoorTemp>> indoorTempList = cells.stream().collect(Collectors.groupingBy(IndoorTemp::getUserCell));
        return indoorTempList;
    }

    @Override
    public List<IndoorTemp> doorTempData(String userDoorNum) {
        return indoorTempMapper.doorTempData(userDoorNum);
    }
}
