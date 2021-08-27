package com.hetting.hottable.server;

import com.hetting.hottable.entity.ProtocolMaintain;
import com.hetting.hottable.mapper.ProtocolMaintainMapper;
import com.hetting.hottable.server.impl.IProtocolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProtocolService implements IProtocolServiceImpl {

    @Autowired
    private ProtocolMaintainMapper protocolMaintainMapper;

    @Override
    public List<ProtocolMaintain> queryList(ProtocolMaintain protocolMaintain) throws Exception{
        return protocolMaintainMapper.queryList(protocolMaintain);
    }

    @Override
    public Integer saveProtocol(ProtocolMaintain protocolMaintain) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        String s = dateFormat.format(new Date());
        System.err.println(s);
        protocolMaintain.setCreatTime(new Date());
        return protocolMaintainMapper.insertSelective(protocolMaintain);
    }

    @Override
    public Integer updateProcotol(ProtocolMaintain protocolMaintain) throws Exception{
        return protocolMaintainMapper.updateByPrimaryKeySelective(protocolMaintain);
    }

    @Override
    public Integer deleteById(Integer protocolId) throws Exception{
        return protocolMaintainMapper.deleteByPrimaryKey(protocolId);
    }

    @Override
    public Integer deleteAllById(List<String> id) throws Exception{
        Map<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return protocolMaintainMapper.deleteAllById(map);
    }
}
