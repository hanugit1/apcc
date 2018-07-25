package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.config.IntgSpringConfig;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, SystemException, UnknownException {
		ApplicationContext context = new AnnotationConfigApplicationContext(IntgSpringConfig.class);
		RegisterSvcDAOImpl_SpringJdbc daoImpl = context.getBean(RegisterSvcDAOImpl_SpringJdbc.class);
		System.out.println("daoImpl:: " + daoImpl);

		RegisterSvcDAOReq daoReq = new RegisterSvcDAOReq();
		daoReq.setClientId("online");
		daoReq.setChannelId("web");
		daoReq.setAccountNum("223345544");
		daoReq.setCardNum("88775544333");
		daoReq.setCvv("342");
		daoReq.setExpDate("23/09/25");
		daoReq.setNameOnCard("Reddy");
		daoReq.setMobileNum(9988776655l);

		try {
			daoImpl.enrollment(daoReq);

		} catch (BusinessException e) {

		} catch (SystemException e) {

		} catch (UnknownException e) {

		} catch (Exception e) {

		}
	}

}
