package org.o2.registersvc.process.impl;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.creditcheck.beans.CreditCheckRes;
import org.o2.registersvc.creditcheck.impl.CreditCheckSvcClientImpl;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.impl.RegisterSvcDAOImpl;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.builder.RegisterSvcProcessReqBuilder;
import org.o2.registersvc.process.builder.RegisterSvcProcessResBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcProcessImpl implements RegisterSvcProcess {

	// Create logger object
	private Logger logger = Logger.getLogger(RegisterSvcProcessImpl.class);

	@Autowired
	private CreditCheckSvcClientImpl ccSvcClientImpl;

	@Autowired
	private RegisterSvcDAORes daoResp;

	@Autowired
	private RegisterSvcDAOImpl daoImpl;

	@Autowired
	private RegisterSvcDAOReq daoReq;

	@Autowired
	private RegisterSvcProcessReqBuilder processReqBuilder;

	@Autowired
	private CreditCheckRes ccResp;

	@Autowired
	private CreditCheckReq ccReq;

	@Autowired
	private RegisterSvcProcessResBuilder processRespBuiler;

	@Autowired
	private RegisterSvcProcessVBRes processVbResp;

	public RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq)
			throws FileNotFoundException, BusinessException, SystemException, UnknownException {

		logger.debug("Enter into ProcessLayer with vbReq: " + vbReq);

		// Build CreditCheckReq
		ccReq = processReqBuilder.buildCreditCheckReq(vbReq);

		// Call the CreditCheck by passing CreditCheckReq ccReq
		ccResp = ccSvcClientImpl.getCreditScore(ccReq);

		// If client Credit score more than 60% then we call DAOLayer
		if (ccResp != null && ccResp.getScore() >= 60) {

			// Prepare the daoReq
			daoReq = processReqBuilder.buildDaoReq(vbReq);

			// Call the DaoLayer by passing daoReq
			daoResp = daoImpl.enrollment(daoReq);
			logger.info("dao respCode & respMsg in ProcessLayer:: " + daoResp.getRespCode() + "_____"
					+ daoResp.getRespMsg());
		}

		// Prepare ProcessLayer Response processVbResp with CreditCheckRes ccResp
		processVbResp = processRespBuiler.buildSerLayRespWithDaoResp(daoResp);
		logger.info("Exit from ProcessLayer processVbResp:: " + processVbResp);
		return processVbResp;
	}

}
