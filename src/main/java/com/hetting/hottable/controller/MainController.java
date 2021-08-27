package com.hetting.hottable.controller;

import com.alibaba.fastjson.JSONObject;
import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.PlotMessage;
import com.hetting.hottable.entity.UserTemperature;
import com.hetting.hottable.server.impl.IMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/mainController",tags = "用户首页")
@RestController
@RequestMapping("/mainController")
public class MainController {

    @Autowired
    private IMainService mainService;


    /*
     * @Author ZhangWenTao
     * @Description //TODO 首页 -->室内温度日平均分布
     * @Date 2020/8/31
     * @Param [userTemperature]
     * @return java.util.List<com.hetting.hottable.entity.UserTemperature>
     **/
    @PostMapping("/userTempDayAvg")
    @ApiOperation(value = "全部用户室内日平均分布",httpMethod = "POST")
    public List<UserTemperature> userTempDayAvg(@RequestBody UserTemperature userTemperature) throws Exception{
        List<UserTemperature> mainList = mainService.userTempDayAvg(userTemperature);
        return mainList;
    }


    /*
     * @Author ZhangWenTao
     * @Description //TODO  供热公司能耗数据 --> 供暖面积
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/userNumArea")
    @ApiOperation(value = "用户供热总面积", httpMethod = "POST")
    public List<String> userNumArea () throws Exception{
        List<String> areaList = mainService.userNumArea();
        return areaList;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  热量
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/hotSum")
    @ApiOperation(value = "总热量", httpMethod = "POST")
    public List<String> hotSum () throws Exception{
        List<String> hotList = mainService.hotSum();
        return hotList;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  热单耗
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/hotSingleSum")
    @ApiOperation(value = "热单耗", httpMethod = "POST")
    public List<String> hotSingleSum () throws Exception{
        List<String> hotList = mainService.hotSingleSum();
        return hotList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  平均温度
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/avgTemp")
    @ApiOperation(value = "平均温度", httpMethod = "POST")
    public List<String> avgTemp () throws Exception{
        List<String> hotList = mainService.avgTemp();
        return hotList;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  热表和阀门数量
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/hotAndValveNum")
    @ApiOperation(value = "热表和阀门数量", httpMethod = "POST")
    public List<String> hotAndValveNum () throws Exception{
        List<String> hotList = mainService.hotAndValveNum();
        return hotList;
    }


    /*
     * @Author ZhangWenTao
     * @Description //TODO  集中器数量
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/concentNum")
    @ApiOperation(value = "集中器数量", httpMethod = "POST")
    public List<String> concentNum () throws Exception{
        List<String> hotList = mainService.concentNum();
        return hotList;
    }


    /*
     * @Author ZhangWenTao
     * @Description //TODO  集中器 热表 阀门 故障数量
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/faultNum")
    @ApiOperation(value = "故障数量", httpMethod = "POST")
    public List<String> faultNum () throws Exception{
        List<String> hotList = mainService.faultNum();
        return hotList;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  设备运行状态监控
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.util.List<com.hetting.hottable.entity.Concent>
     **/
    @PostMapping("/allNumberCount")
    @ApiOperation(value = "设备运行状态监控", httpMethod = "POST")
    public List<Concent> allNumberCount (@RequestBody Concent concent) throws Exception{
        List<Concent> hotList = mainService.allNumberCount(concent);
        return hotList;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  阀门热表故障百分比
     * @Date 2020/8/31
     * @Param []
     * @return java.lang.Object
     **/
    @PostMapping("/valveHotFault")
    @ApiOperation(value = "阀门热表故障百分比", httpMethod = "POST")
    public Object valveHotFault () throws Exception{
        Concent hotList = mainService.valveHotFault();
        JSONObject object = new JSONObject();
        object.put("正常表/阀",hotList.getNormalNum());
        object.put("故障表/阀",hotList.getFaultNum());
        return object;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  集中器故障百分比
     * @Date 2020/8/31
     * @Param []
     * @return java.lang.Object
     **/
    @PostMapping("/concentNormalAndFault")
    @ApiOperation(value = "集中器故障百分比", httpMethod = "POST")
    public Object concentNormalAndFault () throws Exception{
        Concent concent =  mainService.concentNormalAndFault();
        JSONObject object = new JSONObject();
        object.put("正常集中器",concent.getConcentCount());
        object.put("故障集中器",concent.getFaultConcentCount());
        return object;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  用户平均温度
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/setTemp")
    @ApiOperation(value = "用户平均设定温度",httpMethod = "POST")
    public List<String> setTemp() throws Exception{
        List<String> tempList = mainService.setTemp();
        return tempList;
    }

    @PostMapping("/plotList")
    @ApiOperation(value = "室温达标率",httpMethod = "POST")
    public List<PlotMessage> plotList() throws Exception{
        List<PlotMessage> plotNameList = mainService.plotList();
        return plotNameList;
    }




}
