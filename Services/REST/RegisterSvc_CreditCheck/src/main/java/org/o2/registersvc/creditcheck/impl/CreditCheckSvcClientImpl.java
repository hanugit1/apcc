package org.o2.registersvc.creditcheck.impl;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.creditcheck.beans.CreditCheckRes;

public class CreditCheckSvcClientImpl implements CreditCheckSvcClient {

	// Create logger object
	private Logger logger = Logger.getLogger(CreditCheckSvcClientImpl.class);

	public CreditCheckRes getCreditScore(CreditCheckReq creditCheckReq) {

		logger.info("Enter into CreditCheckSvcClientImpl creditCheckReq: " + creditCheckReq);
		// TODO: Need to writee code to invoke CreditCheckService

		CreditCheckRes creditCheckResp = new CreditCheckRes();
		creditCheckResp.setRespCode("000");
		creditCheckResp.setRespMsg("Success");
		creditCheckResp.setScore(60.00f);
		creditCheckResp.setStatus("good");

		logger.info("Exit from CreditCheckSvcClientImpl creditCheckResp: " + creditCheckResp);
		return creditCheckResp;
	}

}
