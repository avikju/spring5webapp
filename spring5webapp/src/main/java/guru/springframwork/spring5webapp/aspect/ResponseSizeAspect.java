package guru.springframwork.spring5webapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class ResponseSizeAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseSizeAspect.class);

	@AfterReturning(value = "execution(* guru.springframwork.spring5webapp.resources.*.*(..))", returning = "returnedObj")
	public void calculateResponseSize(JoinPoint joinPoint, Object returnedObj) throws JsonProcessingException {

		if (returnedObj != null) {
			LOGGER.info(String.format("End Point:%s returned object of %s and size:%.2f", joinPoint.getSignature(),
					returnedObj.getClass().getName(),
					(double) (new ObjectMapper().writeValueAsBytes(returnedObj).length / 1000)));
		}

	}

}
