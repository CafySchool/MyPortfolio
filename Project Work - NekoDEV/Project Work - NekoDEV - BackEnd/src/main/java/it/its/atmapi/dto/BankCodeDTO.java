package it.its.atmapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BankCodeDTO {
	@NotNull
	@NotBlank
	@Size(min=5, max=5, message= "INVALID_BANKCODE")
	private String bankCodeId;
	private String bankName;
	
	public String getBankCodeId() {
		return bankCodeId;
	}
	public void setBankCodeId(String bankCodeId) {
		this.bankCodeId = bankCodeId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
}
