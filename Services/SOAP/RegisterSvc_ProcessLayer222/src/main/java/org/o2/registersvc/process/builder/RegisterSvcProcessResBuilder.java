package org.o2.registersvc.process.builder;

import org.o2.registersvc.creditcheck.beans.CreditCheckRes;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public class RegisterSvcProcessResBuilder {
	public RegisterSvcProcessVBRes buildDaoResp(CreditCheckRes ccResp) {

		// Preparing vbResp
		RegisterSvcProcessVBRes vbResp = new RegisterSvcProcessVBRes();
		vbResp.setRespCode(ccResp.getRespCode());
		vbResp.setRespMsg(ccResp.getRespMsg());
		vbResp.setScore(ccResp.getScore());
		vbResp.setStatus(ccResp.getStatus());
		return vbResp;
	}
}
