package org.o2.registersvc.process.impl;

import org.o2.registersvc.intg.beans.RegisterServiceDAOReq;
import org.o2.registersvc.process.RegisterServiceProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public class RegisterServiceProcessImpl implements RegisterServiceProcess {

	public RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq) {
		//1.Get the Req from Service Layer
		//2.Prepare the DaoReq
		RegisterServiceDAOReq daoReq = new RegisterServiceDAOReq();
		daoReq.setClientId(vbReq.getClientId());
		daoReq.setChannelId(vbReq.getChannelId());
		daoReq.setCardNum(vbReq.getCardNum());
		daoReq.setCvv(vbReq.getCvv());
		daoReq.setExpDate(vbReq.getExpDate());
		daoReq.setNameOnCard(vbReq.getNameOnCard());
		daoReq.setAccountNum(vbReq.getAccountNum());
		daoReq.setMobileNum(vbReq.getMobileNum());
		//3.Call the CreditCheck based on CreditCheck Response
		
		
		return null;
	}

}
