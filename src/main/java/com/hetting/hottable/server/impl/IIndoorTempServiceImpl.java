package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.IndoorTemp;
import com.hetting.hottable.entity.UserTemperature;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IIndoorTempServiceImpl {
    String avgIndoorTemp(String plotAddress);

    String avgInflowTemp(String plotAddress);

    String avgOutflowTemp(String plotAddress);

    String avgInflowTempMinusOutflowTemp(String plotAddress);

    Map<String,List<IndoorTemp>> builidingList(String plotAddress);

    List<UserTemperature> indoorTemp();

    Map<String, List<IndoorTemp>> cellList(String userBuilding);

    List<IndoorTemp> doorTempData(String userDoorNum);
}
