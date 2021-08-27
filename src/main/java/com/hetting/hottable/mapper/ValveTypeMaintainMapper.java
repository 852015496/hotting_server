package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.FacilityAllMessage;
import com.hetting.hottable.entity.HotTypeMaintain;
import com.hetting.hottable.entity.ValveTypeMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ValveTypeMaintainMapper {
    int deleteByPrimaryKey(Integer valvetypeId);

    int insert(ValveTypeMaintain record);

    int insertSelective(ValveTypeMaintain record);

    ValveTypeMaintain selectByPrimaryKey(Integer valvetypeId);

    int updateByPrimaryKeySelective(ValveTypeMaintain record);

    int updateByPrimaryKey(ValveTypeMaintain record);

    List<ValveTypeMaintain> queryList(ValveTypeMaintain valveTypeMaintain);

    Integer deleteAllById(Map<String, List<String>> id);

    HotTypeMaintain finprotocolCode(@Param(value = "protocolCode") String protocol_code,
                                    @Param(value = "value") Object value);

    void save(FacilityAllMessage qr);
}