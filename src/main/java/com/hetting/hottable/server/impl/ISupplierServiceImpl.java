package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.SupplierMaintain;

import java.util.List;

public interface ISupplierServiceImpl {

    List<SupplierMaintain> queryList(SupplierMaintain supplierMaintian) throws Exception;

    Integer saveSupplier(SupplierMaintain supplierMaintian) throws Exception;

    Integer updateSupplier(SupplierMaintain supplierMaintian) throws Exception;

    Integer deleteById(Integer supplierId) throws Exception;

    Integer deleteAllById(List<String> id) throws Exception;
}
