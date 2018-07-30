package org.o2.registersvc.client.impl;

import org.o2.registersvc.client.beans.RegisterSvcWebReq;
import org.o2.registersvc.client.beans.RegisterSvcWebRes;
import org.o2.registersvc.service.RegisterService_Service;
import org.o2.registersvc.service.RegisterService;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.client.exception.ApplicationExceptions;

public class RegisterSvcClientImpl implements org.o2.registersvc.client.RegisterSvcClient {

	public RegisterSvcWebRes enrollment(RegisterSvcWebReq webReq) throws ApplicationExceptions {
		System.out.println(webReq);

		// 1.Create Service object
		RegisterService_Service service = new RegisterService_Service();

		// 2.Call the port and returns the interface
		RegisterService ref = service.getRegisterServicePort();

		// 3.Prepare the wsReq with the help of artifacts
		RegisterServiceReqType wsReq = new RegisterServiceReqType();

		// Create the Account object
		AccountDetailsType accDetailsType = new AccountDetailsType();
		accDetailsType.setAccountNum(webReq.getAccountNum());
		accDetailsType.setMobileNum(webReq.getMobileNum());

		// Create the ClientDetails object
		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientId(webReq.getClientId());
		clientDetailsType.setChannelId(webReq.getChannelId());
		// clientDetailsType.setReqId(webReq.getReqId());

		// Create CardDetails object
		CardDetailsType cardDetailsType = new CardDetailsType();
		cardDetailsType.setCardNum(webReq.getCardNum());
		cardDetailsType.setCvv(webReq.getCvv());
		cardDetailsType.setExpDate(webReq.getExpDate());
		cardDetailsType.setNameOnCard(webReq.getNameOnCard());

		// Prepare Service Details object
		wsReq.setAccountDetails(accDetailsType);
		wsReq.setClientDetails(clientDetailsType);
		wsReq.setCardDetails(cardDetailsType);

		// Call the api by passing wsReq and get the wsResp
		RegisterServiceResType wsResp = ref.enrollment(wsReq);

		// Prepare Client Resp
		RegisterSvcWebRes webResp = new RegisterSvcWebRes();

		if ("0000".equals(wsResp.getStatusBlock().getRespCode())) {
			webResp.setRespCode(wsResp.getStatusBlock().getRespCode());
			webResp.setRespMsg(wsResp.getStatusBlock().getRespMsg());
			webResp.setScore(wsResp.getCreditCheck().getRateOfPer());
			webResp.setStatus(wsResp.getCreditCheck().getCreditStatus());
		} else if ("reg001".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg001", "Req object is invalid");
		} else if ("reg002".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg002", "Client Id is invalid");
		} else if ("reg003".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg003", "Channel Id is invalid");
		} else if ("reg004".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg004", "Card Number is invalid");
		} else if ("reg005".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg005", "Mobile Number is invalid");
		} else if ("reg006".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg006", "Cvv is invalid");
		} else if ("reg007".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg007", "Exp Date is invalid");
		} else if ("reg008".equals(wsResp.getStatusBlock().getRespCode())) {
			throw new ApplicationExceptions("reg008", "invalid Name on card");
		}
		return webResp;
	}

}
