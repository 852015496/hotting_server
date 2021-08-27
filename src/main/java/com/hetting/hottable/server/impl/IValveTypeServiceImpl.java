package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Valve;
import com.hetting.hottable.entity.ValveMessage;
import com.hetting.hottable.entity.ValveTypeMaintain;

import java.util.List;

public interface IValveTypeServiceImpl {

    List<ValveTypeMaintain> queryList(ValveTypeMaintain valveTypeMaintain) throws Exception;

    Integer saveValveType(ValveTypeMaintain valveTypeMaintain) throws Exception;

    Integer updateValveType(ValveTypeMaintain valveTypeMaintain) throws Exception;

    Integer deleteById(Integer valvetypeId) throws Exception;

    Integer deleteAllById(List<String> id) throws Exception;

    void insertMqttMessage(ValveMessage valveMessage);

    void insertMqttValve(Valve v);
}
