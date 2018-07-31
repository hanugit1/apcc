package org.o2.registersvc.springclient.beans;

public class RegisterSvcWebRes {
	private String respCode;
	private String respMsg;
	private String status;
	private float score;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterSvcProcessVBRes [respCode=");
		builder.append(respCode);
		builder.append(", respMsg=");
		builder.append(respMsg);
		builder.append(", status=");
		builder.append(status);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}
	
}
