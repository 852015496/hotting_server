package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.*;
import com.hetting.hottable.export.Entity.ExportConcentUserMessage;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IConcentMessageService {

    List<ConcentMessageVO> concentUserList(ConcentMessageVO concentMessageVO) throws Exception;

    Integer deleteAll(List list) throws Exception;

    Integer deleteById(Integer userId) throws Exception;

    List<PlotMessage> listPlotMessage() throws Exception;

    Integer updateUserConcent(UserVO userVO) throws Exception;

    Integer saveMeterAdd(MeterLog meterLog) throws Exception;

    String saveMeterAddrs(List addrList) throws Exception;

    Valve valveList(Valve valve) throws Exception;

    List<ConcentMessageVO> listexcel();

    List<DataContrastVO> selectUserBuilding();

    List<DataContrastVO> selectUserDoorNum();

    List<HotAndValve> selectHotMessage(List addrList);
}
