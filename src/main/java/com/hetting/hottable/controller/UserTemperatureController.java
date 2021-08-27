package com.hetting.hottable.controller;

import com.hetting.hottable.connect.TcpService;
import com.hetting.hottable.entity.*;
import com.hetting.hottable.server.impl.IUserTemperatureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO    用户室温监控
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Api(value = "/userTemperature",tags = "用户室温监控")
@RestController
@RequestMapping("/userTemperature")
public class UserTemperatureController {

    @Autowired
    private IUserTemperatureService userTemperatureService;

    @Autowired
    private TcpService tcpService;

    @PostMapping("/userTemperatureList")
    @ApiOperation(value = "获取用户信息和温度",httpMethod = "POST")
    public List<UserTemperature> userTemperatureList(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> tempList = userTemperatureService.userTemperatureList(userTemperature);
        return tempList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 点名阀控
     * @Date 2020/10/13
     * @Param [valve]
     * @return java.lang.Integer
     **/
    @PostMapping("/updateValveWorkMode")
    @ApiOperation(value = "阀门工作模式设定",httpMethod = "POST")
    public Integer updateValveWorkMode (@RequestBody Valve valve) throws Exception{
        String addr = userTemperatureService.selectConcentCodeByWorkModal(valve);
        List<MeterData> valves = userTemperatureService.selectValveMessage(addr);
        return tcpService.callControl(addr,valves);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 点名阀控
     * @Date 2020/10/13
     * @Param [valve]
     * @return java.lang.Integer
     **/
    @PostMapping("/addDefinedValve")
    @ApiOperation(value = "自定义阀门开度设定",httpMethod = "POST")
    public Integer addDefinedValve(@RequestBody Valve valve) throws Exception{
        String addr = userTemperatureService.selectConcentCodeByWorkModal(valve);
        List<MeterData> valves = userTemperatureService.selectValveMessage(addr);
        return tcpService.callControl(addr,valves);
    }

    @PostMapping("/addIndoorTemp")
    @ApiOperation(value = "设定用户室温",httpMethod = "POST")
    public Integer addIndoorTemp(@RequestBody Valve valve) throws Exception{
        return userTemperatureService.addIndoorTemp(valve);
    }


    @PostMapping("/indoorTempAvg")
    @ApiOperation(value = "室内温度日平均分布",httpMethod = "POST")
    public List<UserTemperature> indoorTempAvg(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.indoorTempAvg(userTemperature);
        return userMapList;
    }

    @PostMapping("/userSum")
    @ApiOperation(value = "室内温度的用户总数",httpMethod = "POST")
    public List<UserTemperature> userSum(@RequestBody User user) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.userSum(user);
        return userMapList;
    }


    @PostMapping("/eighteenUnderUserMap")
    @ApiOperation(value = "18℃以下用户7日比例趋势曲线",httpMethod = "POST")
    public List<UserTemperature> eighteenUnderUserMap(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.eighteenUnderUserMap(userTemperature);
        return userMapList;
    }

    @PostMapping("/twentyFourUnderUserMap")
    @ApiOperation(value = "24℃以上用户7日比例趋势曲线",httpMethod = "POST")
    public List<UserTemperature> twentyFourUnderUserMap(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.twentyFourUnderUserMap(userTemperature);
        return userMapList;
    }

    @PostMapping("/indoorTempValveData")
    @ApiOperation(value = "室温温度阀门趋势数据",httpMethod = "POST")
    public List<UserTemperature> indoorTempValveData(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.indoorTempValveData(userTemperature);
        return userMapList;
    }

    @PostMapping("/toAndForTemp")
    @ApiOperation(value = "供回水温度趋势",httpMethod = "POST")
    public List<UserTemperature> toAndForTemp(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.toAndForTemp(userTemperature);
        return userMapList;
    }

    @PostMapping("/allUserAvgTemp")
    @ApiOperation(value = "7日用户平均温度",httpMethod = "POST")
    public List<UserTemperature> allUserAvgTemp(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> userMapList = userTemperatureService.allUserAvgTemp(userTemperature);
        return userMapList;
    }




}
