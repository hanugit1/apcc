package org.o2.registersvc.service.util;

public class BusinessException extends Exception {
	private String respCode;
	private String respMsg;

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

}
