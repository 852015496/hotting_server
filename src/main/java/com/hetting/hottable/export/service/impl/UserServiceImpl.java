package com.hetting.hottable.export.service.impl;

import com.hetting.hottable.export.Entity.ExportUserEntity;

import java.util.List;

public interface UserServiceImpl {

    List<ExportUserEntity> listexcel(String start, String end);
}
