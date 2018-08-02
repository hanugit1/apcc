package org.register.beans;

public class O2LoginReq {
	private String accId;
	private String mobNum;
	private String password;
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O2LoginReq [accId=");
		builder.append(accId);
		builder.append(", mobNum=");
		builder.append(mobNum);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	
}
