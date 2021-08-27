package com.hetting.hottable.controller;

import com.alibaba.fastjson.JSONObject;
import com.hetting.hottable.connect.TcpService;
import com.hetting.hottable.entity.DataContrastVO;
import com.hetting.hottable.entity.Hot;
import com.hetting.hottable.entity.MeterData;
import com.hetting.hottable.server.impl.IMeterDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api(value = "MaterDataController",tags = "抄表业务管理")
@RestController
@RequestMapping("/materDataController")
public class MeterDataController {

    @Autowired
    private IMeterDataService materDataService;

    @Autowired
    private TcpService tcpService;


    /**
     * @Author ZhangWenTao
     * @Description //TODO  抄表数据读取  抄表数据展示
     * @Date 2020/4/26
     * @Param [materData]
     * @return java.util.List<com.hetting.hottable.entity.MaterData>
     **/
    @PostMapping("/materMessageList")
    @ApiOperation(value = "抄表数据读取" , httpMethod = "POST")
    public List<MeterData> materMessageList(@RequestBody MeterData materData) throws Exception{
        List<MeterData> dataList = materDataService.materMessageList(materData);
        return dataList;
    }


    @PostMapping("/deleteByMeterDataMessage")
    @ApiOperation(value = "抄表批量删除",httpMethod = "POST")
    public Integer deleteByMeterDataMessage(@RequestBody MeterData meterData) throws Exception{
        List list = new ArrayList<Integer>();
        String [] strs = meterData.getConcentCode().split(",");
        for (String str:strs){
            list.add(str);
        }
        return materDataService.deleteByMeterDataMessage(list);
    }

    @ApiOperation(value = "热量和流量数据对比",httpMethod = "POST")
    @PostMapping("/hotAndVolContrast")
    public Object hotAndVolContrast(@RequestBody DataContrastVO dataContrastVO){
        ArrayList<Object> hotAndVol = materDataService.hotAndVolContrast(dataContrastVO);
        System.err.println(hotAndVol);
//        JSONObject object = new JSONObject();
//        for (Object list : hotAndVol) {
//            object.put("热量 流量",)
//        }
//        object.put("热量 冷量",arr1);
//        object.put("热量 冷量",arr2);
        return hotAndVol;
    }


    @ApiOperation(value = "下发集中器地址",httpMethod = "POST")
    @GetMapping("/loadAddress")
    public void loadAddress(@RequestParam(value = "flag",required = false,defaultValue = "0") int flag,
                            @RequestParam(value = "all",required = false,defaultValue = "1") int all,
                            String address){
        tcpService.loadAddress(flag, all, address);
    }


    @PostMapping("/concentCodeById")
    @ApiOperation(value = "抄表批量删除",httpMethod = "POST")
    public Integer concentCodeById(@RequestBody MeterData meterData) throws Exception{
        List list = new ArrayList<Integer>();
        String [] strs = meterData.getConcentCode().split(",");
        for (String str:strs){
            list.add(str);
        }
        return materDataService.selectConcentCodeById(list);
    }


}
