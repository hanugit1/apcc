package org.o2.registersvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT_DETAILS")
public class ClientDetails {
	
	@Id
	@GeneratedValue
	private String sno;
	
	@Column(name="CLIENT_ID")
	private String clientId;
	
	@Column(name="DESCRIPTION")
	private String desc;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientDetails [sno=");
		builder.append(sno);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", desc=");
		builder.append(desc);
		builder.append("]");
		return builder.toString();
	}
	
	
}
