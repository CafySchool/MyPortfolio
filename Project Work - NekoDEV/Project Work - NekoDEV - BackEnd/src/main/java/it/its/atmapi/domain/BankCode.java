package it.its.atmapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class BankCode {
	@Id
	private String bankCodeId;
	private String bankName;
	
	@OneToMany(mappedBy = "bankcode")
	private List<FunctionalityBankCode> functionalityBankCodes;
	
	
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
	public List<FunctionalityBankCode> getFunctionalityBankCodes() {
		return functionalityBankCodes;
	}
	public void setFunctionalityBankCodes(List<FunctionalityBankCode> functionalityBankCodes) {
		this.functionalityBankCodes = functionalityBankCodes;
	}
	

	
}
