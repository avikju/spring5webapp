/**
 * 
 */
package guru.springframwork.spring5webapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Avik
 *
 */
@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Around("@annotation(guru.springframwork.spring5webapp.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		LOGGER.info(joinPoint.getSignature() + " with params:"
				+ StringUtils.arrayToCommaDelimitedString(joinPoint.getArgs()) + " executed in " + executionTime
				+ "ms");
		return proceed;
	}

}
