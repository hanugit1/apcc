package o2.register.formdata;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class O2LoginFormData {

	@NotNull(message = "accNum should not blank")
	@NotEmpty(message = "accNum should not blank")
	private String accNum;

	@NotNull(message = "mobNum should not blank")
	@NotEmpty(message = "accNum should not blank")
	private String mobNum;

	@NotNull(message = "password should not blank")
	@NotEmpty(message = "password should not blank")
	private String pass;

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O2LoginFormData [accNum=");
		builder.append(accNum);
		builder.append(", mobNum=");
		builder.append(mobNum);
		builder.append(", pass=");
		builder.append(pass);
		builder.append("]");
		return builder.toString();
	}

}
