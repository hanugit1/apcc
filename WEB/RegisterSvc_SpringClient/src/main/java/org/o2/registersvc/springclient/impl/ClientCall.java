package org.o2.registersvc.springclient.impl;

import org.o2.registersvc.springclient.beans.RegisterSvcWebReq;
import org.o2.registersvc.springclient.beans.RegisterSvcWebRes;

public class ClientCall {
	public static void main(String[] args) {
		RegisterSvcWebReq webReq = new RegisterSvcWebReq();
		webReq.setAccountNum("45454");
		webReq.setMobileNum(4545454);
		webReq.setClientId("online");
		webReq.setChannelId("web");
		webReq.setReqId("4343");
		webReq.setCardNum("45454");
		webReq.setCvv("545");
		webReq.setExpDate("09/04/55");
		webReq.setNameOnCard("ravi");

		RegisterSvcSpringClientImpl springClientImpl = new RegisterSvcSpringClientImpl();
		RegisterSvcWebRes webResp = springClientImpl.enrollment(webReq);
		System.out.println("Response is: " + webResp);
	}
}
