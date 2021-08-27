package com.hetting.hottable.controller;

import com.hetting.hottable.entity.ValveTypeMaintain;
import com.hetting.hottable.server.impl.IValveTypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/ValveTypeController",tags = "阀门型号维护")
@RestController
@RequestMapping("/ValveTypeController")
public class ValveTypeController{

    @Autowired
    private IValveTypeServiceImpl valveTypeService;

        @PostMapping("/queryList")
        @ApiOperation(value = "阀门型号列表展示",httpMethod = "POST")
        public List<ValveTypeMaintain> queryList(@RequestBody ValveTypeMaintain valveTypeMaintain) throws Exception{
            List<ValveTypeMaintain> valveList = valveTypeService.queryList(valveTypeMaintain);
            return valveList;
        }
        @PostMapping("/saveValveType")
        @ApiOperation(value = "添加阀门型号维护信息",httpMethod = "POST")
        public Integer saveValveType(@RequestBody ValveTypeMaintain valveTypeMaintain) throws Exception{
            return valveTypeService.saveValveType(valveTypeMaintain);
        }

        @PostMapping("/updateValveType")
        @ApiOperation(value = "编辑阀门型号维护信息",httpMethod = "POST")
        public Integer updateValveType(@RequestBody ValveTypeMaintain valveTypeMaintain) throws Exception{
            return valveTypeService.updateValveType(valveTypeMaintain);
        }

        @PostMapping("/deleteById")
        @ApiOperation(value = "删除阀门型号维护信息",httpMethod = "POST")
        public Integer deleteById(@RequestBody ValveTypeMaintain valveTypeMaintain) throws Exception{
            if(null == valveTypeMaintain.getValveTypeId()){
                return -1;
            }
            return valveTypeService.deleteById(valveTypeMaintain.getValveTypeId());
        }

        @PostMapping("/deleteAllBuId")
        @ApiOperation(value = "批量删除阀门信息",httpMethod = "POST")
        public Integer deleteAllById(@RequestBody ValveTypeMaintain valveTypeMaintain) throws Exception{
            List arr = new ArrayList<>();
            String[] split = valveTypeMaintain.getValveVenderName().split(",");
            for(String str:split){
                arr.add(Integer.parseInt(str));
            }
            return valveTypeService.deleteAllById(arr);
        }
}
