package org.o2.registersvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails {
	
	@Id
	@GeneratedValue
	private String sno;
	private String cardNum;
	private String cvv;
	private String expDate;
	private String nameOnCard;
	private long mobNum;
	
}
