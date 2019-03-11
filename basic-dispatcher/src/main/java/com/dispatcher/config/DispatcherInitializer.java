package com.dispatcher.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DispatcherInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext servletApplicationContext=null;
		DispatcherServlet dispatcher=null;
		servletApplicationContext=new XmlWebApplicationContext();
		servletApplicationContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		dispatcher=new DispatcherServlet(servletApplicationContext);
		ServletRegistration.Dynamic dynamic=servletContext.addServlet("dispatcher", dispatcher);
		dynamic.addMapping("*.htm");
		dynamic.setLoadOnStartup(1);
		
	}

}
