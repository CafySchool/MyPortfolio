package it.its.atmapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Peripheral {
	@Id
	private String idPeripheral;
	private String name;
	
	@OneToMany(mappedBy = "peripheral")
	private List<FunctionalityPeripheral> functionalityPeripherals;
	
	
	

	public String getIdPeripheral() {
		return idPeripheral;
	}
	public void setIdPeripheral(String idPeripheral) {
		this.idPeripheral = idPeripheral;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FunctionalityPeripheral> getFunctionalityPeripherals() {
		return functionalityPeripherals;
	}
	public void setFunctionalityPeripherals(List<FunctionalityPeripheral> functionalityPeripherals) {
		this.functionalityPeripherals = functionalityPeripherals;
	}

	
}
