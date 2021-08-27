package com.hetting.hottable.export.controller;

import com.hetting.hottable.entity.MeterData;
import com.hetting.hottable.export.ExportUtils;
import com.hetting.hottable.server.impl.IMeterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/ExportMeterController")
public class ExportMeterController {

    @Autowired
    private IMeterDataService materDataService;

    @RequestMapping(value = "/MeterDataMessage",method = RequestMethod.GET)
    public void ExportBankCkeckInfo(HttpServletResponse response,
                                    HttpServletRequest request,
                                    @RequestBody MeterData meterData) throws Exception {
        //得到所有要导出的数据
        List<MeterData> userlist = materDataService.materMessageList(meterData);
        //定义导出的excel名字
        String excelName = "集中器用户信息管理表"+".xlsx";
        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("housing","小区地址");
        fieldMap.put("userName","用户姓名");
        fieldMap.put("hotting","当前热量");
        fieldMap.put("vol","累计流量");
        fieldMap.put("flowTime","瞬时流量");
        fieldMap.put("hotEntrance","供水温度");
        fieldMap.put("hotExit","回水温度");
        fieldMap.put("valveRoomTemp","室内温度");
        fieldMap.put("setTemp","设置温度");
        fieldMap.put("hotAddress","热表地址代码");
        fieldMap.put("userBuilding","楼号");
        fieldMap.put("userArea","面积");
        fieldMap.put("userCell","单元");
        fieldMap.put("userDoorNum","房间号");
        fieldMap.put("meterTime","抄表日期");
        fieldMap.put("addupTime","表累计时间");
        fieldMap.put("concentCode","集中器地址代码");
        fieldMap.put("valveAddress","阀门地址代码");
        fieldMap.put("power","功率");
        fieldMap.put("valveStatus","阀门状态");
        fieldMap.put("hotStatus","热表状态");
        //导出用户相关信息
        new ExportUtils().export(excelName,userlist,fieldMap,response);
    }
}
