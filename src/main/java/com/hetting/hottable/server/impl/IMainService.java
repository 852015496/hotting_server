package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.PlotMessage;
import com.hetting.hottable.entity.UserTemperature;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IMainService {

    List<UserTemperature> userTempDayAvg(UserTemperature userTemperature) throws Exception;

    List<String> userNumArea() throws Exception;

    List<String> hotSum() throws Exception;

    List<String> hotSingleSum() throws Exception;

    List<String> avgTemp() throws Exception;

    List<String> hotAndValveNum() throws Exception;

    List<String> concentNum() throws Exception;

    List<String> faultNum() throws Exception;

    List<Concent> allNumberCount(Concent concent) throws Exception;

    Concent valveHotFault() throws Exception;

    List<String> setTemp() throws Exception;

    Concent concentNormalAndFault() throws Exception;

    List<PlotMessage> plotList() throws Exception;
}
