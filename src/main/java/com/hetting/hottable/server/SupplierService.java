package com.hetting.hottable.server;

import com.hetting.hottable.entity.SupplierMaintain;
import com.hetting.hottable.mapper.SupplierMaintainMapper;
import com.hetting.hottable.server.impl.ISupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierService implements ISupplierServiceImpl {

    @Autowired
    private SupplierMaintainMapper supplierMaintainMapper;

    @Override
    public List<SupplierMaintain> queryList(SupplierMaintain supplierMaintain) throws Exception{
        return supplierMaintainMapper.selectAllList(supplierMaintain);
    }

    @Override
    public Integer saveSupplier(SupplierMaintain supplierMaintain) throws Exception{
        return supplierMaintainMapper.insertSelective(supplierMaintain);
    }

    @Override
    public Integer updateSupplier(SupplierMaintain supplierMaintain) throws Exception{
        return supplierMaintainMapper.updateByPrimaryKeySelective(supplierMaintain);
    }

    @Override
    public Integer deleteById(Integer supplierId) throws Exception {
        return supplierMaintainMapper.deleteByPrimaryKey(supplierId);
    }

    @Override
    public Integer deleteAllById(List id) throws Exception{
        Map<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return supplierMaintainMapper.deleteAllBy(map);
    }
}
