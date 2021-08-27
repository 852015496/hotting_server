package com.hetting.hottable.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class LoginUtil {

    /*
    设置token 过期时间
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;


    /**
     * @Author zhangWenTao
     * @Description //TODO MD5加密
     * @Date 2020/4/5
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        String pass = "1234567";
        String passWord = DigestUtils.md5DigestAsHex(pass.getBytes(StandardCharsets.UTF_8));
        System.err.println(passWord);
    }
}
