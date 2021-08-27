package com.hetting.hottable.controller;

import com.hetting.hottable.entity.ProtocolMaintain;
import com.hetting.hottable.server.impl.IProtocolServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/ProtocolController",tags = "通信协议维护")
@RestController
@RequestMapping("/ProtocolController")
public class ProtocolController {

        @Autowired
        private IProtocolServiceImpl protocolService;

        @PostMapping("/queryList")
        @ApiOperation(value = "通信协议列表展示",httpMethod = "POST")
        public List<ProtocolMaintain> queryList(@RequestBody ProtocolMaintain protocolMaintain) throws Exception{
            List<ProtocolMaintain> protocolList = protocolService.queryList(protocolMaintain);
            return protocolList;
        }

        @PostMapping("/saveProtocol")
        @ApiOperation(value = "添加通信协议维护信息",httpMethod = "POST")
        public Integer saveProtocol(@RequestBody ProtocolMaintain protocolMaintain) throws Exception{
            return protocolService.saveProtocol(protocolMaintain);
        }

        @PostMapping("/updateProtocol")
        @ApiOperation(value = "编辑通信协议维护信息",httpMethod = "POST")
        public Integer updateProtocol(@RequestBody ProtocolMaintain protocolMaintain) throws Exception{
            return protocolService.updateProcotol(protocolMaintain);
        }

        @PostMapping("/deleteById")
        @ApiOperation(value = "删除通信协议维护信息",httpMethod = "POST")
        public Integer deleteById(@RequestBody ProtocolMaintain protocolMaintain) throws Exception{
            if(null == protocolMaintain.getProtocolId()){
                return -1;
            }
            return protocolService.deleteById(protocolMaintain.getProtocolId());
        }

        @PostMapping("/deleteAllBuId")
        @ApiOperation(value = "批量删除通信协议",httpMethod = "POST")
        public Integer deleteAllById(@RequestBody ProtocolMaintain protocolMaintain) throws Exception{
            List arr = new ArrayList<>();
            String[] split = protocolMaintain.getProtocolName().split(",");
            for(String str:split){
                arr.add(Integer.parseInt(str));
            }
            return protocolService.deleteAllById(arr);
        }
}
