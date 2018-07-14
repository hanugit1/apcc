package org.o2.registersvc.creditcheck.impl;

import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.creditcheck.beans.CreditCheckRes;

public class CreditCheckSvcClientImpl implements CreditCheckSvcClient {

	public CreditCheckRes getCreditScore(CreditCheckReq creditCheckReq) {
		//TODO: Need to writee code to invoke CreditCheckService
		
		CreditCheckRes creditCheckResp = new CreditCheckRes();
		creditCheckResp.setRespCode("000");
		creditCheckResp.setRespMsg("Success");
		creditCheckResp.setScore(60.00f);
		creditCheckResp.setStatus("good");
		
		return creditCheckResp;
	}

}
