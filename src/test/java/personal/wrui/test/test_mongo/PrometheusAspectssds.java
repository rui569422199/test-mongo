package personal.wrui.test.test_mongo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author: Maxl
 * @date: 2019/12/10 09:29
 * @Description: LogAspect
 */
@Aspect
@Component
public class PrometheusAspectssds {
    private static final Logger logger = LoggerFactory.getLogger(PrometheusAspectssds.class);


    @Pointcut("@annotation(personal.wrui.test.test_mongo.PrometheusAnnotation)")
    public void pointCut(){
    }
    
    @Around("pointCut()")
    public Object queryAround(ProceedingJoinPoint joinPoint) {
        System.out.println("----------------------------"+System.currentTimeMillis());
        Object result=null;
		try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
		 System.out.println("----------------------------"+System.currentTimeMillis());
        return result;
    }

}
