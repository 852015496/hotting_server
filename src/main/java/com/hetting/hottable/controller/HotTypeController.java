package com.hetting.hottable.controller;

import com.hetting.hottable.entity.HotTypeMaintain;
import com.hetting.hottable.entity.ProtocolMaintain;
import com.hetting.hottable.entity.SupplierMaintain;
import com.hetting.hottable.server.impl.IHotTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/HotTypeController",tags = "通信协议维护")
@RestController
@RequestMapping("/HotTypeController")
public class HotTypeController {

        @Autowired
        private IHotTypeService hotTypeService;

        @PostMapping("/queryList")
        @ApiOperation(value = "热表型号列表展示",httpMethod = "POST")
        public List<HotTypeMaintain> queryList(@RequestBody HotTypeMaintain hotTypeMaintain) throws Exception{
            List<HotTypeMaintain> protocolList = hotTypeService.queryList(hotTypeMaintain);
            return protocolList;
        }
        @PostMapping("/saveHotType")
        @ApiOperation(value = "添加热表型号信息",httpMethod = "POST")
        public Integer saveHotType(@RequestBody HotTypeMaintain hotTypeMaintain) throws Exception{
            return hotTypeService.saveHotType(hotTypeMaintain);
        }

        @PostMapping("/updateHotType")
        @ApiOperation(value = "编辑热表型号信息",httpMethod = "POST")
        public Integer updateHotType(@RequestBody HotTypeMaintain hotTypeMaintain) throws Exception{
            return hotTypeService.updateProcotol(hotTypeMaintain);
        }

        @PostMapping("/deleteById")
        @ApiOperation(value = "删除热表型号信息",httpMethod = "POST")
        public Integer deleteById(@RequestBody HotTypeMaintain hotTypeMaintain) throws Exception{
            if(null == hotTypeMaintain.getHotTypeId()){
                return -1;
            }
            return hotTypeService.deleteById(hotTypeMaintain.getHotTypeId());
        }

        @PostMapping("/deleteAllBuId")
        @ApiOperation(value = "批量删除热表型号",httpMethod = "POST")
        public Integer deleteAllById(@RequestBody HotTypeMaintain hotTypeMaintain) throws Exception{
            List arr = new ArrayList<>();
            String[] split = hotTypeMaintain.getDealerName().split(",");
            for(String str:split){
                arr.add(Integer.parseInt(str));
            }
            return hotTypeService.deleteAllById(arr);
        }

    @PostMapping("/hotAndDealerName")
    @ApiOperation(value = "厂商和经销商名称",httpMethod = "POST")
    public List<SupplierMaintain> hotAndDealerName() throws Exception{
        List<SupplierMaintain> dealerName = hotTypeService.hotAndDealerName();
        return dealerName;
    }

    @PostMapping("/protoColName")
    @ApiOperation(value = "协议名称",httpMethod = "POST")
    public List<ProtocolMaintain> protoColName() throws Exception{
        List<ProtocolMaintain> protocolNameList = hotTypeService.protocolName();
        return protocolNameList;
    }
}
