package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Alarm;
import com.hetting.hottable.entity.AlarmDetails;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IAlarmService {

    Object saveFacility() throws Exception;

    List<Alarm> unfinishedFacility(Alarm alarm) throws Exception;

    Integer saveMessageContent(AlarmDetails alarmDetails) throws Exception;

    List<AlarmDetails> queryFacilityList(AlarmDetails alarmDetails) throws Exception;

    Integer updateAlarmStatus(Alarm alarm) throws Exception;

    List<Alarm> processedFacility(Alarm alarm) throws Exception;

    List<Alarm> alarmsImg(Alarm alarm) throws Exception;

    List<Alarm> facilityList(Alarm alarm)throws Exception;
}
