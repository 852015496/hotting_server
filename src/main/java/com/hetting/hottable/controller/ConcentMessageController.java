package com.hetting.hottable.controller;


import com.alibaba.fastjson.JSONObject;
import com.hetting.hottable.connect.TcpService;
import com.hetting.hottable.entity.*;
import com.hetting.hottable.server.impl.IConcentMessageService;
import com.hetting.hottable.server.impl.IConcentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Api(value = "ConcentMessageController",tags = {"设备信息配置控制"})
@RestController
@RequestMapping("/concentMessage")
public class ConcentMessageController {

    @Autowired
    private IConcentMessageService concentMessageService;

    @Autowired
    private TcpService tcpService;


    /**
     * @Author ZhangWenTao
     * @Description //TODO 集中器下的用户展示
     * @Date 2020/8/31
     * @Param [concentMessageVO]
     * @return java.util.List<com.hetting.hottable.entity.ConcentMessageVO>
     **/
    @PostMapping("/concentUserList")
    @ApiOperation(value = "集中器下用户信息展示",httpMethod = "POST")
    public List<ConcentMessageVO> concentUserList(@RequestBody ConcentMessageVO concentMessageVO) throws Exception{
        List<ConcentMessageVO> list = concentMessageService.concentUserList(concentMessageVO);
        return list;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  更改集中器下用的信息
     * @Date 2020/8/31
     * @Param [userVO]
     * @return java.lang.Integer
     **/
    @PostMapping("/updateUserConcent")
    @ApiOperation(value = "编辑用户集中器管理",httpMethod = "POST")
    public Integer updateUserConcent(@RequestBody UserVO userVO) throws Exception{
        if(null == userVO.getUserId()){
            return -1;
        }
        return concentMessageService.updateUserConcent(userVO);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  回显集中器下设备的工作模式对应的参数
     * @Date 2020/8/31
     * @Param [valve]
     * @return java.lang.Object
     **/
    @PostMapping("/valveList")
    @ApiOperation(value = "回显集中下用户的信息和工作模式对应的参数",httpMethod = "POST")
    public Object valveList(@RequestBody Valve valve) throws Exception{
        Valve messageList = concentMessageService.valveList(valve);
        return messageList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据集中器的Code删除
     * @Date 2020/8/31
     * @Param [user]
     * @return java.lang.Integer
     **/
    @PostMapping("/deleteById")
    @ApiOperation(value = "根据集中器Code删除一条信息",httpMethod = "POST")
    public Integer deleteById(@RequestBody UserVO user) throws Exception{
        return concentMessageService.deleteById(user.getUserId());
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  批量删除集中器下用户信息
     * @Date 2020/8/31
     * @Param [user]
     * @return java.lang.Integer
     **/
    @PostMapping("/deleteAll")
    @ApiOperation(value = "仪表配置信息批量删除",httpMethod = "POST")
    public Integer deleteAll(@RequestBody UserVO user) throws Exception{
        //创建数组
        List list = new ArrayList<Integer>();
        //根据UserName来接收id,进行分割
        String [] strs = user.getUserName().split(",");
        //循环取值
        for (String str:strs){
            list.add(str);
        }
        return concentMessageService.deleteAll(list);
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO   获取小区地址
     * @Date 2020/8/31
     * @Param []
     * @return java.util.List<com.hetting.hottable.entity.PlotMessage>
     **/
    @PostMapping(value = "/plotList",consumes = "application/json")
    @ApiOperation(value = "小区展示",httpMethod = "POST")
    public List<PlotMessage> plotList() throws Exception{
        List<PlotMessage> plotList = concentMessageService.listPlotMessage();
        return plotList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  点名抄表
     * @Date 2020/8/31
     * @Param [meterLog]
     * @return java.lang.Integer
     **/
    @PostMapping("/saveMeterAdd")
    @ApiOperation(value = "点名抄表信息存储",httpMethod = "POST")
    public Integer saveMeterAdd(@RequestBody MeterLog meterLog) throws Exception{
        return concentMessageService.saveMeterAdd(meterLog);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  批量点名抄表
     * @Date 2020/8/31
     * @Param [meterLog]
     * @return java.lang.Integer
     **/
    @PostMapping("/saveMeterAddrs")
    @ApiOperation(value = "批量点名抄表信息存储",httpMethod = "POST")
    public Integer saveMeterAddrs(@RequestBody MeterLog meterLog) throws Exception{
        List addrList = new ArrayList<>();
        String[] split = meterLog.getMeterAddr().split(",");
        for (String str: split) {
            addrList.add(str);
        }
        String addr = concentMessageService.saveMeterAddrs(addrList);
        List<HotAndValve> meters = concentMessageService.selectHotMessage(addrList);
        int resultType = meterLog.getResultType();
        return tcpService.callReading(addr,resultType,meters);
    }

    @ApiOperation(value = "用户楼号",httpMethod = "POST")
    @PostMapping("/selectUserBuilding")
    public List<DataContrastVO> selectUserBuilding(){
        return concentMessageService.selectUserBuilding();
    }

    @ApiOperation(value = "用户楼号",httpMethod = "POST")
    @PostMapping("/selectUserDoorNum")
    public List<DataContrastVO> selectUserDoorNum(){
        return concentMessageService.selectUserDoorNum();
    }
}
