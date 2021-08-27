package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.DataContrastVO;
import com.hetting.hottable.entity.MeterData;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MeterDataMapper {

    List<MeterData> materMessageList(MeterData materData);

    Integer deleteByMeterDataMessage(Map<String, List<String>> id);

    Integer selectConcentCodeById(HashMap<String, List<String>> map);

    List<MeterData> selectValveMessage(String addr);
}
