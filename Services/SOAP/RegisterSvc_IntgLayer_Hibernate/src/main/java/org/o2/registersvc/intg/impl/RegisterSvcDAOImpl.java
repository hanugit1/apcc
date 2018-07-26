package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import javax.security.auth.login.CredentialExpiredException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.o2.registersvc.entities.AccountDetails;
import org.o2.registersvc.entities.ChannelDetails;
import org.o2.registersvc.entities.ClientDetails;
import org.o2.registersvc.entities.CustomerDetails;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.HibernateUtility;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public class RegisterSvcDAOImpl implements RegisterSvcDAO {

	private static Logger logger = Logger.getLogger(RegisterSvcDAOImpl.class);
	RegisterSvcDAORes daoResp = null;

	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws FileNotFoundException, BusinessException, SystemException, UnknownException {

		SessionFactory sFactory = null;
		Session session = null;
		Transaction txn = null;
		try {
			// Create SessionFactory
			sFactory = HibernateUtility.getSessionFactory();

			// Create Session Object
			session = sFactory.openSession();

			// Create Transaction
			txn = session.beginTransaction();

			// Check client_id
			Criteria criteria2 = session.createCriteria(ClientDetails.class);
			criteria2.add(Restrictions.eq("clientId", daoReq.getClientId()));
			List clientId = criteria2.list();

			// Check channel_id
			Criteria criteria3 = session.createCriteria(ChannelDetails.class);
			criteria3.add(Restrictions.eq("channelId", daoReq.getChannelId()));
			List channelId = criteria3.list();

			Query query = session.createQuery("from AccountDetails where accId=? and mobNum=?");
			query.setString(0, daoReq.getAccountNum());
			query.setLong(1, daoReq.getMobileNum());
			List<AccountDetails> accDetails = query.list();

			if (clientId.size() > 0 && channelId.size() > 0 && accDetails.size() > 0) {
				// Create CustomerDetails Object
				CustomerDetails custDetails = new CustomerDetails();

				// Set CutometDetails values
				custDetails.setCardNum(daoReq.getCardNum());
				custDetails.setCvv(daoReq.getCvv());
				custDetails.setExpDate(daoReq.getExpDate());
				custDetails.setMobNum(daoReq.getMobileNum());
				custDetails.setNameOnCard(daoReq.getNameOnCard());

				Object sno = session.save(custDetails);
				txn.commit();
				if (sno != null) {
					daoResp = new RegisterSvcDAORes();
					daoResp.setRespCode("0000");
					daoResp.setRespMsg("Success");
				} else if (clientId.size() == 0) {
					daoResp = new RegisterSvcDAORes();
					daoResp.setRespCode("1001");
					daoResp.setRespMsg("Invalid clientId");
				} else if (channelId.size() == 0) {
					daoResp = new RegisterSvcDAORes();
					daoResp.setRespCode("1002");
					daoResp.setRespMsg("Invalid channelId");
				} else if (accDetails.size() == 0) {
					daoResp = new RegisterSvcDAORes();
					daoResp.setRespCode("1003");
					daoResp.setRespMsg("Invalid accountDetails");
				}
				System.out.println(daoResp);

			}
		} catch (Exception e) {
			txn.rollback();
		}

		return daoResp;

	}
}
