package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.Alarm;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AlarmMapper {
    int deleteByPrimaryKey(Long alarmId);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    Alarm selectByPrimaryKey(Long alarmId);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);

    Integer saveFacility();

    List<Alarm> unfinishedFacility(Alarm alarm);

    List<Alarm> processedFacility(Alarm alarm);

    List<Alarm> alarmsImg(Alarm alarm);

    List<Alarm> facilityList(Alarm alarm);

    List<Alarm> queryList();

    int updateOccurTime(Alarm alarm);
}