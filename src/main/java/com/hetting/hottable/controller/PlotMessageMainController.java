package com.hetting.hottable.controller;


import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.entity.PlotMessage;
import com.hetting.hottable.server.impl.IPlotMessageMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plotMessage")
@Api(value = "PlotMessageMainController",tags = {"小区信息维护"})
public class PlotMessageMainController {

        @Autowired
        private IPlotMessageMainService plotMessageMainService;

        @PostMapping(value = "/listPlotMessage")
        @ApiOperation(value="获取小区信息",httpMethod = "POST")
        public List<PlotMessage> listPlotMessage(@RequestBody PlotMessage plotMessage) throws Exception{
            List<PlotMessage> plotList = plotMessageMainService.listPlotMessage(plotMessage);
            return plotList;
        }

        @PostMapping(value = "/addPlot")
        @ApiOperation(value="添加小区信息",httpMethod = "POST")
        public Integer addPlot(@RequestBody PlotMessage plotMessage) throws Exception{
            return plotMessageMainService.addPlot(plotMessage);
        }

        @PostMapping(value="/updatePlotMessage")
        @ApiOperation(value = "修改小区信息",httpMethod = "POST")
        public Integer updatePlotMessage(@RequestBody PlotMessage plotMessage) throws Exception{
            if(null == plotMessage.getPlotId()){
                return -1;
            }
            return plotMessageMainService.updatePlotMessage(plotMessage);
        }

        @PostMapping(value="/deletePlotMessage")
        @ApiOperation(value = "删除小区信息",httpMethod = "POST")
        public Integer deletePlotMessage(@RequestBody PlotMessage plotMessage) throws Exception{
            if(null == plotMessage.getPlotId()){
                return -1;
            }
            return plotMessageMainService.deletePlotMessage(plotMessage.getPlotId());
        }

        @PostMapping("/updatePlotList")
        @ApiOperation(value = "修改回显数据",httpMethod = "POST")
        public PlotMessage updatePlotList(PlotMessage plotMessage) throws Exception{
            PlotMessage plotList = plotMessageMainService.updatePlotList(plotMessage);
            return plotList;
        }

        @PostMapping("/deleteAllPlotMessage")
        @ApiOperation(value = "批量删除",httpMethod = "POST")
        public Integer deleteAllPlotMessage(@RequestBody PlotMessage pm) throws Exception{
            List list = new ArrayList<Integer>();
            String [] strs = pm.getPlotName().split(",");
            for (String str:strs){
                list.add(Integer.parseInt(str));
            }
            return plotMessageMainService.deleteAllPlotMessage(list);
        }
}
