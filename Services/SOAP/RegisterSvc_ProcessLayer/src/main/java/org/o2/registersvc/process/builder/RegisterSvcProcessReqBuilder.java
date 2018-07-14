package org.o2.registersvc.process.builder;

import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.intg.beans.RegisterServiceDAOReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;

public class RegisterSvcProcessReqBuilder {
	public RegisterServiceDAOReq buildDaoReq(RegisterSvcProcessVBReq vbReq) {
		
		//Preparing daoReq
		RegisterServiceDAOReq daoReq = new RegisterServiceDAOReq();
		daoReq.setClientId(vbReq.getClientId());
		daoReq.setChannelId(vbReq.getChannelId());
		daoReq.setCardNum(vbReq.getCardNum());
		daoReq.setCvv(vbReq.getCvv());
		daoReq.setExpDate(vbReq.getExpDate());
		daoReq.setNameOnCard(vbReq.getNameOnCard());
		daoReq.setAccountNum(vbReq.getAccountNum());
		daoReq.setMobileNum(vbReq.getMobileNum());
		return daoReq;
		
	}
	public CreditCheckReq buildCreditCheckReq(RegisterSvcProcessVBReq vbReq) {
		
		//Preparing CreditCheck Request
		CreditCheckReq ccReq = new CreditCheckReq();
		ccReq.setCardNum(vbReq.getCardNum());
		ccReq.setCvv(vbReq.getCvv());
		ccReq.setExpDate(vbReq.getExpDate());
		ccReq.setNameOnCard(vbReq.getNameOnCard());
		ccReq.setMobileNum(vbReq.getMobileNum());
		ccReq.setClientId(vbReq.getClientId());
		ccReq.setChannelId(vbReq.getChannelId());
		return ccReq ;
	}
}
