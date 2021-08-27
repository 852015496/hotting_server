package com.hetting.hottable.controller;

import com.hetting.hottable.entity.PlotMessage;
import com.hetting.hottable.entity.Socket;
import com.hetting.hottable.server.impl.ISocketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO 测温插排信息管理
 * @Author zhangwentao
 **/
@Api(value = "SocketController",tags = {"测温插排信息管理"})
@RestController
@RequestMapping("/socket")
public class SocketController {

    @Autowired
    private ISocketService socketService;


    @PostMapping("/socketList")
    @ApiOperation(value = "展示插排列表",httpMethod = "POST")
    public List<Socket> socketList(@RequestBody Socket socket) throws Exception{
        List<Socket> list = socketService.socketList(socket);
        return list;
    }


    @PostMapping("/addSocket")
    @ApiOperation(value = "添加测温插排",httpMethod = "POST")
    public  Integer addSocket(@RequestBody Socket socket) throws Exception{
        return socketService.addSocket(socket);
    }

    @PostMapping("/updateSocket")
    @ApiOperation(value = "编辑测温插排",httpMethod = "POST")
    public  Integer updateSocket(@RequestBody Socket socket) throws Exception{
        if(null == socket.getSocketId()){
            return -1;
        }
        return socketService.updateSocket(socket);
    }

    @PostMapping("/deldeteSocket")
    @ApiOperation(value = "测温插排删除",httpMethod = "POST")
    public Integer deldeteSocket(@RequestBody Socket socket) throws Exception{
        return socketService.deleteSocket(socket);
    }

    @PostMapping("/deleteAllSocket")
    @ApiOperation(value = "批量删除",httpMethod = "POST")
    public Integer deleteAllSocket(@RequestBody Socket ss) throws Exception{
        List list = new ArrayList<Integer>();
        String [] strs = ss.getSocketAddress().split(",");
        for (String str:strs){
            list.add(Integer.parseInt(str));
        }
        return socketService.deleteAllSocket(list);
    }

}
