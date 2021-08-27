package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.Socket;

import java.util.List;
import java.util.Map;

public interface SocketMapper {
    int deleteByPrimaryKey(Integer socketId);

    int insert(Socket record);

    int insertSelective(Socket record);

    Socket selectByPrimaryKey(Integer socketId);

    int updateByPrimaryKeySelective(Socket record);

    int updateByPrimaryKey(Socket record);

    List<Socket> socketList(Socket socket);

    Integer deleteALlSocket(Map<String, List<String>> id);
}