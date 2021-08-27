package com.hetting.hottable.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MessageTestController {

    public static void main(String[] args) {
        try {
            //            外部api
            String url = "https://tianqiapi.com/api/sms";
            //            添加get参数
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter("appid", "41465261");
            uriBuilder.addParameter("appsecret", "HbDTBz9M");
            uriBuilder.addParameter("mobile", "13381311165");
            uriBuilder.addParameter("code", "741741");
            /*uriBuilder.addParameter("key","Sp3A1xNwWtvkLyq15");
            uriBuilder.addParameter("location",location);
            uriBuilder.addParameter("language","zh-Hans");
            uriBuilder.addParameter("unit","c");
            uriBuilder.addParameter("start","0");
            uriBuilder.addParameter("days","5");*/
            URI uri = uriBuilder.build();
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("Connection", "keep-alive");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            String string = EntityUtils.toString(httpResponse.getEntity());
            //            将返回结果转换成Json对象
            JSONObject jo = JSONObject.parseObject(string);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
