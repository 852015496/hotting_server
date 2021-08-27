package com.hetting.hottable.server;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hetting.hottable.entity.Admin;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @Description Tocken
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service
public class TockenService {

    public String getToken(Admin admin) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(admin.getAdminId().toString())          // 将 admin id 保存到 token 里面
                    .sign(Algorithm.HMAC256(admin.getAdminPass()));   // 以 password 作为 token 的密钥
        } catch (UnsupportedEncodingException ignore) {
        }
        return token;
    }
}
