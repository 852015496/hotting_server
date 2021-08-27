package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Alarm;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IFacilityService {

    Map<String,Object> unfinishedFacility(Alarm alarm);
}
