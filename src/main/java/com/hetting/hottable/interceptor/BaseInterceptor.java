package com.hetting.hottable.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hetting.hottable.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class BaseInterceptor implements HandlerInterceptor{

	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
		
		System.out.println("进入拦截器");
		
		// 验证登陆状态
		//获取登陆状态
		Admin admin = (Admin)req.getSession().getAttribute("admin");
		if(null!=admin) {
			return true;
		}
		
		resp.sendRedirect("http://localhost:3000/Login");
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

}
