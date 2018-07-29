package org.o2.registersvc.resource.util;

public class SystemException extends Exception {
	private String respCode;
	private String respMsg;

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

}
//