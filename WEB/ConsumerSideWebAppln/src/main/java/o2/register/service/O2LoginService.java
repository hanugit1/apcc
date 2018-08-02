package o2.register.service;

import org.register.beans.O2LoginResp;
import org.register.dao.O2LoginDao;

import o2.register.formdata.O2LoginFormData;

public class O2LoginService {
	private O2LoginDao loginDao;

	public O2LoginResp process(O2LoginFormData loginFormData) {
		return loginDao.process(loginFormData);
		
		
	}
}
