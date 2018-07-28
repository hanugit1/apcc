package org.o2.registersvc.process.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.springconfig.ProcessSpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProcessMain {
	public static void main(String[] args) throws FileNotFoundException, org.o2.registersvc.intg.util.BusinessException, SystemException, UnknownException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProcessSpringConfig.class);
		RegisterSvcProcessImpl process = context.getBean(RegisterSvcProcessImpl.class);
		RegisterSvcProcessVBReq vbReq = new RegisterSvcProcessVBReq();
		
		vbReq.setAccountNum("123");
		vbReq.setCardNum("534");
		vbReq.setChannelId("web");
		vbReq.setClientId("online");
		vbReq.setCvv("565");
		vbReq.setExpDate("22/06/45");
		vbReq.setMobileNum(998877663);
		vbReq.setNameOnCard("charan");
		
		try {
			process.enrollment(vbReq);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (UnknownException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
