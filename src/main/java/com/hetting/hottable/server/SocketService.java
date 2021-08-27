package com.hetting.hottable.server;

import com.hetting.hottable.entity.Socket;
import com.hetting.hottable.mapper.SocketMapper;
import com.hetting.hottable.server.impl.ISocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO 插排业务处理层
 * @Author zhangwentao
 **/
@Service("socketService")
public class SocketService implements ISocketService {

    @Autowired
    private SocketMapper socketMapper;
    /**
     * @Author ZhangWenTao
     * @Description //TODO  测温插排信息展示
     * @Date 2020/4/17
     * @Param [socket]
     * @return java.util.List<com.hetting.hottable.entity.Socket>
     **/

    @Override
    public List<Socket> socketList(Socket socket) throws Exception{
        return socketMapper.socketList(socket);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  新建测温插排信息
     * @Date 2020/4/17
     * @Param [socket]
     * @return java.lang.Integer
     **/
    @Override
    public Integer addSocket(Socket socket) throws Exception{
        return socketMapper.insertSelective(socket);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  修改测温插排信息
     * @Date 2020/4/17
     * @Param [socket]
     * @return java.lang.Integer
     **/
    @Override
    public Integer updateSocket(Socket socket) throws Exception{
        return socketMapper.updateByPrimaryKeySelective(socket);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 批量删除测温插排信息
     * @Date 2020/4/17
     * @Param [id]
     * @return java.lang.Integer
     **/
    @Override
    public Integer deleteAllSocket(List<String> id) throws Exception{
        Map<String,List<String>> map = new HashMap<>();
        map.put("id",id);
        return socketMapper.deleteALlSocket(map);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  删除单个测温插排
     * @Date 2020/4/17
     * @Param [socket]
     * @return java.lang.Integer
     **/
    @Override
    public Integer deleteSocket(Socket socket) throws Exception{
        return socketMapper.deleteByPrimaryKey(socket.getSocketId());
    }
}
