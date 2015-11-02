package com.sky.statistics.core.aspect;

import com.sky.statistics.core.annotation.SystemControllerLog;
import com.sky.statistics.core.annotation.SystemServiceLog;
import com.sky.statistics.core.util.ContextUtil;
import com.sky.statistics.core.util.StringUtil;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.service.UserLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by HJL on 2015/10/28.
 */
@Aspect
@Component
public class LogAspect {

    @Resource
    private UserLogService userLogService;

    @Autowired
    @Qualifier("logTaskExecutor")
    private TaskExecutor logTaskExecutor;

    //本地异常日志记录对象
    private  static  final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //Service层切点
    @Pointcut("@annotation(com.sky.statistics.core.annotation.SystemServiceLog)")
    public  void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.sky.statistics.core.annotation.SystemControllerLog)")
    public  void controllerAspect() {
    }
    //////////////////////////////////////service日志层通知//////////////////////////////////////////////////
    /**
     * 环绕通知，在@Before之前开始，在@After之前结束
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("serviceAspect()")//必须有返回值
    public Object aroundService(ProceedingJoinPoint pjp) throws Throwable{
        Object o = pjp.proceed();
        return o;
    }

    /**
     *  前置通知 用于拦截service层记录用户的操作
     * @param joinPoint
     */
    @Before("serviceAspect()")
    public void beforeService(JoinPoint joinPoint) throws Exception {
    }

    @After("serviceAspect()")
    public void afterService(JoinPoint joinPoint){
    }

    @AfterReturning(pointcut = "serviceAspect()", returning = "result")
    public void afterReturningService(JoinPoint joinPoint,Object result) throws Exception {
        try{
            log(true, joinPoint, null);
        }catch (Exception e){
            //记录本地异常日志
            logger.error("==Service返回通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    @AfterThrowing(pointcut = "serviceAspect()", throwing ="e")
    public void afterThrowingService(JoinPoint joinPoint,Exception e){
        System.out.println("Service抛出异常");
        log(true, joinPoint, e);
    }
    /////////////////////////////////////////////service层通知结束///////////////////////////////////////////////////
    /**
     * 环绕通知，在@Before之前开始，在@After之前结束
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")//必须有返回值
    public Object aroundController(ProceedingJoinPoint pjp) throws Throwable{
        Object o = pjp.proceed();
        return o;
    }

    /**
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public void beforeController(JoinPoint joinPoint) throws Exception {
    }

    @After("controllerAspect()")
    public void afterController(JoinPoint joinPoint){
    }

    @AfterReturning(pointcut = "controllerAspect()", returning = "result")
    public void afterReturningController(JoinPoint joinPoint,Object result) throws Exception {
        try{
            log(false, joinPoint, null);
        }catch (Exception e){
            //记录本地异常日志
            logger.error("==Controller返回通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
        System.out.println("Controller环绕结束");
    }

    @AfterThrowing(pointcut = "controllerAspect()", throwing ="e")
    public void afterThrowingController(JoinPoint joinPoint,Exception e){
        log(false, joinPoint, e);
    }


    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 根据切入层获取日志
     * @param serviceOrController true:service, false:Controller
     * @param joinPoint
     * @param e
     */
    private void log(final boolean serviceOrController,final JoinPoint joinPoint,final Throwable e){
        //开启日志线程
        logTaskExecutor.execute(new Runnable()
        {
            public void run()
            {
                String logInfo = null;
                //获取用户请求方法的参数并序列化为JSON格式字符串
                String params = "";
                try {
                    logInfo = serviceOrController?getServiceMthodDescription(joinPoint):getControllerMethodDescription(joinPoint);

                    if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
                        for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                            params += joinPoint.getArgs()[i] + ";";
                        }
                    }

                    //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                    //HttpSession session = request.getSession();
                    //读取session中的用户
                    //User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
                    //请求的IP
                    String ip = ContextUtil.getClientIp();
                    String[] addr = ContextUtil.getAddressByIP(ip);//通过request获取IP再获取IP所在地

                    UserLog usl = new UserLog();

                    usl.setUser(getUser());
                    usl.setLogInfo(logInfo);
                    usl.setLogTime(new Date());
                    usl.setIP(ip);
                    usl.setArea(StringUtil.joinIgnoreEmptyStr(",",addr));
                    usl.setMethodName( joinPoint.getSignature().getName());
                    usl.setModelName(joinPoint.getTarget().getClass().getName());
                    usl.setLogType(0);
                    if(e!=null){//设置异常日志
                        usl.setLogType(1);
                        usl.setErrCode(e.getClass().getName());
                        usl.setErrInfo(e.getMessage());
                    }
                    userLogService.insert(usl);

                }
                catch (Exception e) {
                    //记录本地异常日志
                    logger.error("==异常通知异常==");
                    logger.error("异常信息:{}", e.getMessage());
                }

                /*==========记录本地异常日志==========*/
                if(e!=null)
                    logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);

            }//线程结束
        });


    }


    /**
     * 获得用户对象
     *
     * @return
     */
    private User getUser()
    {
        User us = ContextUtil.getContextLoginUser();
        if(us==null || us.getId()==0l){
            us = new User();
            us.setId(1l);
        }

        return us;
    }
}
