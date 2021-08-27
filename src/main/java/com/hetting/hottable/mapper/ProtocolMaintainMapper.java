package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.ProtocolMaintain;

import java.util.List;
import java.util.Map;

public interface ProtocolMaintainMapper {
    int deleteByPrimaryKey(Integer protocolId);

    int insert(ProtocolMaintain record);

    int insertSelective(ProtocolMaintain record);

    ProtocolMaintain selectByPrimaryKey(Integer protocolId);

    int updateByPrimaryKeySelective(ProtocolMaintain record);

    int updateByPrimaryKey(ProtocolMaintain record);

    List<ProtocolMaintain> queryList(ProtocolMaintain protocolMaintain);

    Integer deleteAllById(Map<String, List<String>> id);

    List<ProtocolMaintain> protoColName();
}