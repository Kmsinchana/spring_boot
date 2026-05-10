package com.example.AopAndTransaction.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAop {

//    we can also use do in the below way
//    to execute all the method in the service package we can use the below method
    @Pointcut("execution(* com.example.AopAndTransaction.service.*.*(..))")
    public void pointcutExpression(){};


//    first start is for the return type
    @Before("pointcutExpression()")
    public void logBeforeExecution(JoinPoint joinpoint){
        System.out.println("method execution started with the method" +joinpoint.getSignature().getName());
    }

    @After("execution(* com.example.AopAndTransaction.service.DepartmentService.saveDepartment(..))")
    public void logAfterExecution(){
        System.out.println("method execution completed");
    }

    @Around("execution(* com.example.AopAndTransaction.service.DepartmentService.*(..))")
    public Object calculatingExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("the method is starting with around");
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis()-start;
//        joinPoint.getSignature().getName() this will give the method
        System.out.println(joinPoint.getSignature().getName() +"the execution time is: "+timeTaken);

        return result;
    }
}
