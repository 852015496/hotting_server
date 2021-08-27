package com.hetting.hottable.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//引用配置类
@WebFilter(filterName = "cors",urlPatterns = "/*")
public class SimpleCORSFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        // 哪些方法或者路径可以请求进来   * 代表所有 
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 可以进行请求的 请求方式  如 get  post
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // 请求保持的最长时间
        response.setHeader("Access-Control-Max-Age", "3600");
        // 请求的类型
        response.setHeader("Access-Control-Allow-Headers", "*");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}