package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.MeterData;
import com.hetting.hottable.entity.User;
import com.hetting.hottable.entity.UserTemperature;
import com.hetting.hottable.entity.Valve;

import java.util.List;

public interface IUserTemperatureService {

    List<UserTemperature> userTemperatureList(UserTemperature userTemperature) throws Exception;

    Integer updateValveWorkMode(Valve valve) throws Exception;

    Integer addDefinedVavlve(Valve valve) throws Exception;

    Integer addIndoorTemp(Valve valve) throws Exception;

    List<UserTemperature> eighteenUnderUserMap(UserTemperature userTemperature) throws Exception;

    List<UserTemperature> twentyFourUnderUserMap(UserTemperature userTemperature) throws Exception;

    List<UserTemperature> indoorTempAvg(UserTemperature userTemperature) throws Exception;

    List<UserTemperature> indoorTempValveData(UserTemperature userTemperature) throws Exception;

    List<UserTemperature> allUserAvgTemp(UserTemperature userTemperature) throws Exception;

    List<UserTemperature> userSum(User user) throws Exception;

    List<UserTemperature> toAndForTemp(UserTemperature userTemperature);

    String selectConcentCodeByWorkModal(Valve valve);

    List<MeterData> selectValveMessage(String addr);
}
