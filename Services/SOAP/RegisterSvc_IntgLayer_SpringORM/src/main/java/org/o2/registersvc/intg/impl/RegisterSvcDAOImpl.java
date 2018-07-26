package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.entities.ChannelDetails;
import org.o2.registersvc.intg.entities.CustomerDetails;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.HibernateUtility;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class RegisterSvcDAOImpl implements RegisterSvcDAO{

	private Logger logger = Logger.getLogger(RegisterSvcDAOImpl.class);
	
	RegisterSvcDAORes daoResp = null;
	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws FileNotFoundException, BusinessException, SystemException, UnknownException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_hibernateTemplate.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
		daoResp = new RegisterSvcDAORes();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		//Verifying mobile number
		Query query = session.createQuery("from CustomerDetails where mob_num=?");
		query.setLong(0, daoReq.getMobileNum());
		List<CustomerDetails> custDetailsList = query.list();
		System.out.println("Customer Details list:: "+custDetailsList);
		
		if(custDetailsList.size() == 0) {
			daoResp.setRespCode("1001");
			daoResp.setRespMsg("Invalid Mobile Number");
			return daoResp;
		}
		
		//Verifying channel_id
		Criteria criteria = session.createCriteria(ChannelDetails.class);
		criteria.add(Restrictions.eq("channel_id", daoReq.getChannelId()));
		List<ChannelDetails> channelList = criteria.list();
		
		if(channelList == null && (channelList.size() == 0)) {
			daoResp.setRespCode("rg002");
			daoResp.setRespMsg("Invalid channel id");
		}
		
		daoResp.setRespCode("0000");
		daoResp.setRespMsg("Success");
		session.close();
		HibernateUtility.shutdown();
		
		return daoResp;
	}

}
