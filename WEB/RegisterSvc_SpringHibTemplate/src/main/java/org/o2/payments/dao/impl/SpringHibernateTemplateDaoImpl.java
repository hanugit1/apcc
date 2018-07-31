package org.o2.payments.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.o2.payments.dao.SpringHibernateTemplateDAO;
import org.o2.payments.entities.CustomerDetails;
import org.o2.payments.model.RegisterSvcHbReq;
import org.o2.payments.model.RegisterSvcHbRes;
import org.o2.payments.utils.HibernateUtility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SpringHibernateTemplateDaoImpl implements SpringHibernateTemplateDAO {

	public RegisterSvcHbRes enrollment(RegisterSvcHbReq req) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_hibTemplate.xml");
		HibernateTemplate hibTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
		RegisterSvcHbRes resp = new RegisterSvcHbRes();
		Session session = hibTemplate.getSessionFactory().openSession();

		// Customer Details
		Criteria criteria = session.createCriteria(CustomerDetails.class);
		criteria.add(Restrictions.eq("card_num", req.getCardNum()));
		criteria.add(Restrictions.eq("cvv", req.getCvv()));
		List<CustomerDetails> custDetails = criteria.list();
		System.out.println("Customer Details: " + custDetails);
		if (custDetails == null && (custDetails.size() <= 0)) {
			resp.setRespCode("Reg02");
			resp.setRespMsg("invalid Card Number or cvv or Exp Date");
			return resp;
		}

		resp.setRespCode("reg000");
		resp.setRespMsg("Success");
		session.close();
		HibernateUtility.shutdown();

		return resp;
	}

}
