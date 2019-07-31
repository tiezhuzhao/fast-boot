package com.ttsh.mc.config.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhaozhe
 *  AOP全局log日志打印
 *  为减少代码耦合性
 */
@Aspect
@Component
public class LogAspects {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger("Aspect");


    @Pointcut("@annotation(com.ttsh.mc.config.Aspect.SystemLog)")
    public void controllerAspect() {
    }

    /**
     * 前置通知
     * @param joinPoint 切点
     */
//    @Before("controllerAspect()")
//    public void doBefore(JoinPoint joinPoint) {
//        try {
//            // 1.获取request对象
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            // 1.1获取ip地址
//            String ip = request.getHeader("x-forwarded-for");
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getRemoteAddr();
//            }
//            if (ip == null || ip.length() == 0 || ip.indexOf(":") > -1) {
//                try {
//                    ip = InetAddress.getLocalHost().getHostAddress();
//                } catch (UnknownHostException e) {
//                    ip = null;
//                }
//            }
//
//            //1.2获取控制器Controller名称
//            String controllerName = joinPoint.getTarget().getClass().getName();
//
//
//            //1.3 获取method对象
//            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//            Method method = methodSignature.getMethod();
//            //1.4获取方法名称
//            String name = method.getName();
//
//
//            //2开始获取参数值
//            StringBuffer stringBuffer = new StringBuffer();
//            //默认以JSON格式添加数据
//            stringBuffer.append("{");
//            // 获取参数值
//            // 2.1获取参数对象
//            Enumeration parameter = request.getParameterNames();
//            while(parameter.hasMoreElements()) {
//                //获取下一个索引位置的key
//                String key=(String) parameter.nextElement();
//                //获取key所对应的value
//                String value = request.getParameter(key);
//                //如果不是最后一位 则需要拼接,号  否则不需要拼接
//                if(parameter.hasMoreElements()) {
//                    stringBuffer.append("\""+key + "\":\"" + value + "\",");
//                }else{
//                    stringBuffer.append("\""+key + "\":\"" + value+ "\"");
//                }
//            }
//            stringBuffer.append("}");
//
//            //获取自定义注解对象 用于打印方法功能
//            SystemLog logger = methodSignature.getMethod().getAnnotation(SystemLog.class);
//
//            StringBuffer str = new StringBuffer();
//            str.append(controllerName+"中控制器方法"+name);
//            str.append(","+logger.description()+",电脑ip为"+ip);
//            str.append(",访问参数："+stringBuffer);
//            log.info(str.toString());
//        } catch (Exception e) {
//            log.error("AOP全局切面log出现异常,请联系开发人员");
//             e.printStackTrace();
//        }
//    }

    /**
     * 返回通知
     * @param joinPoint 返回切入点
     */
//    @AfterReturning(value = "controllerAspect()",returning = "result")
//    public void doAfter(JoinPoint joinPoint,Object result) {
//        try {
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//            String name = signature.getMethod().getName();
//            log.info("方法"+name+"执行完毕,"+"返回参数为"+JSONObject.toJSONString(result));
//        } catch (Exception e) {
//            log.error("AOP返回通知log出现异常,请联系开发人员");
//            e.printStackTrace();
//        }
//    }

    /**
     * 异常通知
     *
     * @param exception 异常对象
     */
//    @AfterThrowing(throwing = "exception", pointcut = "controllerAspect()")
//    public void exception(JoinPoint joinPoint,Exception exception) {
//        if (null !=  joinPoint.getSignature()) {
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//            String name = signature.getMethod().getName();
//            log.info("方法"+name+"出现异常,"+"异常信息是"+exception.getMessage());
//        }
//    }




}