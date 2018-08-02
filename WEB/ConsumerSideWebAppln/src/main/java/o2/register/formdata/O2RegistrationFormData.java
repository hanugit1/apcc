package o2.register.formdata;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;

public class O2RegistrationFormData {

	@NotNull(message = "mobNum should not blank")
	@NotEmpty(message = "mobNum should not blank")
	@NumberFormat(pattern = "mobNum should be number")
	@Size(min = 10, max = 10, message = "mobNum should be 10 digits")
	private long mobNum;

	@NotNull(message = "cardNum should not blank")
	@NotEmpty(message = "cardNum should not blank")
	@CreditCardNumber(message = "cardNum should be 16 digits")
	@Size(min = 16, max = 16, message = "cardNum should be 16 digits")
	private String cardNum;

	@NotNull(message = "cvv should not blank")
	@NotEmpty(message = "cvv should not blank")
	@NumberFormat(pattern = "cvv should be number")
	@Size(min = 3, max = 3, message = "cvv should be 3 digits")
	private String cvv;

	@NotNull(message = "expDate should not blank")
	@NotEmpty(message = "expDate should not blank")
	@DateTimeFormat(iso = ISO.NONE)
	private String expDate;

	@NotNull(message = "nameOnCard should not blank")
	@NotEmpty(message = "nameOnCard should not blank")
	private String nameOnCard;

	public long getMobNum() {
		return mobNum;
	}

	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O2RegistrationFormData [mobNum=");
		builder.append(mobNum);
		builder.append(", cardNum=");
		builder.append(cardNum);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append("]");
		return builder.toString();
	}

}
