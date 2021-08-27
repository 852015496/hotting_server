package com.hetting.hottable.controller;


import com.hetting.hottable.entity.Alarm;
import com.hetting.hottable.entity.AlarmDetails;
import com.hetting.hottable.server.impl.IAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value = "/facilityController",tags = "设备报警事件")
@RestController
@RequestMapping("/facilityController")
public class AlarmController {

    @Autowired
    private IAlarmService alarmService;

    /**
     * @Author ZhangWenTao
     * @Description //TODO 未处理table 展示
     * @Date 2020/8/31
     * @Param [alarm]
     * @return java.util.List<com.hetting.hottable.entity.Alarm>
     **/
    @PostMapping("/unfinishedFacility")
    @ApiOperation(value = "设备未处理事件列表",httpMethod = "POST")
    public List<Alarm> unfinishedFacility(@RequestBody Alarm alarm) throws Exception{
        List<Alarm> facilityList = alarmService.unfinishedFacility(alarm);
        return facilityList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  报警记录展示
     * @Date 2020/8/31
     * @Param [alarm]
     * @return java.util.List<com.hetting.hottable.entity.Alarm>
     **/
    @PostMapping("/facilityQueryList")
    @ApiOperation(value = "报警记录展示",httpMethod = "POST")
    public List<Alarm> facilityQueryList(@RequestBody Alarm alarm) throws Exception{
        List<Alarm> facilityList = alarmService.facilityList(alarm);
        return facilityList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 设备处理完成列表展示
     * @Date 2020/8/31
     * @Param [alarm]
     * @return java.util.List<com.hetting.hottable.entity.Alarm>
     **/
    @PostMapping("/processedFacility")
    @ApiOperation(value = "设备已处理事件列表",httpMethod = "POST")
    public List<Alarm> processedFacility(@RequestBody Alarm alarm) throws Exception{
        List<Alarm> facilityList = alarmService.processedFacility(alarm);
        return facilityList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 故障设备通过mqtt获取API吧故障设备存入db
     * @Date 2020/8/31
     * @Param []
     * @return java.lang.Integer
     **/
    @GetMapping("/saveFacility")
    @ApiOperation(value = "把故障设备信息放入报警",httpMethod = "GET")
    public String saveFacility() throws Exception{
        alarmService.saveFacility();
        return "故障信息传输已运行!!!";
    }


    @PostMapping("/queryFacilityList")
    @ApiOperation(value = "故障处理展示",httpMethod = "POST")
    public List<AlarmDetails> queryFacilityList(@RequestBody AlarmDetails alarmDetails) throws Exception{
        List<AlarmDetails> facilityList = alarmService.queryFacilityList(alarmDetails);
        return facilityList;
    }

    @PostMapping("/saveMessageContent")
    @ApiOperation(value = "故障处理记录",httpMethod = "POST")
    public Integer saveMessageContent(@RequestBody AlarmDetails alarmDetails) throws Exception{
        return alarmService.saveMessageContent(alarmDetails);
    }

    @PostMapping("/alarmsImg")
    @ApiOperation(value = "7日报警趋势图",httpMethod = "POST")
    public List<Alarm> alarmsImg(@RequestBody Alarm alarm) throws Exception{
        List<Alarm> alarmList = alarmService.alarmsImg(alarm);
        return alarmList;
    }
}
