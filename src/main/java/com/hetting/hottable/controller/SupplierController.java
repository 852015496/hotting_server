package com.hetting.hottable.controller;

import com.hetting.hottable.entity.SupplierMaintain;
import com.hetting.hottable.server.impl.ISupplierServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/SupplierController",tags = "供应商信息维护")
@RestController
@RequestMapping("/SupplierController")
public class SupplierController {

    @Autowired
    private ISupplierServiceImpl supplierService;


    @PostMapping("/queryList")
    @ApiOperation(value = "供应商列表展示",httpMethod = "POST")
    public List<SupplierMaintain> queryList(@RequestBody SupplierMaintain supplierMaintian) throws Exception{
        List<SupplierMaintain> supplierList = supplierService.queryList(supplierMaintian);
        return supplierList;
    }
    @PostMapping("/saveSupplier")
    @ApiOperation(value = "添加供应商维护信息",httpMethod = "POST")
    public Integer saveSupplier(@RequestBody SupplierMaintain supplierMaintian) throws Exception{
        return supplierService.saveSupplier(supplierMaintian);
    }

    @PostMapping("/updateSupplier")
    @ApiOperation(value = "编辑供应商维护信息",httpMethod = "POST")
    public Integer updateRole(@RequestBody SupplierMaintain supplierMaintianr) throws Exception{
        return supplierService.updateSupplier(supplierMaintianr);
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "删除供应商维护信息",httpMethod = "POST")
    public Integer deleteById(@RequestBody SupplierMaintain supplierMaintian) throws Exception{
        if(null == supplierMaintian.getSupplierId()){
            return -1;
        }
        return supplierService.deleteById(supplierMaintian.getSupplierId());
    }

    @PostMapping("/deleteAllBuId")
    @ApiOperation(value = "批量删除供应商信息",httpMethod = "POST")
    public Integer deleteAllById(@RequestBody SupplierMaintain supplierMaintian) throws Exception{
        List arr = new ArrayList<>();
        String[] split = supplierMaintian.getDealerName().split(",");
        for(String str:split){
            arr.add(Integer.parseInt(str));
        }
        return supplierService.deleteAllById(arr);
    }
}
