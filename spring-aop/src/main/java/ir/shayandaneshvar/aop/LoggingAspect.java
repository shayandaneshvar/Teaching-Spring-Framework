package ir.shayandaneshvar.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;

@Aspect
//@Order(0)
@Component
public class LoggingAspect implements Ordered {
    private Logger log = Logger.getLogger(LoggingAspect.class.getName());

    @Override
    public int getOrder() {
        return 0;
    }

    @Pointcut(value = "@annotation(Loggable)")
    public void logPointCut() {
//        System.out.println("This Text Never Prints");
    }

    @Before(value = "execution(* ir.shayandaneshvar.util.Calculator.*(..)) && bean(calculator)")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " " + Arrays.toString(
                joinPoint.getArgs()) + " " + joinPoint.getKind());
    }

    @After(value = "execution(* ir.shayandaneshvar.*.*(..))")
    public void logAfterMethodCall(JoinPoint joinPoint) {
        System.out.println("in @After: " + joinPoint.getTarget());
    }

    @AfterReturning(pointcut = "execution(* ir.shayandaneshvar.*.*(..))", returning = "returnValue")
    public void logMethodReturn(JoinPoint joinPoint, Object returnValue) {
        System.out.println("In After Returning: returning object =>" + returnValue);
    }

    @AfterThrowing(pointcut = "within(ir.shayandaneshvar.controller.MainController)", throwing = "ex")
    public void logExceptionThrown(JoinPoint joinPoint, Throwable ex) {
        System.out.println("in @AfterThrowing - within MainController");
        System.out.println(ex.getMessage());
    }

    //    @Around(value = "within(ir.shayandaneshvar.util.Calculator)")
//    @Around(value = "@annotation(Loggable)")
    @Around(value = "logPointCut()")
    public Object logAroundMethodCall(ProceedingJoinPoint joinPoint) {
        System.out.println("In @Around");
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(object);
        System.out.println("returning object");
        return object;
    }

//    @Before(value = "bean(calculator) && execution(...)")
//    public void beforeSomeObject(JoinPoint joinPoint){
//        System.out.println("Here!");
//        System.out.println(joinPoint.getSignature().getName());
//    }

    //    @After(value = "target(MyAnnotation)")
    @After(value = "logPointCut()")
    public void doAfterTarget() {
        System.out.println("Here !!!!!!!!!");
        log.debug("Helloo!");
    }


}
