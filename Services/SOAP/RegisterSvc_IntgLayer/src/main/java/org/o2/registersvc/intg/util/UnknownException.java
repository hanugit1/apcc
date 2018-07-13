package org.o2.registersvc.intg.util;

public class UnknownException extends Exception {
	private String respCode;
	private String respMsg;

	public UnknownException(String respCode, String respMsg) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
//
	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

}
