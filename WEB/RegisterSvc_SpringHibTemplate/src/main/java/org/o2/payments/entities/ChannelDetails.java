package org.o2.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHANNEL_DETAILS")
public class ChannelDetails {

	@Id
	@GeneratedValue
	private String sno;

	@Column(name = "CHANNEL_ID")
	private String channelId;

	@Column(name = "description")
	private String desc;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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
		builder.append("ChannelDetails [sno=");
		builder.append(sno);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", desc=");
		builder.append(desc);
		builder.append("]");
		return builder.toString();
	}
	
	


}
