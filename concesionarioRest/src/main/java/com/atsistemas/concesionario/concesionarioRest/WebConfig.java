package com.atsistemas.concesionario.concesionarioRest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		
		context.setConfigLocation("com.atsistemas.concesionarioRest");
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		
		Dynamic addServlet = servletContext.addServlet("/", dispatcherServlet);
		
		addServlet.setLoadOnStartup(1);
		addServlet.addMapping("/");
		
	}

}
