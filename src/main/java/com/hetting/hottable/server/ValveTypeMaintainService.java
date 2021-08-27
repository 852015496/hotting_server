package com.hetting.hottable.server;

import com.hetting.hottable.entity.Valve;
import com.hetting.hottable.entity.ValveMessage;
import com.hetting.hottable.entity.ValveTypeMaintain;
import com.hetting.hottable.mapper.ValveMapper;
import com.hetting.hottable.mapper.ValveMessageMapper;
import com.hetting.hottable.mapper.ValveTypeMaintainMapper;
import com.hetting.hottable.server.impl.IValveTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValveTypeMaintainService implements IValveTypeServiceImpl {

    @Autowired
    private ValveTypeMaintainMapper valveTypeMaintainMapper;

    @Autowired
    private ValveMessageMapper valveMessageMapper;

    @Autowired
    private ValveMapper valveMapper;

    @Override
    public List<ValveTypeMaintain> queryList(ValveTypeMaintain valveTypeMaintain) throws Exception{
        return valveTypeMaintainMapper.queryList(valveTypeMaintain);
    }

    @Override
    public Integer saveValveType(ValveTypeMaintain valveTypeMaintain) throws Exception{
        valveTypeMaintain.setCreatTime(new Date());
        return valveTypeMaintainMapper.insertSelective(valveTypeMaintain);
    }

    @Override
    public Integer updateValveType(ValveTypeMaintain valveTypeMaintain) throws Exception{
        return valveTypeMaintainMapper.updateByPrimaryKeySelective(valveTypeMaintain);
    }

    @Override
    public Integer deleteById(Integer valvetypeId)throws Exception {
        return valveTypeMaintainMapper.deleteByPrimaryKey(valvetypeId);
    }

    @Override
    public Integer deleteAllById(List<String> id) throws Exception{
        Map<String,List<String>> map = new HashMap<>();
        map.put("id",id);
        return valveTypeMaintainMapper.deleteAllById(map);
    }

    public List<ValveMessage> findListByJzqAndSpare14(String s) {
        return valveMessageMapper.findListByJzqAndSpare14(s);
    }


    //------------------------------ MQTT ---------------------------------
    @Override
    public void insertMqttMessage(ValveMessage valveMessage) {
        valveMessageMapper.saveMeterMessage(valveMessage);
    }

    @Override
    public void insertMqttValve(Valve v) {
        valveMapper.insertMqttValve(v);
    }

}
