package org.o2.payments.dao.impl;

import org.o2.payments.model.RegisterSvcHbReq;
import org.o2.payments.model.RegisterSvcHbRes;

public class SpringHibernateTemplateTest {
	public static void main(String[] args) {
		SpringHibernateTemplateDaoImpl ht = new SpringHibernateTemplateDaoImpl();
		RegisterSvcHbReq req = new RegisterSvcHbReq();
		req.setCardNum("3434");
		req.setCvv("433");
		req.setExpDate("01/12/34");
		req.setMobileNum(34343434);
		req.setNameOnCard("ravi");
		RegisterSvcHbRes resp = new RegisterSvcHbRes();
		System.out.println(resp);
	}
}
