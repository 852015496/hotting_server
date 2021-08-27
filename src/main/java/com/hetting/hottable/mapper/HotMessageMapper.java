package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.HotMessage;

import java.util.List;

public interface HotMessageMapper {
    int deleteByPrimaryKey(Long hotId);

    int insert(HotMessage record);

    int insertSelective(HotMessage record);

    HotMessage selectByPrimaryKey(Long hotId);

    int updateByPrimaryKeySelective(HotMessage record);

    int updateByPrimaryKey(HotMessage record);

    List<String> hotSum();

    List<String> hotSingleSum();

    static List<HotMessage> findListByJzq(String s) {
        return null;
    }

    Integer saveHotMessage(HotMessage hotMessage);

}