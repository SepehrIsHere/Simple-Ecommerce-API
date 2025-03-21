package org.pki.simpleecommerproject.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.pki.simpleecommerproject.entities.MongoLogMessage;
import org.pki.simpleecommerproject.entities.enumerations.LogMessageType;
import org.pki.simpleecommerproject.service.LogService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class AOPConfig {
    private final LogService logService;

    @Before("execution(* org.pki.simpleecommerproject.service*.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        MongoLogMessage message = MongoLogMessage.builder()
                .type(operationType(joinPoint.getSignature().getName()))
                .methodName(joinPoint.getSignature().getName())
                .className(joinPoint.getTarget().getClass().getName())
                .time(now())
                .message("Before executing method : " + joinPoint.getSignature().getName())
                .build();
        logService.save(message);
    }

    @After("execution(* org.pki.simpleecommerproject.service*.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        MongoLogMessage message = MongoLogMessage.builder()
                .type(operationType(joinPoint.getSignature().getName()))
                .methodName(joinPoint.getSignature().getName())
                .className(joinPoint.getTarget().getClass().getName())
                .time(now())
                .message("After executing method : " + joinPoint.getSignature().getName())
                .build();
        logService.save(message);
    }

    @AfterThrowing("execution(* org.pki.simpleecommerproject.service*.*.*(..))")
    public void logAfterThrowing(JoinPoint joinPoint) {
        MongoLogMessage message = MongoLogMessage.builder()
                .type(operationType(joinPoint.getSignature().getName()))
                .methodName(joinPoint.getSignature().getName())
                .className(joinPoint.getTarget().getClass().getName())
                .time(now())
                .message("After throwing exception for method : " + joinPoint.getSignature().getName())
                .build();
        logService.save(message);
    }

    private LocalDateTime now() {
        return LocalDateTime.now();
    }

    private LogMessageType operationType(String methodName) {
        if (methodName.contains(LogMessageType.SAVE.toString())) {
            return LogMessageType.SAVE;
        } else if (methodName.contains(LogMessageType.DELETE.toString())) {
            return LogMessageType.DELETE;
        } else if (methodName.contains(LogMessageType.UPDATE.toString())) {
            return LogMessageType.UPDATE;
        } else if (methodName.contains("find")) {
            return LogMessageType.LOAD;
        } else {
            return LogMessageType.EXCEPTION;
        }
    }
}
