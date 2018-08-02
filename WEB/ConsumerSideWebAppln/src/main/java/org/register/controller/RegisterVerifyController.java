package org.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.o2.registersvc.client.beans.RegisterSvcWebReq;
import org.o2.registersvc.client.beans.RegisterSvcWebRes;
import org.o2.registersvc.client.impl.RegisterSvcClientImpl;
import org.register.beans.O2RegResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import o2.register.formdata.O2RegistrationFormData;

@Controller
public class RegisterVerifyController {
	public O2RegResp processInVerify(@ModelAttribute O2RegistrationFormData regFormData, Model model,
			HttpServletRequest httpSerReq) {

		HttpSession httpSession = httpSerReq.getSession();
		regFormData = (O2RegistrationFormData) httpSession.getAttribute("regFormData");
		String accId = (String) httpSession.getAttribute("accId");
		System.out.println("RegisterVerifyController:: " + regFormData + "accId" + accId);
		O2RegResp regResp = new O2RegResp();

		RegisterSvcClientImpl clientImpl = new RegisterSvcClientImpl();
		RegisterSvcWebReq wsReq = new RegisterSvcWebReq();

		// Prepare the wsReq
		wsReq.setAccountNum(accId);
		wsReq.setCardNum(regFormData.getCardNum());
		wsReq.setCvv(regFormData.getCvv());
		wsReq.setExpDate(regFormData.getExpDate());
		wsReq.setNameOnCard(regFormData.getNameOnCard());

		// Prepare the wsResp
		RegisterSvcWebRes wsResp = new RegisterSvcWebRes();
		System.out.println(wsResp);
		regResp.setRespCode(wsResp.getRespCode());
		regResp.setRespMsg(wsResp.getRespMsg());

		return regResp;

	}
}
