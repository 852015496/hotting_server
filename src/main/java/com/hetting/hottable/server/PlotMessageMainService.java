package com.hetting.hottable.server;


import com.hetting.hottable.entity.PlotMessage;
import com.hetting.hottable.mapper.PlotMessageMapper;
import com.hetting.hottable.server.impl.IPlotMessageMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("plotMessageMainService")
public class PlotMessageMainService implements IPlotMessageMainService {


    @Autowired
    private PlotMessageMapper plotMessageMapper;


    /**
     * @Author ZhangWenTao
     * @Description //TODO 增加小区信息
     * @Date 2020/4/9
     * @Param [plotMessage]
     * @return java.lang.Integer
     **/
    @Override
    public Integer addPlot(PlotMessage plotMessage) throws Exception{
        return plotMessageMapper.insertSelective(plotMessage);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  更改小区信息
     * @Date 2020/4/9
     * @Param [plotMessage]
     * @return java.lang.Integer
     **/

    @Override
    public Integer updatePlotMessage(PlotMessage plotMessage) throws Exception{
        return plotMessageMapper.updateByPrimaryKeySelective(plotMessage);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 删除小区信息
     * @Date 2020/4/9
     * @Param [plotId]
     * @return java.lang.Integer
     **/

    @Override
    public Integer deletePlotMessage(Integer plotId) throws Exception{
        return plotMessageMapper.deleteByPrimaryKey(plotId);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 展示小区信息
     * @Date 2020/4/9
     * @Param [plotMessage]
     * @return java.util.List<com.hetting.hottable.entity.PlotMessage>
     **/

    @Override
    public List<PlotMessage> listPlotMessage(PlotMessage plotMessage) throws Exception{
        return plotMessageMapper.listPlotMessage(plotMessage);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 根据小区ID回显小区数据
     * @Date 2020/4/9
     * @Param [plotMessage]
     * @return com.hetting.hottable.entity.PlotMessage
     **/

    @Override
    public PlotMessage updatePlotList(PlotMessage plotMessage) throws Exception{
        return plotMessageMapper.selectByPrimaryKey(plotMessage.getPlotId());
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 批量删除小区信息
     * @Date 2020/4/13
     * @Param [id]
     * @return java.lang.Integer
     **/

    @Override
    public Integer deleteAllPlotMessage(List<String> id) throws Exception{
        Map<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return plotMessageMapper.deleteAllMessage(map);
    }


    public List<PlotMessage> selectByCreateBy() {
        return plotMessageMapper.selectByCreatBy();
    }
}
