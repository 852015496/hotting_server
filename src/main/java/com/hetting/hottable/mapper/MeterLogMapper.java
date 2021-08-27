package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.Hot;
import com.hetting.hottable.entity.MeterLog;

import java.util.List;
import java.util.Map;

public interface MeterLogMapper {
    int deleteByPrimaryKey(Long meterId);

    int insert(MeterLog record);

    int insertSelective(MeterLog record);

    MeterLog selectByPrimaryKey(Long meterId);

    int updateByPrimaryKeySelective(MeterLog record);

    int updateByPrimaryKey(MeterLog record);

    Integer saveMeterAddrs(List<String> hotAddress);
}