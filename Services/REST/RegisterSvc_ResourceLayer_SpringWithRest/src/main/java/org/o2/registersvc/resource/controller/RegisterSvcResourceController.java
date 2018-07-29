package org.o2.registersvc.resource.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.Date;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.util.SystemException;
import org.o2.registersvc.resource.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.resource.builder.RegisterSvcResBuilder;
import org.o2.registersvc.resource.exception.RegisterSvcReqInvalidException;
import org.o2.registersvc.resource.util.BusinessException;
import org.o2.registersvc.resource.util.UnknownException;
import org.o2.registersvc.resource.validator.RegisterSvcValidator;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/service")
@RestController
public class RegisterSvcResourceController {

	// Create Logger object
	Logger logger = Logger.getLogger(RegisterSvcResourceController.class);

	// Injecting bean class objects using AutoWiring

	@Autowired
	private AccountDetailsType accDetailsType;

	@Autowired
	private CardDetailsType cardDetailsType;

	@Autowired
	private ClientDetailsType clientDetailsType;

	@Autowired
	private RegisterServiceReqType wsReq;

	@Autowired
	private RegisterServiceResType wsResp;

	@Autowired
	private RegisterSvcValidator validator;

	@Autowired
	private StatusBlockType statusBlockType;

	@Autowired
	private RegisterSvcReqBuilder svcReqBuilder;

	@Autowired
	private RegisterSvcResBuilder svcRespBuiler;

	@Autowired
	private RegisterSvcProcess process;

	String respCode = "0000";
	String respMsg = "Sucess";
	String typeOfError = "s";
	long t1 = System.currentTimeMillis();
	long t2;

	@RequestMapping(value = "/postenrollment", method = RequestMethod.POST)
	public RegisterServiceResType postEnrollment(@RequestBody RegisterServiceReqType wsReq,
			@RequestHeader("x-client-id") String clientId, @RequestHeader("x-channel-id") String channelId,
			@RequestHeader("x-req-id") String reqId) {

		try {
			t2 = System.currentTimeMillis();
			// Setting ClientDetails
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setReqId(reqId);
			wsReq.setClientDetails(clientDetailsType);

			logger.info("Enter into ResourceLayer with:: " + wsReq);

			// Calling Validator to validate the consumer input
			validator.validateWsReq(wsReq);

			// Prepare ProccesLayer Req ie., vbReq
			RegisterSvcProcessVBReq vbReq = svcReqBuilder.buildProcessReq(wsReq);

			// Calling ProcessLayer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);

			// Prepare wsResp to vbResp
			wsResp = svcRespBuiler.buildWsResp(vbResp);

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

				logger.warn(builder);

			} catch (Exception e2) {

			}
		}

		return wsResp;
	}

	@RequestMapping(value = "/geternrollment/{accNum}/{mobNum}/{cardNum}/{cvv}/{expDate}/{nameOnCard}", method = RequestMethod.GET)
	public RegisterServiceResType getEnrollment(@PathVariable("accNum") String accNum,
			@PathVariable("mobNum") String mobNum, @PathVariable("cardNum") String cardNum,
			@PathVariable("cvv") String cvv, @PathVariable("expDate") String expDate,
			@PathVariable("nameOnCard") String nameOnCard, @RequestHeader("x-client-id") String clientId,
			@RequestHeader("x-channel-id") String channelId, @RequestHeader("x-req-id") String reqId) {

		try {
			System.out.println("Enter into ResourceLayer");
			t2 = System.currentTimeMillis();

			// Setting AccountDetails
			accDetailsType.setAccountNum(accNum);
			accDetailsType.setMobileNum(Long.parseLong(mobNum));

			// Setting ClientDetails
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setReqId(reqId);

			// Setting CardDetails
			cardDetailsType.setCardNum(cardNum);
			cardDetailsType.setCvv(cvv);
			cardDetailsType.setExpDate(expDate);
			cardDetailsType.setNameOnCard(nameOnCard);

			wsReq.setAccountDetails(accDetailsType);
			wsReq.setCardDetails(cardDetailsType);
			wsReq.setClientDetails(clientDetailsType);

			logger.debug("Enter into ResourceLayer with:: " + wsReq);

			// Calling Validator to validate the consumer input
			validator.validateWsReq(wsReq);

			// Prepare ProccesLayer Req ie., vbReq
			RegisterSvcProcessVBReq vbReq = svcReqBuilder.buildProcessReq(wsReq);

			// Call ProcessLayer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);
			logger.debug("vbResp respCode and respMsg in ResourceLayer:: " + vbResp.getRespCode() + ":::"
					+ vbResp.getRespMsg());

			// Prepare wsResp to vbResp
			wsResp = svcRespBuiler.buildWsResp(vbResp);

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

			}
		}
		return wsResp;

	}

}
