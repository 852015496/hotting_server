package com.hetting.hottable.export.service;

import com.hetting.hottable.export.Entity.ExportUserEntity;
import com.hetting.hottable.export.service.impl.UserServiceImpl;
import com.hetting.hottable.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<ExportUserEntity> listexcel(String start, String end) {
        return adminMapper.queryUserList();
    }
}
