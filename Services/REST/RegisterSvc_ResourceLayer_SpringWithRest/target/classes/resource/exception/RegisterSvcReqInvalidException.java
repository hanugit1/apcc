package org.o2.registersvc.resource.exception;

public class RegisterSvcReqInvalidException extends Exception {
	private String respCode;
	private String respMsg;

	public RegisterSvcReqInvalidException(String respCode, String respMsg) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}//
}
