package com.markerhub.aspect;

import cn.hutool.json.JSONUtil;
import com.markerhub.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Date：2022/2/10
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * ..表示包及子包 该方法代表controller层的所有方法  TODO 路径需要根据自己项目定义
     */
    @Pointcut("execution(public * com.markerhub.controller..*.*(..))")
    public void logAspect() {
    }


//    /**
//     * 方法执行前
//     *
//     * @param joinPoint
//     * @throws Exception
//     */
//    @Before("logAspect()")
//    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
//
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        StringBuilder requestLog = new StringBuilder();
//        Signature signature = joinPoint.getSignature();
//        requestLog
////                .append(((MethodSignature) signature).getMethod().getName()).append("\t")
//                .append("请求信息：").append("URL = {").append(request.getRequestURI()).append("},\t")
//                .append("请求方式 = {").append(request.getMethod()).append("},\t")
//                .append("请求IP = {").append(request.getRemoteAddr()).append("},\t")
//                .append("类方法 = {").append(signature.getDeclaringTypeName()).append(".")
//                .append(signature.getName()).append("},\t");
//
//        // 处理请求参数
//        String[] paramNames = ((MethodSignature) signature).getParameterNames();
//        Object[] paramValues = joinPoint.getArgs();
//        int paramLength = null == paramNames ? 0 : paramNames.length;
//        if (paramLength == 0) {
//            requestLog.append("请求参数 = {} ");
//        } else {
//            requestLog.append("请求参数 = [");
//            for (int i = 0; i < paramLength - 1; i++) {
//                requestLog.append(paramNames[i]).append("=").append(JSONUtil.toJsonStr(paramValues[i])).append(",");
//            }
//            requestLog.append(paramNames[paramLength - 1]).append("=").append(JSONUtil.toJsonStr(paramValues[paramLength - 1])).append("]");
//        }
//
//        log.info(requestLog.toString());
//    }

    @Around("logAspect()")
    public Object logInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder requestLog = new StringBuilder();
        Signature signature = joinPoint.getSignature();
        requestLog
//                .append(((MethodSignature) signature).getMethod().getName()).append("\t")
                .append("请求信息：").append("URL = {").append(request.getRequestURI()).append("},\t")
                .append("请求方式 = {").append(request.getMethod()).append("},\t")
                .append("请求IP = {").append(request.getRemoteAddr()).append("},\t")
                .append("类方法 = {").append(signature.getDeclaringTypeName()).append(".")
                .append(signature.getName()).append("},\t");

        // 处理请求参数
        String[] paramNames = ((MethodSignature) signature).getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        int paramLength = null == paramNames ? 0 : paramNames.length;
        if (paramLength == 0) {
            requestLog.append("请求参数 = {} ");
        } else {
            requestLog.append("请求参数 = [");
            for (int i = 0; i < paramLength - 1; i++) {
                requestLog.append(paramNames[i]).append("=").append(JSONUtil.toJsonStr(paramValues[i])).append(",");
            }
            requestLog.append(paramNames[paramLength - 1]).append("=").append(JSONUtil.toJsonStr(paramValues[paramLength - 1])).append("]");
        }

        log.info(requestLog.toString());
        try {
            Object result = joinPoint.proceed();
            log.info("请求结果：" + result + "\t");
            return result;
        } catch (Throwable throwable) {
            log.info(throwable.getMessage());
            throwable.printStackTrace();
            return Result.fail("系统异常");
        }
    }


    ///**
    // * 方法执行后
    // *
    // * @param resultVO
    // * @throws Exception
    // */
    //@AfterReturning(returning = "resultVO", pointcut = "logAspect()")
    //public void logResultVOInfo(Result resultVO) throws Exception {
    //    log.info("请求结果：" + resultVO.getCode() + "\t" + resultVO.getMsg() + "\t");
    //    if (null != resultVO.getData()) {
    //        log.info("返回数据：" + resultVO.getData() + "\t");
    //    }
    //}
    //

}