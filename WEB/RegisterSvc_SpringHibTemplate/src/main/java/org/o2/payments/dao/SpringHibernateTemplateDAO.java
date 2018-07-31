package org.o2.payments.dao;

import org.o2.payments.model.RegisterSvcHbReq;
import org.o2.payments.model.RegisterSvcHbRes;

public interface SpringHibernateTemplateDAO {
	public RegisterSvcHbRes enrollment(RegisterSvcHbReq req);
}
