package com.pyxis.aoplogging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerLogger {

    private static final Logger LOG = LoggerFactory.getLogger(RestControllerLogger.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void beanAnnotatedWithRestController() { }

    @Pointcut("execution(org.springframework.http.ResponseEntity *.*(..))")
    public void returnsResponseEntity() { }

    @AfterReturning(value = "returnsResponseEntity() && beanAnnotatedWithRestController()", returning = "responseEntity")
    public void publicMethodInsideAClassMarkedWithAtMonitor(JoinPoint joinPoint, ResponseEntity<?> responseEntity) {
        LOG.debug("Rest controller method requested. method={}, retval={}", joinPoint.getSignature().getName(), responseEntity.getBody());
    }

}
