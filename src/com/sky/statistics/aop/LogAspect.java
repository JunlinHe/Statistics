package com.sky.statistics.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by HJL on 2015/10/28.
 */
@Aspect
@Component
public class LogAspect {

    ThreadLocal<Long> time=new ThreadLocal<Long>();
    ThreadLocal<String> tag=new ThreadLocal<String>();

    @Pointcut("execution(* com.sky.statistics.web.service..*(..))")
    public void log(){
        System.out.println("我是一个切入点");
    }

    /**
     * 在所有标注@Log的地方切入
     * @param joinPoint
     */
    @Before("log()")
    public void beforeExec(JoinPoint joinPoint){

        time.set(System.currentTimeMillis());
        tag.set(UUID.randomUUID().toString());

        info(joinPoint);

        MethodSignature ms=(MethodSignature) joinPoint.getSignature();
        Method method=ms.getMethod();
        //System.out.println(method.getAnnotation(Log.class).name()+"标记"+tag.get());
    }

    @After("log()")
    public void afterExec(JoinPoint joinPoint){
        MethodSignature ms=(MethodSignature) joinPoint.getSignature();
        Method method=ms.getMethod();
        System.out.println("标记为"+tag.get()+"的方法"+method.getName()+"运行消耗"+(System.currentTimeMillis()-time.get())+"ms");
    }

    @Around("log()")
    public void aroundExec(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("我是Around，来打酱油的");
        pjp.proceed();
    }

    @AfterReturning(pointcut = "log()", returning = "result")
    public void afterReturningExec(String result){
        System.out.println("我是AfterReturning");
    }
    @AfterThrowing(pointcut = "log()", throwing ="e")
    public void afterThrowingExec(Exception e){
        System.out.println("我是AfterThrowing");
    }

    private void info(JoinPoint joinPoint){
        System.out.println("--------------------------------------------------");
        System.out.println("King:\t"+joinPoint.getKind());
        System.out.println("Target:\t"+joinPoint.getTarget().toString());
        Object[] os=joinPoint.getArgs();
        System.out.println("Args:");
        for(int i=0;i<os.length;i++){
            System.out.println("\t==>参数["+i+"]:\t"+os[i].toString());
        }
        System.out.println("Signature:\t"+joinPoint.getSignature());
        System.out.println("SourceLocation:\t"+joinPoint.getSourceLocation());
        System.out.println("StaticPart:\t"+joinPoint.getStaticPart());
        System.out.println("--------------------------------------------------");
    }
}
