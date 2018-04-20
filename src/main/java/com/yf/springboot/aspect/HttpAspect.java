package com.yf.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class HttpAspect {

    private Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义日志切点
     */
    @Pointcut("execution(* com.yf.springboot.controller.*.*(..))")
    public  void  log(){

    }


    /**
     * 前置通知  目标方法执行之前执行以下方法体的内容
     * @param joinPoint
     */
    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] pointArgs = joinPoint.getArgs();
        logger.info("doBefore:{}",name);
    }


    /**
     * 后置通知  目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param joinPoint
     */
    @After("log()")
    public  void  doAfter(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();

        logger.info("after.......name:{}",name);

    }


    /**
     * 返回通知  目标方法发生异常的时候执行以下代码
     */
    @AfterReturning(value = "log()",returning = "args")
    public  void  doReturn(JoinPoint joinPoint,Object args){
        String name = joinPoint.getSignature().getName();
        logger.info("doReturn.......args:{}",args);
    }

    /**
     * 异常通知  目标方法发生异常的时候执行以下代码
     */
    @AfterThrowing(value = "log()",throwing = "e")
    public  void  doException(JoinPoint joinPoint,Exception e){
        logger.info("doReturn.......e:{}",e);

    }

    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     */
   /* @Around("log()")
    public  Object   doAround(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
      Object result = null;
      try {
          System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
          //执行目标方法
          result = proceedingJoinPoint.proceed();
          logger.info("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
      } catch (Throwable e) {
          logger.info("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
      }

        logger.info("【环绕通知中的--->后置通知】：-----------------end.----------------------");
      return result;
    }*/

}
