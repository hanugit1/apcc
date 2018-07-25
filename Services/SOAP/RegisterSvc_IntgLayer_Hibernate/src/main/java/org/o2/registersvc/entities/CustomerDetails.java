package org.o2.registersvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {

	@Id
	@GeneratedValue
	private String sno;

	@Column(name = "CARD_NUM")
	private String cardNum;

	@Column(name = "CVV")
	private String cvv;

	@Column(name = "EXP_DATE")
	private String expDate;

	@Column(name = "NAME_ON_CARD")
	private String nameOnCard;

	@Column(name = "MOB_NUM")
	private long mobNum;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public long getMobNum() {
		return mobNum;
	}

	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetails [sno=");
		builder.append(sno);
		builder.append(", cardNum=");
		builder.append(cardNum);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", mobNum=");
		builder.append(mobNum);
		builder.append("]");
		return builder.toString();
	}

}
