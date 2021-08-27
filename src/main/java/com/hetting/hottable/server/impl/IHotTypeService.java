package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.*;

import java.util.List;

public interface IHotTypeService {

    List<HotTypeMaintain> queryList(HotTypeMaintain hotTypeMaintian) throws Exception;

    Integer saveHotType(HotTypeMaintain hotTypeMaintian) throws Exception;

    Integer updateProcotol(HotTypeMaintain hotTypeMaintian) throws Exception;

    Integer deleteById(Integer hottypeId) throws Exception;

    Integer deleteAllById(List<String> id) throws Exception;

    List<SupplierMaintain> hotAndDealerName() throws Exception;

    List<ProtocolMaintain> protocolName() throws Exception;

}
