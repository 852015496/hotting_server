package com.hetting.hottable.core.service;

import com.hetting.hottable.core.Entiy.SystemLog;
import com.hetting.hottable.mapper.SystemLogMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;


    @Transactional(rollbackFor = Exception.class)
    public void addLog(SystemLog systemLog) throws Exception{
        if(ObjectUtils.isNotEmpty(systemLog)){
            systemLogMapper.addLog(systemLog);
        }

    }

}
