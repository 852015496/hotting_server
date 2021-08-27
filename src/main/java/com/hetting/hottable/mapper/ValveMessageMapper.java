package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.Valve;
import com.hetting.hottable.entity.ValveMessage;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ValveMessageMapper {
    int deleteByPrimaryKey(Long valvemId);

    int insert(ValveMessage record);

    int insertSelective(ValveMessage record);

    ValveMessage selectByPrimaryKey(Long valvemId);

    int updateByPrimaryKeySelective(ValveMessage record);

    int updateByPrimaryKey(ValveMessage record);

    void deleteByValveAddress();

    List<String> avgTemp();

    List<String> hotAndValveNum();

    List<ValveMessage> findListByJzqAndSpare14(String s);

    void saveMeterMessage(ValveMessage valveMessage);
}