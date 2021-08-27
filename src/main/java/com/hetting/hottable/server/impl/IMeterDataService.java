package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.DataContrastVO;
import com.hetting.hottable.entity.Hot;
import com.hetting.hottable.entity.MeterData;

import java.util.ArrayList;
import java.util.List;

public interface IMeterDataService {
    List<MeterData> materMessageList(MeterData materData) throws Exception;

    Integer deleteByMeterDataMessage(List list) throws Exception;

    ArrayList<Object> hotAndVolContrast(DataContrastVO dataContrastVO);

    Integer selectConcentCodeById(List list);
}
