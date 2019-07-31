package com.ttsh.mc.config.Aspect;

import com.alibaba.fastjson.JSONObject;
import com.ttsh.mc.utils.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @author zhaozhe
 *  AOP全局log日志打印
 *  为减少代码耦合性
 */
@Aspect
@Component
public class LogAspect {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger("Aspect");


    @Pointcut("@annotation(com.ttsh.mc.config.Aspect.SystemLog)")
    public void controllerAspect() {
    }

    /**
     * 环绕通知
     * @param pjp ProceedingJoinPoint
     * @return Object
     */
    @Around("controllerAspect()")
    public Object handleLog(ProceedingJoinPoint pjp) throws Throwable {
        // 4.最终的返回前端的类
        Object result = null;
        //3.(将整体try起来出现错误时 说明是AOP切面发生错误  则需要修改切面逻辑)   定义了全局异常拦截器 所以此处可以不用try起来
        //1.获取request对象 用于获取请求参数以及请求数据
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //1.1获取目标类名称
        String clazzName = pjp.getTarget().getClass().getName();

        //1.2获取目标类方法名称 及注解对象
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getName();

        //1.3随机产生一个任务编号 用于寻找错误信息
        StringBuffer uuidArr = new StringBuffer(UUID.randomUUID().toString() + UUID.randomUUID().toString());

        //将字符串反转  减少字符串出现相同的概率
        uuidArr = uuidArr.reverse();
        StringBuffer uuid = new StringBuffer();

        //循环拼接字符串
        Arrays.asList(uuidArr.toString().split("-")).forEach((item) -> uuid.append(item));

        //1.4获取ip地址
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || ip.indexOf(":") > -1) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                ip = null;
            }
        }

        //1.5获取请求参数
        Map requestMap = new HashMap();

        // 获取参数值
        // 2.1获取参数对象
        Enumeration parameter = request.getParameterNames();
        //使用迭代器的形式获取参数 键值对数组
        while (parameter.hasMoreElements()) {
            //获取下一个索引位置的key
            String key = (String) parameter.nextElement();
            //获取key所对应的value
            String value = request.getParameter(key);
            requestMap.put(key, value);
        }

        // 1.6记录开始调用时间 计时并调用目标函数
        Date date = new Date();

        //1.7获取自定义注解对象 用于打印方法功能
        SystemLog systemLog = signature.getMethod().getAnnotation(SystemLog.class);
        //获取注解提示信息
        String description = systemLog.description();


        //转换开始时间字符串
        String dateStr = DateUtil.parseDateToStr(date, "yyyy-MM-dd HH:mm:ss");
        long start = date.getTime();
        LOG.info("方法" + ":" + methodName + "开始,任务编号为:" + uuid + ",开始时间为" + dateStr + ",参数为" + JSONObject.toJSONString(requestMap) + ",请求主机ip为" + ip + ",方法功能简介:" + description);

        //2开始执行目标函数
        //由于会发生异常 需要在出现异常时打印log信息
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            Date exceptionDate = new Date();
            String exceptionStr = DateUtil.parseDateToStr(exceptionDate, "yyyy-MM-dd HH:mm:ss");
            LOG.error("方法" + ":" + methodName + "发生异常,任务编号为:" + uuid + ",发生异常时间为" + exceptionStr + ",参数为" + JSONObject.toJSONString(requestMap) + ",请求主机ip为" + ip + ",方法功能简介:" + description);
            throw throwable;
        }

        //执行成功  并开始计时结束时间
        Date endDate = new Date();
        String endStr = DateUtil.parseDateToStr(endDate, "yyyy-MM-dd HH:mm:ss");
        Long time = endDate.getTime() - start;
        LOG.info("方法" + ":" + methodName + "结束,任务编号为:" + uuid + ",结束时间为" + endStr + "总耗时" + time + "毫秒,返回参数为" + JSONObject.toJSONString(result) + ",请求主机ip为" + ip + ",方法功能简介:" + description);
        return result;
    }


}