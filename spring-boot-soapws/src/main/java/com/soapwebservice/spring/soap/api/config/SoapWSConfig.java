package com.soapwebservice.spring.soap.api.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWSConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messagedispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet dispatcherServlet=new MessageDispatcherServlet();
		dispatcherServlet.setApplicationContext(context);
		dispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(dispatcherServlet, "/ws/*");
	}
	
	/*
	 * generate porttype configure uri
	 */
	@Bean(name="loanEligibilty")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
		definition.setPortTypeName("LoanEligibility");
		definition.setLocationUri("/ws");
		definition.setTargetNamespace("http://www.soapwebservice.com/spring/soap/api/loanEligibility");
		definition.setSchema(schema);
		return definition;
	}
	
	@Bean
	public XsdSchema schema() {
		return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
	}
	
	
}
