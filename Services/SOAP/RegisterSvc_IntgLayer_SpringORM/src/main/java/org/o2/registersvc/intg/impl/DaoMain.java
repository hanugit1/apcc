package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import javax.net.ssl.SSLEngineResult.Status;

import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public class DaoMain {
	public static void main(String[] args) throws FileNotFoundException, SQLException {

		RegisterSvcDAOReq daoReq = new RegisterSvcDAOReq();
		daoReq.setAccountNum("12323");
		daoReq.setCardNum("445445");
		daoReq.setChannelId("web");
		daoReq.setClientId("online");
		daoReq.setCvv("434");
		daoReq.setExpDate("09/1/25");
		daoReq.setMobileNum(889988444);
		daoReq.setNameOnCard("raghu");

		RegisterSvcDAOImpl daoImpl = new RegisterSvcDAOImpl();
		try {
			RegisterSvcDAORes daoResp = daoImpl.enrollment(daoReq);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (UnknownException e) {
			e.printStackTrace();
		} /*
			 * catch (SQLException e) { e.printStackTrace(); }
			 */

	}
}
