package org.o2.registersvc.resource.impl;

import javax.imageio.spi.RegisterableService;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.impl.RegisterSvcProcessImpl;
import org.o2.registersvc.resource.RegisterSvcResource;
import org.o2.registersvc.resource.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.resource.builder.RegisterSvcResBuilder;
import org.o2.registersvc.resource.springconfig.ResourceSpringConfig;
import org.o2.registersvc.resource.validator.RegisterSvcValidator;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Path("/service")
public class RegisterSvcResourceImpl {
	String respCode = "0000";
	String respMsg = "Success";
	String typeOfError = "s";
	long t1 = System.currentTimeMillis();
	long t2;

	// Create logger object
	Logger logger = Logger.getLogger(RegisterSvcResourceImpl.class);

	// Create ApplicationContext and active ResourceSpringConfig.java
	ApplicationContext context = new AnnotationConfigApplicationContext(ResourceSpringConfig.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEnrollment")
	public RegisterServiceResType getEnrollment(@QueryParam("accNum") String accNum,
			@QueryParam("mobNum") String mobNum, @QueryParam("cardNum") String cardNum, @QueryParam("cvv") String cvv,
			@QueryParam("expDate") String expDate, @QueryParam("nameOnCard") String nameOnCard,
			@HeaderParam("x-client-id") String clientId, @HeaderParam("x-channel-id") String channelId,
			@HeaderParam("x-req-id") String reqId) {
		
		//Get all objects through Spring container
		AccountDetailsType accDetailstype = context.getBean(AccountDetailsType.class);
		CardDetailsType cardDetailsType = context.getBean(CardDetailsType.class);
		ClientDetailsType clientDetailsType = context.getBean(ClientDetailsType.class);
		RegisterServiceReqType wsReq = context.getBean(RegisterServiceReqType.class);
		RegisterServiceResType wsResp = context.getBean(RegisterServiceResType.class);
		RegisterSvcValidator validator = context.getBean(RegisterSvcValidator.class);
		StatusBlockType statusBlockType = context.getBean(StatusBlockType.class);
		RegisterSvcReqBuilder reqBuilder = context.getBean(RegisterSvcReqBuilder.class);
		RegisterSvcResBuilder resBuilder = context.getBean(RegisterSvcResBuilder.class);
		RegisterSvcProcess process = context.getBean(RegisterSvcProcessImpl.class);
		
		return null;

	}

}
