package org.o2.registersvc.process.impl;

import java.io.FileNotFoundException;

import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.creditcheck.beans.CreditCheckRes;
import org.o2.registersvc.creditcheck.impl.CreditCheckSvcClientImpl;
import org.o2.registersvc.intg.RegisterServiceDAO;
import org.o2.registersvc.intg.beans.RegisterServiceDAOReq;
import org.o2.registersvc.intg.beans.RegisterServiceDAORes;
import org.o2.registersvc.intg.impl.RegisterServiceDAOImpl;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public class RegisterSvcProcessImpl implements RegisterSvcProcess {

	public RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq) throws FileNotFoundException, BusinessException, SystemException, UnknownException {
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
		CreditCheckSvcClient ccSvcClient = new CreditCheckSvcClientImpl();
		CreditCheckReq ccReq = new CreditCheckReq();
		ccReq.setCardNum(vbReq.getCardNum());
		ccReq.setCvv(vbReq.getCvv());
		ccReq.setExpDate(vbReq.getExpDate());
		ccReq.setNameOnCard(vbReq.getNameOnCard());
		ccReq.setClientId(vbReq.getClientId());
		ccReq.setChannelId(vbReq.getChannelId());
		
		CreditCheckRes ccResp = ccSvcClient.getCreditScore(ccReq);
		if(ccResp != null && ccResp.getScore() > 60) {
			//4.Call the Dao
			RegisterServiceDAO dao = new RegisterServiceDAOImpl();
			RegisterServiceDAORes daoResp = dao.enrollment(daoReq);
		}
		//5.Prepare the VbResp i.e., convert daoResp to Process Response
		RegisterSvcProcessVBRes vbResp = new RegisterSvcProcessVBRes();
		vbResp.setRespCode(ccResp.getRespCode());
		vbResp.setRespMsg(ccResp.getRespMsg());
		vbResp.setScore(ccResp.getScore());
		vbResp.setStatus(ccResp.getStatus());
		return vbResp;
	}

}
