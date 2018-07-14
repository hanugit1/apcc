package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.o2.registersvc.intg.RegisterServiceDAO;
import org.o2.registersvc.intg.beans.RegisterServiceDAOReq;
import org.o2.registersvc.intg.beans.RegisterServiceDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public class RegisterServiceDAOImpl implements RegisterServiceDAO {

	public RegisterServiceDAORes enrollment(RegisterServiceDAOReq daoReq) throws FileNotFoundException, BusinessException, SystemException, UnknownException {
		// 1.Get the Req from Process layer
		// 2.Prepare the Req for Db
		// 3.Call Db and get ResultSet
		// 4.Prepare the DaoResp from ResultSet obj

		String env = System.getProperty("env");
		Properties prop = new Properties();
		FileReader reader = new FileReader("properties/enrolldb_" + env + ".properties");
		// prop.load(reader);

		RegisterServiceDAORes daoResp = null;
		try {//
			String dbRespCode = "1111";
			String dbRespMsg = "Success";
			if ("0".equals(dbRespCode)) {
				daoResp = new RegisterServiceDAORes();
				daoResp.setRespCode(dbRespCode);
				daoResp.setRespMsg(dbRespMsg);
			} else if ("1001".equals(dbRespCode) || "1002".equals(dbRespCode)) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			} else if ("1111".equals(dbRespCode) || "2222".equals(dbRespCode)) {
				throw new SystemException(dbRespCode, dbRespMsg);
			} else {
				throw new UnknownException(dbRespCode, dbRespMsg);
			}
		} catch (BusinessException e) {
			throw e;
		} catch (SystemException e) {
			throw e;
		} catch (UnknownException e) {
			throw e;
		}
		return daoResp;
	}

}
