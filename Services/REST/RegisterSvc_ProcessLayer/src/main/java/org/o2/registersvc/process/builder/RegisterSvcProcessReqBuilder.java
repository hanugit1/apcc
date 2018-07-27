package org.o2.registersvc.process.builder;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;

public class RegisterSvcProcessReqBuilder {

	// Create the logger object
	private Logger logger = Logger.getLogger(RegisterSvcProcessReqBuilder.class);

	public CreditCheckReq buildCreditCheckReq(RegisterSvcProcessVBReq vbReq) {

		logger.info("Enter into RegisterSvcProcessReqBuilder vbReq: " + vbReq);
		// Preparing CreditCheck Request
		CreditCheckReq creditCheckReq = new CreditCheckReq();
		creditCheckReq.setCardNum(vbReq.getCardNum());
		creditCheckReq.setCvv(vbReq.getCvv());
		creditCheckReq.setExpDate(vbReq.getExpDate());
		creditCheckReq.setNameOnCard(vbReq.getNameOnCard());
		creditCheckReq.setMobileNum(vbReq.getMobileNum());
		creditCheckReq.setClientId(vbReq.getClientId());
		creditCheckReq.setChannelId(vbReq.getChannelId());
		return creditCheckReq;
	}

	public RegisterSvcDAOReq buildDaoReq(RegisterSvcProcessVBReq vbReq) {

		// Preparing daoReq
		RegisterSvcDAOReq daoReq = new RegisterSvcDAOReq();
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
}
