package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.AlarmDetails;

import java.util.List;

public interface AlarmDetailsMapper {
    int deleteByPrimaryKey(Long detailsId);

    int insert(AlarmDetails record);

    int insertSelective(AlarmDetails record);

    AlarmDetails selectByPrimaryKey(Long detailsId);

    int updateByPrimaryKeySelective(AlarmDetails record);

    int updateByPrimaryKey(AlarmDetails record);

    List<AlarmDetails> queryFacilityList(AlarmDetails alarmDetails);

    void queryAlarmId();

    Integer addAlarmIdAndCon(AlarmDetails alarmDetails);
}