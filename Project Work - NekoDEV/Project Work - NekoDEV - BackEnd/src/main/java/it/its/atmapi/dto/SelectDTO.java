package it.its.atmapi.dto;

import java.util.List;

public class SelectDTO {
	private String bankCodeId;
	private String maskedPan;
	List<String> idPeripheral;
	public String getBankCodeId() {
		return bankCodeId;
	}
	public void setBankCodeId(String bankCodeId) {
		this.bankCodeId = bankCodeId;
	}
	public String getMaskedPan() {
		return maskedPan;
	}
	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}
	public List<String> getIdPeripheral() {
		return idPeripheral;
	}
	public void setIdPeripheral(List<String> idPeripheral) {
		this.idPeripheral = idPeripheral;
	}



}
