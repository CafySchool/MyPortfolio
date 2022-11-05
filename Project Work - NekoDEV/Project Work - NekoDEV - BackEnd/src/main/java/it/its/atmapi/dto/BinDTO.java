package it.its.atmapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BinDTO {
	@NotNull
	@NotBlank
	@Size(min=16, max=16, message= "{INVALID_MASKEDPAN}")
	private String maskedPan;
	
	
	public String getMaskedPan() {
		return maskedPan;
	}
	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}
}
