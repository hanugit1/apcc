package org.o2.registersvc.resource.impl;

import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Path("/service")
public class RegisterSvcResourceImpl {
	String respCode = "0000";
	String respMsg = "Success";
	String typeOfError ="s";
	long t1 = System.currentTimeMillis();
	long t2;
	
	//Create logger object
	Logger logger = Logger.getLogger(RegisterSvcResourceImpl.class);
	
	//Create ApplicationContext and active ResourceSpringConfig.java
	ApplicationContext context = new AnnotationConfigApplicationContext();
	
}
