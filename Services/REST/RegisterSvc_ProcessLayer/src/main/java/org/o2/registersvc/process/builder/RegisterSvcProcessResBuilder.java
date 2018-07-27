package org.o2.registersvc.process.builder;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.beans.CreditCheckRes;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public class RegisterSvcProcessResBuilder {

	// Create the logger object
	private Logger logger = Logger.getLogger(RegisterSvcProcessResBuilder.class);

	public RegisterSvcProcessVBRes buildSerLayResp(CreditCheckRes creditCheckResp) {
		logger.info("Enter into RegisterSvcProcessResBuilder with credidCheckResp: " + creditCheckResp);

		// Preparing vbResp
		RegisterSvcProcessVBRes vbResp = new RegisterSvcProcessVBRes();
		vbResp.setRespCode(creditCheckResp.getRespCode());
		vbResp.setRespMsg(creditCheckResp.getRespMsg());
		vbResp.setScore(creditCheckResp.getScore());
		vbResp.setStatus(creditCheckResp.getStatus());

		logger.info("Exit from RegisterSvcProcessResBuilder vbResp is: " + vbResp);
		return vbResp;
	}

	public RegisterSvcProcessVBRes buildSerLayRespWithDaoResp(RegisterSvcDAORes daoResp) {

		logger.info("Enter into RegisterSvcProcessResBuilder with daoResp: " + daoResp);

		RegisterSvcProcessVBRes vbResp = new RegisterSvcProcessVBRes();
		vbResp.setRespCode(daoResp.getRespCode());
		vbResp.setRespMsg(daoResp.getRespMsg());

		logger.info("Exit from RegisterSvcProcessResBuilder vbResp is: " + vbResp);
		return vbResp;

	}
}
