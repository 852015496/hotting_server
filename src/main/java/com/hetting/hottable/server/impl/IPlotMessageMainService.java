package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.PlotMessage;

import java.util.List;

public interface IPlotMessageMainService {

    Integer addPlot(PlotMessage plotMessage) throws Exception;

    Integer updatePlotMessage(PlotMessage plotMessage) throws Exception;

    Integer deletePlotMessage(Integer plotId) throws Exception;

    List<PlotMessage> listPlotMessage(PlotMessage plotMessage) throws Exception;

    PlotMessage updatePlotList(PlotMessage plotMessage) throws Exception;

    Integer deleteAllPlotMessage(List<String> id) throws Exception;
}
