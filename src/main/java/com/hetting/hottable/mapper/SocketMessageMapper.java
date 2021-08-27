package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.SocketMessage;

public interface SocketMessageMapper {
    int deleteByPrimaryKey(Long socketId);

    int insert(SocketMessage record);

    int insertSelective(SocketMessage record);

    SocketMessage selectByPrimaryKey(Long socketId);

    int updateByPrimaryKeySelective(SocketMessage record);

    int updateByPrimaryKey(SocketMessage record);
}