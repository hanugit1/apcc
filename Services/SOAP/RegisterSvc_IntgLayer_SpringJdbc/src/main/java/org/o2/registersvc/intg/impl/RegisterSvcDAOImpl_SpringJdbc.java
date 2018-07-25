package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcDAOImpl_SpringJdbc extends StoredProcedure implements RegisterSvcDAO {
	static Logger logger = Logger.getLogger(RegisterSvcDAOImpl_SpringJdbc.class);

	public RegisterSvcDAOImpl_SpringJdbc(JdbcTemplate jt) {
		super(jt, "GET_ENROLL");
		compileSP();
	}

	// Verify the StoredPrcedure input & output parameters with their Datatypes

	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws FileNotFoundException, BusinessException, SystemException, UnknownException {

		logger.debug("Enter into RegisterSvcDAOImpl_SpringJdbc class enrollment method with daoReq:: " + daoReq);
		// Prepare the StoredProcedure input
		RegisterSvcDAORes daoResp = new RegisterSvcDAORes();

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
		logger.debug("Executing StoredProcedure by passing input parameters");
		Map<String, Object> returnMap = super.execute(inputMap);
		final String respCode = returnMap.get("RESP_CODE").toString();
		final String respMsg = returnMap.get("RESP_MSG").toString();

		logger.info("respCode from ps: " + respCode);
		logger.info("respMsg from ps: " + respMsg);

		try {
			if ("0000".equals(respCode)) {
				daoResp.setRespCode(respCode);
				daoResp.setRespMsg(respMsg);
			} else if ("1000".equals(respCode)) {
				throw new BusinessException(respCode, respMsg);
			} else if ("1001".equals(respCode)) {
				throw new SystemException(respCode, respCode);
			} else {
				throw new UnknownException("9999", "UnknownException");

			}
		} catch (BusinessException e) {
			throw e;
		} catch (SystemException e) {
			throw e;
		} catch (UnknownException e) {
			throw e;
		} catch (Exception e) {
			logger.fatal("Exception", e);
		}
		return daoResp;
	}

	private void compileSP() {

		logger.debug("Enter into compileSP()");
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

		logger.debug("Exit from compileSP method");
	}
}