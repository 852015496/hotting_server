package com.hetting.hottable.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 搭建测试
 */
@RestController
@Api(tags = "搭建Boot")
@RequestMapping("/test")
public class Test {


    /**
     * 测试类
     * @return
     */
    @RequestMapping("/hello")
    @ApiOperation(value = "搭建测试",notes = "测试是否成功返回页面")
    public  String hello(){
        return "mamba out!!!!";
    }




    public static void main(String[] args) {
        String dateStr = "2020-6-23";
        String dateStr2 = "2020-6-24";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);
            int days = (int) ((date2.getTime() - date.getTime()) / (1000 * 3600 * 24));//1000 * 3600 * 24 一天
            System.out.println("两个日期的差距：" + days);
        } catch (Exception e) {
            e.printStackTrace();
        }
       String pass = "111111";
        Md5Hash md5Hash = new Md5Hash(pass.getBytes());
        System.err.println(md5Hash);
    }




    /**
     * crc3获取方法
     *
     * @param result
     * @return
     */
    public static String crc3(String result) {
        String crc31 = result;
        int result2 = 0;
        byte[] bytes = crc31.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            result2 += bytes[i];
        }
        Integer crc3 = result2 % 256;
        String crc32 = String.format("%03d", crc3);
        System.out.println("===========================取到的crc3" + crc32);
        return crc32;
    }


}
