package com.hetting.hottable.export.controller;

import com.hetting.hottable.entity.ConcentMessageVO;
import com.hetting.hottable.export.Entity.ExportConcentUserMessage;
import com.hetting.hottable.export.Entity.ExportUserEntity;
import com.hetting.hottable.export.ExportUtils;
import com.hetting.hottable.server.impl.IConcentMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/ExportConcentUserController")
public class ExportConcentUserController {

    @Autowired
    private IConcentMessageService concentMessageService;

    @RequestMapping(value = "/concentUserMessage",method = RequestMethod.GET)
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
        //得到所有要导出的数据
        List<ConcentMessageVO> userlist = concentMessageService.listexcel();
        //定义导出的excel名字
        String excelName = "集中器用户信息管理表"+".xlsx";
        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("housing","小区地址");
        fieldMap.put("userName","用户姓名");
        fieldMap.put("userBuilding","用户楼号");
        fieldMap.put("lastValveRoomTemp","室内温度");
        fieldMap.put("setIndoorTemp","设定温度");
        fieldMap.put("lastHotting","热量");
        fieldMap.put("lastFlowTime", "瞬时流量");
        fieldMap.put("lastVol","累计流量");
        fieldMap.put("lastHotEntrance","供水温度");
        fieldMap.put("lastHotExit","回水温度");
        fieldMap.put("userCell","单元");
        fieldMap.put("userDoornum","房间号");
        fieldMap.put("userArea","建筑面积");
        fieldMap.put("userConcentCode","集中器代码");
        fieldMap.put("hotAddress","热表代码");
        fieldMap.put("valveAddress","阀门代码");
        fieldMap.put("hotModal","热表型号");
        fieldMap.put("valveModal","阀门型号");
        fieldMap.put("lastCooling","冷量");
        fieldMap.put("lastPower","功率");
        fieldMap.put("lastValveOpen","阀门开度");
        fieldMap.put("hotStatus","热表状态");
        fieldMap.put("valveStatus","阀门状态");
        fieldMap.put("valveWorkMode","阀门工作模式");

        //导出用户相关信息
        new ExportUtils().export(excelName,userlist,fieldMap,response);
    }
}
