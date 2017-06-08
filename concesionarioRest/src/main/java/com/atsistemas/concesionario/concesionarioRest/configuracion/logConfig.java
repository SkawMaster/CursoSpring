package com.atsistemas.concesionario.concesionarioRest.configuracion;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
@EnableAspectJAutoProxy
public class logConfig {
	
	// Logeo de peticiones
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter();
		crlf.setIncludeClientInfo(true);
		crlf.setIncludeQueryString(true);
		crlf.setIncludePayload(true);
		return crlf;
	}

	// Logeo de llamadas a métodos de clases
	@Bean
	public CustomizableTraceInterceptor customizableTraceInterceptor() {
	    CustomizableTraceInterceptor cti = new CustomizableTraceInterceptor();
	    cti.setEnterMessage("Entrando en método '" + CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME + "("+ CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENTS+")' de la clase [" + CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_NAME + "]");
	    cti.setExitMessage("Saliendo de método '" + CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME + "' de la clase [" + CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_NAME + "] llevó " + CustomizableTraceInterceptor.PLACEHOLDER_INVOCATION_TIME+"ms.");
	    return cti;
	}

	// Interceptor que monitoriza las llamadas a todas las clases del paquete
	// com.atsistemas.concesionario y todas sus subclases
	// Necesita las dependencias de cglib aspectjweaver
	@Bean
	public Advisor traceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		// execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
		// pointcut.setExpression("execution(public * *(..))");
		// pointcut.setExpression("execution(public com.ats.test.*.*(..))");
		pointcut.setExpression("within(com.atsistemas.concesionario..*)");
		return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
	}
}
