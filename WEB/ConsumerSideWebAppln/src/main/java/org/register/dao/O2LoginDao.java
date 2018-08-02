package org.register.dao;

import org.register.beans.O2LoginResp;

import o2.register.formdata.O2LoginFormData;

public class O2LoginDao {
	public O2LoginResp process(O2LoginFormData loginFormData) {
		System.out.println(loginFormData);
		O2LoginResp loginResp = null;
		if (loginFormData.getAccNum().equals("123") && loginFormData.getMobNum().equals("321")
				&& loginFormData.getPass().equals("pass")) {
			loginResp = new O2LoginResp();
			loginResp.setRespCode("0000");
			loginResp.setRespMsg("Valid user");
		} else {
			loginResp = new O2LoginResp();
			loginResp.setRespCode("1111");
			loginResp.setRespMsg("Invalid user");
		}
		return loginResp;

	}
}
