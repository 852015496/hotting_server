package com.hetting.hottable.export.controller;

import com.hetting.hottable.export.Entity.ExportUserEntity;
import com.hetting.hottable.export.ExportUtils;
import com.hetting.hottable.export.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Controller
@RequestMapping("/ExportUserController")
public class ExportUserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/home/setting/firm",method = RequestMethod.GET)
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
        //这里是笔者实际业务需求中需要得到时间间隔。可忽略
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        System.out.println("打印的起始日期为："+start+"，打印的结束日期为："+end);
        //得到所有要导出的数据
        List<ExportUserEntity> userlist = userService.listexcel(start,end);
        //定义导出的excel名字
        String excelName = "用户信息表";
        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("adminId","编号");
        fieldMap.put("userName","用户姓名");
        fieldMap.put("adminUserName","用户账号");
        fieldMap.put("adminPostbox","用户邮箱");
        fieldMap.put("adminPhone","用户电话");
        fieldMap.put("userRole","用户角色");
        fieldMap.put("createDate", "创建时间");
        fieldMap.put("adminDescribe","详情描述");

        //导出用户相关信息
        new ExportUtils().export(excelName,userlist,fieldMap,response);
    }
}
