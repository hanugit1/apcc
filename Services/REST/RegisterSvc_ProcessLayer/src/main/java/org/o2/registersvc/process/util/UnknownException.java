package org.o2.registersvc.process.util;

public class UnknownException extends Exception {
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