package org.o2.registersvc.resource.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.impl.RegisterSvcProcessImpl;
import org.o2.registersvc.process.util.SystemException;
import org.o2.registersvc.resource.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.resource.builder.RegisterSvcResBuilder;
import org.o2.registersvc.resource.exception.RegisterSvcReqInvalidException;
import org.o2.registersvc.resource.springconfig.ResourceSpringConfig;
import org.o2.registersvc.resource.util.BusinessException;
import org.o2.registersvc.resource.util.UnknownException;
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

		// Get all objects through Spring container
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

		try {
			System.out.println("Enter into ResourceLayer");
			t2 = System.currentTimeMillis();

			// Setting AccountDetails
			accDetailstype.setAccountNum(accNum);
			accDetailstype.setMobileNum(Long.parseLong(mobNum));

			// Setting ClientDetails
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setReqId(reqId);

			// Setting CardDetails
			cardDetailsType.setCardNum(cardNum);
			cardDetailsType.setCvv(cvv);
			cardDetailsType.setExpDate(expDate);
			cardDetailsType.setNameOnCard(nameOnCard);

			wsReq.setAccountDetails(accDetailstype);
			wsReq.setCardDetails(cardDetailsType);
			wsReq.setClientDetails(clientDetailsType);

			logger.debug("Enter into ResourceLayer with:: " + wsReq);

			// Calling Validator to validate the consumer input
			validator.validateWsReq(wsReq);

			// Prepare ProccesLayer Req ie., vbReq
			RegisterSvcProcessVBReq vbReq = reqBuilder.buildProcessReq(wsReq);

			// Call ProcessLayer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);
			logger.debug("vbResp respCode and respMsg in ResourceLayer:: " + vbResp.getRespCode() + ":::"
					+ vbResp.getRespMsg());

			// Prepare wsResp to vbResp
			wsResp = resBuilder.buildWsResp(vbResp);
		} catch (RegisterSvcReqInvalidException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());

			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();
		} catch (BusinessException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();
		} catch (SystemException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();
		} catch (UnknownException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "UE";
			long t2 = System.currentTimeMillis();
		} catch (SQLException e) {
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();
		} catch (IOException e) {
			typeOfError = "IOE";
			long t2 = System.currentTimeMillis();
		} catch (Exception e) {
			typeOfError = "E";
			long t2 = System.currentTimeMillis();
		} finally {
			long timeTaken = t2 - t1;
			InetAddress ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost();
				System.out.println(ipAddress.getHostAddress().trim());

				StringBuilder builder = new StringBuilder();
				builder.append(new Date()).append("/").append("RegisterSvcResourceImpl").append("/")
						.append("getEnrollment").append("/").append("/enroll").append(clientDetailsType.getClientId())
						.append("/").append(clientDetailsType.getChannelId()).append("/")
						.append(clientDetailsType.getReqId()).append("/").append(respCode).append("/").append(respMsg)
						.append(timeTaken).append(typeOfError).append(ipAddress);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return wsResp;
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	@Path("/postEnrollment")
	public RegisterServiceResType postEnrollment(RegisterServiceReqType wsReq,
			@HeaderParam("x-client-id") String clientId, @HeaderParam("x-channel-id") String channelId,
			@HeaderParam("x-req-id") String reqId) throws UnknownHostException {

		// Get all objects through Spring container
		// Get all objects through Spring container
		AccountDetailsType accDetailstype = context.getBean(AccountDetailsType.class);
		CardDetailsType cardDetailsType = context.getBean(CardDetailsType.class);
		ClientDetailsType clientDetailsType = context.getBean(ClientDetailsType.class);
		// RegisterServiceReqType wsReq = context.getBean(RegisterServiceReqType.class);
		RegisterServiceResType wsResp = context.getBean(RegisterServiceResType.class);
		RegisterSvcValidator validator = context.getBean(RegisterSvcValidator.class);
		StatusBlockType statusBlockType = context.getBean(StatusBlockType.class);
		RegisterSvcReqBuilder reqBuilder = context.getBean(RegisterSvcReqBuilder.class);
		RegisterSvcResBuilder resBuilder = context.getBean(RegisterSvcResBuilder.class);
		RegisterSvcProcess process = context.getBean(RegisterSvcProcessImpl.class);

		try {
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setReqId(reqId);
			wsReq.setClientDetails(clientDetailsType);

			System.out.println("Enter into ResourceLayer with webReq: " + wsReq);
			t2 = System.currentTimeMillis();

			logger.info("Enter into ResourceLayer with:: " + wsReq);
			
			// Calling validator to validate the consumer input
			validator.validateWsReq(wsReq);

			// Prepare ProccesLayer Req ie., vbReq
			RegisterSvcProcessVBReq vbReq = reqBuilder.buildProcessReq(wsReq);

			// Call ProcessLayer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);
			logger.debug("vbResp respCode and respMsg in ResourceLayer:: " + vbResp.getRespCode() + ":::"
					+ vbResp.getRespMsg());

			// Prepare wsResp to vbResp
			wsResp = resBuilder.buildWsResp(vbResp);
			
		} catch (RegisterSvcReqInvalidException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());

			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();
		} catch (BusinessException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();
		} catch (SystemException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();
		} catch (UnknownException e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "UE";
			long t2 = System.currentTimeMillis();
		} catch (SQLException e) {
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();
		} catch (IOException e) {
			typeOfError = "IOE";
			long t2 = System.currentTimeMillis();
		} catch (Exception e) {
			typeOfError = "E";
			long t2 = System.currentTimeMillis();
		} finally {
			long timeTaken = t2 - t1;
			InetAddress ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost();
				System.out.println(ipAddress.getHostAddress().trim());

				StringBuilder builder = new StringBuilder();
				builder.append(new Date()).append("/").append("RegisterSvcResourceImpl").append("/")
						.append("getEnrollment").append("/").append("/enroll").append(clientDetailsType.getClientId())
						.append("/").append(clientDetailsType.getChannelId()).append("/")
						.append(clientDetailsType.getReqId()).append("/").append(respCode).append("/").append(respMsg)
						.append(timeTaken).append(typeOfError).append(ipAddress);

			} catch (UnknownException e2) {
				
			}
		}
		System.out.println("wsResp in ResourceLayer:: "+wsResp);
		return wsResp;

	}
}
