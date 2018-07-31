package org.o2.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_DETAILS")
public class AccountDetails {

	@Id
	@GeneratedValue
	private String sno;

	@Column(name = "ACC_NUM")
	private String accId;

	@Column(name = "MOB_NUM")
	private String mobNum;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountDetails [sno=");
		builder.append(sno);
		builder.append(", accId=");
		builder.append(accId);
		builder.append(", mobNum=");
		builder.append(mobNum);
		builder.append("]");
		return builder.toString();
	}

}
