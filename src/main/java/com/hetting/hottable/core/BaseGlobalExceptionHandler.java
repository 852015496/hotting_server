package com.hetting.hottable.core;

import com.hetting.hottable.core.Entiy.SystemLog;
import com.hetting.hottable.core.service.SystemLogService;
import org.apache.commons.lang3.ObjectUtils;
import org.assertj.core.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@ControllerAdvice
public class BaseGlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BaseGlobalExceptionHandler.class);

    protected static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";

    @Autowired
    private SystemLogService systemLogService;

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @Transactional
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e) throws Exception {
        logger.error("发生业务异常！原因是：{}", e.getErrorMsg());
        this.addLog(e);
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @Transactional
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) throws Exception {
        logger.error("发生空指针异常！原因是:", e);
        this.addLog(e);
        return ResultBody.error(DEFAULT_ERROR_MESSAGE);
    }


    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @Transactional
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("未知异常！原因是:", e.getMessage());
        this.addLog(e);
        return ResultBody.error(DEFAULT_ERROR_MESSAGE);
    }


    public void addLog(Exception e) throws Exception {
        SystemLog log = new SystemLog();
        log.setLogInfo(e.getMessage());
        this.getMessage(e,log);
        systemLogService.addLog(log);
    }

    private void getMessage(Exception e, SystemLog systemLog) {
        if (ObjectUtils.isNotEmpty(e)) {
            systemLog.setLogInfo(e.getMessage());
            StackTraceElement[] stackTrace = e.getStackTrace();
            if (!Arrays.isNullOrEmpty(stackTrace)) {
                systemLog.setClassName(stackTrace[0].getClassName());
                systemLog.setMethodName(stackTrace[0].getFileName());
                systemLog.setLineNumber(String.valueOf(stackTrace[0].getLineNumber()));
            }
        }


    }

}
