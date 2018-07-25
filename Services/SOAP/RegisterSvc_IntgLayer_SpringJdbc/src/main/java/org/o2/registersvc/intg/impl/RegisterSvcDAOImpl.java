package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterServiceDAOReq;
import org.o2.registersvc.intg.beans.RegisterServiceDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

public class RegisterSvcDAOImpl extends StoredProcedure implements RegisterSvcDAO {

	public RegisterSvcDAOImpl(DataSource ds, String name) {
		super(getTemplate(), "GET_ENROLL");
		compileSP();
	}

	private static JdbcTemplate getTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/autop");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		JdbcTemplate jt = new JdbcTemplate(dataSource);
		return jt;

		// Verify the StoredPrcedure input param with their datatypes
	}

	private void compileSP() {
		// input params
		// Note:DeclareParameter is predefined available in StoredProcedure
		declareParameter(new SqlParameter("CLIENT_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUM_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CVV_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("EXP_DATE_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("NAME_ON_CARD_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("ACC_NUM_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("MOB_NUM_IN", Types.INTEGER));

		// output params
		declareParameter(new SqlParameter("RESP_CODE", Types.VARCHAR));
		declareParameter(new SqlParameter("RESP_MSG", Types.VARCHAR));

	}

	public RegisterServiceDAORes enrollment(RegisterServiceDAOReq daoReq)
			throws FileNotFoundException, BusinessException, SystemException, UnknownException {

		// Prepare the StoredProcedure input
		RegisterServiceDAORes daoResp = new RegisterServiceDAORes();

		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("CLIENT_ID_IN", daoReq.getClientId());
		inputMap.put("CHANNEL_ID_IN", daoReq.getChannelId());
		inputMap.put("CARD_NUM_IN", daoReq.getCardNum());
		inputMap.put("CVV_IN", daoReq.getCvv());
		inputMap.put("EXP_DATE_IN", daoReq.getExpDate());
		inputMap.put("NAME_ON_CARD_IN", daoReq.getNameOnCard());
		inputMap.put("ACC_NUM_IN", daoReq.getAccountNum());
		inputMap.put("MOB_NUM_IN", daoReq.getMobileNum());

		// Execute StoredProcedure
		Map<String, Object> returnMap = super.execute(inputMap);
		String errorCode = returnMap.get("RESP_CODE").toString();
		String errorMsg = returnMap.get("RESP_MSG").toString();

		try {
			if ("000".equals(errorCode)) {
				daoResp.setRespCode(errorCode);
				daoResp.setRespMsg(errorMsg);
			} else if ("1001".equals(errorCode) || "1002".equals(errorCode) || "1003".equals(errorCode)
					|| "1003".equals(errorCode) || "1004".equals(errorCode) || "1005".equals(errorCode)
					|| "1006".equals(errorCode)) {
				throw new BusinessException(errorCode, errorMsg);
			} else if ("2001".equals(errorCode) || "2002".equals(errorCode) || "2003".equals(errorCode)
					|| "2004".equals(errorCode)) {
				throw new SystemException(errorCode, errorCode);
			} else {
				throw new UnknownException("9999", "UnknownException");

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
