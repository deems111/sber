package sberMain.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

        private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

        @Pointcut("within(controller.*)")
        public void processingMethod() {
        };

        @Around("@annotation(ExecutionTimeAnno)")
        public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();

            Object proceed = joinPoint.proceed();

            long executionTime = System.currentTimeMillis() - start;

            logger.log(Level.INFO, joinPoint.getSignature() + " processed " + executionTime + "ms");
            return proceed;
        }

}
