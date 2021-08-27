package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.PlotMessage;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface PlotMessageMapper {

    int deleteByPrimaryKey(Integer plotId);

    int insert(PlotMessage record);

    int insertSelective(PlotMessage record);

    PlotMessage selectByPrimaryKey(Integer plotId);

    int updateByPrimaryKeySelective(PlotMessage record);

    int updateByPrimaryKey(PlotMessage record);

    List<PlotMessage> selectAll();

    List<PlotMessage> listPlotMessage(PlotMessage plotMessage);

    Integer deleteAllMessage(Map<String,List<String>> id);

    List<PlotMessage> plotList();

    List<PlotMessage> selectByCreatBy();
}