package org.o2.registersvc.builder;

import javax.servlet.http.HttpServletRequest;

import org.o2.registersvc.client.beans.RegisterSvcWebReq;

public class RegisterServletReqBuilder {
	public RegisterSvcWebReq buildWebReq(HttpServletRequest req) {
		RegisterSvcWebReq webReq = new RegisterSvcWebReq();
		webReq.setCardNum(req.getParameter("cardNum"));
		webReq.setCvv(req.getParameter("cvv"));
		webReq.setExpDate(req.getParameter("expDate"));
		webReq.setNameOnCard(req.getParameter("nameOnCard"));
		
		webReq.setMobileNum(Long.valueOf(req.getParameter("mobNum")));
		webReq.setAccountNum("4535345");
		
		webReq.setClientId("online");
		webReq.setChannelId("web");
		//webReq.setReqId("434");
		

		return webReq;

	}
}
