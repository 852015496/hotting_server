package com.hetting.hottable.core;

import com.hetting.hottable.core.Entiy.UserLog;
import com.hetting.hottable.core.service.UserLogService;
import com.hetting.hottable.core.Util.IpAdrressUtil;
import com.hetting.hottable.core.Util.JacksonUtil;
import com.hetting.hottable.entity.Admin;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
@EnableAspectJAutoProxy
public class SystemLogAspect {

//    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);


    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired
    private UserLogService userLogService;


    @Pointcut("@annotation(com.hetting.hottable.core.SysLog)")
    public void logPoinCut() {

    }


    @AfterReturning("logPoinCut()")
    public Object saveSysLog(JoinPoint joinPoint) throws Throwable {
        //保存日志
        UserLog sysLog = new UserLog();
        sysLog.setLogId(UUID.randomUUID().toString());
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        SysLog sog = method.getAnnotation(SysLog.class);
        if (ObjectUtils.isNotEmpty(sog)) {
            String operation = sog.operation();
            sysLog.setOperation(operation);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();

        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = null;
        try {
            params = JacksonUtil.obj2json(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sysLog.setParams(params);

        //获取用户名信息
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("user");
        sysLog.setUserId(user.getAdminId());
        sysLog.setUserName(user.getAdminUserName());
        sysLog.setUserRole(user.getUserRole());

        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        sysLog.setIp(IpAdrressUtil.getIpAdrress(request));

        //调用service保存SysLog实体类到数据库
//        sysLogService.saveLog(sysLog);
        System.out.println(sysLog.getIp());
        addUserLog(sysLog);
        return sysLog;
    }

    @Transactional
    public void addUserLog(UserLog userLog) {
        userLogService.addUserLog(userLog);
    }
}
