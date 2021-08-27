package com.hetting.hottable.core.service;

import com.hetting.hottable.core.Entiy.UserLog;
import com.hetting.hottable.mapper.UserLogMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;


    @Override
    public void addUserLog(UserLog userLog) {
        userLogMapper.addUserLog(userLog);
    }
}
