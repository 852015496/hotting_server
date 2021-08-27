package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Socket;

import java.util.List;

public interface ISocketService {
    List<Socket> socketList(Socket socket) throws Exception;

    Integer addSocket(Socket socket) throws Exception;

    Integer updateSocket(Socket socket) throws Exception;

    Integer deleteAllSocket(List<String> id) throws Exception;

    Integer deleteSocket(Socket socket) throws Exception;
}
