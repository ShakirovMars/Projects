package ru.kpfu.Auto.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.kpfu.Auto.models.Log;
import ru.kpfu.Auto.services.LogService;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {
    @Autowired
    LogService logService;

    @Pointcut("@annotation(ru.kpfu.Auto.aspect.MyLog)")
    public void logPointcut() {
    }

    @AfterReturning(
            pointcut = "logPointcut()",
            returning = "result")
    public void beforeFindPointcut(JoinPoint joinPoint, Object result) {
        Log log = new Log();
        log.setDate(new Date());
        log.setMethodName(joinPoint.getSignature().getName());
        log.setReturnResult(result.toString());
        logService.save(log);
    }
    

}
