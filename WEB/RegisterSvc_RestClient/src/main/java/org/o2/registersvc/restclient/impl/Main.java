package org.o2.registersvc.restclient.impl;

import org.o2.registersvc.restclient.beans.RegisterSvcWebReq;
import org.o2.registersvc.restclient.beans.RegisterSvcWebRes;

public class Main {
	public static void main(String[] args) {
		RegisterSvcWebReq webReq = new RegisterSvcWebReq();
		webReq.setAccountNum("43554");
		webReq.setMobileNum(545454);
		webReq.setClientId("online");
		webReq.setChannelId("web");
		webReq.setReqId("4343");
		webReq.setCardNum("45454");
		webReq.setCvv("554");
		webReq.setExpDate("09/11/99");
		webReq.setNameOnCard("Narendra Modi");

		RegisterSvcRestClientImpl restClientImpl = new RegisterSvcRestClientImpl();
		RegisterSvcWebRes webResp = new RegisterSvcWebRes();
		System.out.println(webResp);
	}
}
