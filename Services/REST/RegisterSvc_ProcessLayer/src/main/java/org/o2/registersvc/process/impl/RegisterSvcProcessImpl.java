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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcProcessImpl implements RegisterSvcProcess {

	// Create logger object
	private Logger logger = Logger.getLogger(RegisterSvcProcessImpl.class);
	
	@Autowired
	private CreditCheckSvcClientImpl ccSvcClientImpl;
	private RegisterSvcDAORes daoResp;
	private RegisterSvcDAOImpl daoImpl;
	private RegisterSvcDAOReq daoReq;
	private RegisterSvcProcessReqBuilder processReqBuilder;
	private CreditCheckRes ccResp;

	public RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq) {

		return null;

	}
}
