package com.hetting.hottable.controller;

import com.hetting.hottable.entity.IndoorTemp;
import com.hetting.hottable.entity.UserTemperature;
import com.hetting.hottable.server.impl.IIndoorTempServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Api(value = "/IndoorTemp",tags = "室内温度达标率")
@Controller
@RequestMapping("/IndoorTempController")
public class IndoorTempController {

    @Autowired
    private IIndoorTempServiceImpl indoorTempService;

    @RequestMapping("/avgIndoorTemp")
    @ResponseBody
    @ApiOperation(value = "室温达标率平均室温",httpMethod = "POST")
    public String avgIndoorTemp(String plotAddress){
        String avgTemp = indoorTempService.avgIndoorTemp(plotAddress);
        return avgTemp;
    }

    @RequestMapping("/avgInflowTemp")
    @ResponseBody
    @ApiOperation(value = "室温达标率平均供水温度",httpMethod = "POST")
    public String avgInflowTemp(String plotAddress){
        String avgInflowTemp = indoorTempService.avgInflowTemp(plotAddress);
        return avgInflowTemp;
    }

    @RequestMapping("/avgOutflowTemp")
    @ResponseBody
    @ApiOperation(value = "室温达标率平均回水温度",httpMethod = "POST")
    public String avgOutflowTemp(String plotAddress){
        String avgOutflowTemp = indoorTempService.avgOutflowTemp(plotAddress);
        return avgOutflowTemp;
    }

    @RequestMapping("/avgInflowTempMinusOutflowTemp")
    @ResponseBody
    @ApiOperation(value = "室温达标率平均供回水温差",httpMethod = "POST")
    public String avgInflowTempMinusOutflowTemp(String plotAddress){
        String avgInAndOutflowTemp = indoorTempService.avgInflowTempMinusOutflowTemp(plotAddress);
        return avgInAndOutflowTemp;
    }

    @RequestMapping("/buildingList")
    @ResponseBody
    @ApiOperation(value = "小区下楼号单元温度",httpMethod = "POST")
    public Map<String,List<IndoorTemp>> buildingList(String plotAddress){
        Map<String,List<IndoorTemp>> building = indoorTempService.builidingList(plotAddress);
        return building;
    }

    @RequestMapping("/cellList")
    @ResponseBody
    @ApiOperation(value = "小区下楼号单元温度",httpMethod = "POST")
    public Map<String,List<IndoorTemp>> cellList(String userBuilding){
        Map<String,List<IndoorTemp>> building = indoorTempService.cellList(userBuilding);
        return building;
    }

    @RequestMapping("/indoorTemp")
    @ResponseBody
    @ApiOperation(value = "供暖效果达标率",httpMethod = "POST")
    public List<UserTemperature> indoorTemp(){
        List<UserTemperature> indoorTempList = indoorTempService.indoorTemp();
        return indoorTempList;
    }

    @RequestMapping("/doorTempData")
    @ResponseBody
    @ApiOperation(value = "房间数据详情",httpMethod = "POST")
    public List<IndoorTemp> doorTempData(String userDoorNum){
        List<IndoorTemp> doorDataList = indoorTempService.doorTempData(userDoorNum);
        return doorDataList;
    }




}
