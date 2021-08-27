package com.hetting.hottable.server;


import com.hetting.hottable.entity.Alarm;
import com.hetting.hottable.mapper.AlarmMapper;
import com.hetting.hottable.mapper.HotMapper;
import com.hetting.hottable.mapper.ValveMapper;
import com.hetting.hottable.server.impl.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private AlarmMapper alarmMapper;

    @Autowired
    private HotMapper hotMapper;

    @Autowired
    private ValveMapper vavleMapper;

    @Override
    public Map<String,Object> unfinishedFacility(Alarm alarm) {
        HashMap<String, Object> mapList = new HashMap<>();
        List<Alarm> concent = alarmMapper.unfinishedFacility(alarm);
        List<Alarm> hot = hotMapper.unfinishedFacility(alarm);
        List<Alarm> valve = vavleMapper.unfinishedFacility(alarm);
        mapList.put("concent",concent);
        mapList.put("hot",hot);
        mapList.put("valve",valve);
        return mapList;
    }
}
