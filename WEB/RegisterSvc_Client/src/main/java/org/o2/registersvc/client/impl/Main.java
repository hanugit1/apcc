package org.o2.registersvc.client.impl;

import org.o2.registersvc.service.RegisterService_Service;
import org.o2.registersvc.service.RegisterService;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.ServiceDetailsType;
import org.o2.registersvc.schema.res.RegisterServiceResType;

public class Main {
	public static void main(String[] args) {
		// 1.Create Service object
		RegisterService_Service service = new RegisterService_Service();

		// 2.Call the port and returns the interface
		RegisterService ref = service.getRegisterServicePort();

		// 3.Prepare the wsReq with the help of artifacts
		RegisterServiceReqType wsReq = new RegisterServiceReqType();

		// Prepare the AccountDetails object
		AccountDetailsType accDetails = new AccountDetailsType();
		accDetails.setAccountNum("5454343");
		accDetails.setMobileNum(99887788);

		// Prepare the CardDetails object
		CardDetailsType cardDetails = new CardDetailsType();
		cardDetails.setCardNum("43434");
		cardDetails.setCvv("534");
		cardDetails.setExpDate("09/11/55");
		cardDetails.setNameOnCard("sreenu");

		// Prepare the ClientDetails object
		ClientDetailsType clientDetails = new ClientDetailsType();
		clientDetails.setClientId("web");
		clientDetails.setChannelId("online");
		clientDetails.setReqId("4343");

		// Prepare the ServiceDetails object
		ServiceDetailsType svcDetails = new ServiceDetailsType();
		wsReq.setAccountDetails(accDetails);
		wsReq.setClientDetails(clientDetails);
		wsReq.setCardDetails(cardDetails);
		wsReq.setServiceDetails(svcDetails);

		// Call the api by passing wsReq and get the wsResp
		RegisterServiceResType wsResp = ref.enrollment(wsReq);

		if (wsResp != null && wsResp.getStatusBlock() != null && "000".equals(wsResp.getStatusBlock().getRespMsg())) {

		}
	}
}
