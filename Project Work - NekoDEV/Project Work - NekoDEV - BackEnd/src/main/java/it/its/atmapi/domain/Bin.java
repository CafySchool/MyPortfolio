package it.its.atmapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bin {

	@Id
	private String maskedPan;
	
	@OneToMany(mappedBy = "bin")
	private List<FunctionalityBin> functionalityBins;
	
	
	public String getMaskedPan() {
		return maskedPan;
	}
	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}
	public List<FunctionalityBin> getFunctionalityBins() {
		return functionalityBins;
	}
	public void setFunctionalityBins(List<FunctionalityBin> functionalityBins) {
		this.functionalityBins = functionalityBins;
	}
	
	

}
