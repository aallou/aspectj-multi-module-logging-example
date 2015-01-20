package li.barlog.logging.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogUserActionAspect {
	private static final Logger log = LoggerFactory.getLogger(LogUserActionAspect.class);

	@Pointcut("execution(@li.barlog.logging.annotation.LogAsUserAction * *(..))")
	public void methodAnnotatedWithLogAsUserAction() {}

	@Before("methodAnnotatedWithLogAsUserAction()")
	public void before(JoinPoint joinPoint) {
		log.debug("USER [{}: {}]", "before", joinPoint.toLongString());
	}

	@After("methodAnnotatedWithLogAsUserAction()")
	public void after(JoinPoint joinPoint) {
		log.debug("USER [{}: {}]", "after", getInfo(joinPoint));
	}

	@AfterThrowing(value = "methodAnnotatedWithLogAsUserAction()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		log.debug("USER [{}: {}]", "exception", e.getMessage());
	}

	public String getInfo(JoinPoint point) {
		StringBuilder builder = new StringBuilder();

		Object o = point.getThis();
		if (o != null) {
			builder.append("Class name: ");
			builder.append(o.getClass().getName());
		}

		builder.append("signature: ");
		builder.append(point.getSignature().toLongString());


		return builder.toString();
	}
}
