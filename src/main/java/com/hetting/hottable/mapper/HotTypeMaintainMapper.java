package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.FacilityAllMessage;
import com.hetting.hottable.entity.HotTypeMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HotTypeMaintainMapper {
    static List<FacilityAllMessage> findList(FacilityAllMessage fm) {
        return null;
    }

    int deleteByPrimaryKey(Integer hottypeId);

    int insert(HotTypeMaintain record);

    int insertSelective(HotTypeMaintain record);

    HotTypeMaintain selectByPrimaryKey(Integer hottypeId);

    int updateByPrimaryKeySelective(HotTypeMaintain record);

    int updateByPrimaryKey(HotTypeMaintain record);

    List<HotTypeMaintain> queryList(HotTypeMaintain hotTypeMaintian);

    Integer deleteAllById(Map<String, List<String>> id);

    HotTypeMaintain findProtocolCode(@Param(value = "protocolCode") String protocol_code,
                                     @Param(value = "value") Object value);

    void save(FacilityAllMessage qr);

    List<FacilityAllMessage> findList4(FacilityAllMessage qr);
}