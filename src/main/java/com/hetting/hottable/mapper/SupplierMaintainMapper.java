package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.SupplierMaintain;

import java.util.List;
import java.util.Map;

public interface SupplierMaintainMapper {
    int deleteByPrimaryKey(Integer supplierId);

    int insert(SupplierMaintain record);

    int insertSelective(SupplierMaintain record);

    SupplierMaintain selectByPrimaryKey(Integer supplierId);

    int updateByPrimaryKeySelective(SupplierMaintain record);

    int updateByPrimaryKey(SupplierMaintain record);

    List<SupplierMaintain> selectAllList(SupplierMaintain supplierMaintian);

    Integer deleteAllBy(Map<String, List<String>> id);

    List<SupplierMaintain> hotAndDealerName();
}