package it.its.atmapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Functionality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String description;
	private boolean enabled;
	private TypeFunc typeFunc;
	private boolean multisession;
	
	@OneToMany(mappedBy = "functionality")
	private List<Parameter> parameters;
	
	
	@OneToMany(mappedBy = "functionality")
	private List<FunctionalityPeripheral> functionalityPeripherals;

	@OneToMany(mappedBy = "functionality")
	private List<FunctionalityBankCode> functionalityBankCodes;
	
	@OneToMany(mappedBy = "functionality")
	private List<FunctionalityBin> functionalityBins;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public TypeFunc getTypeFunc() {
		return typeFunc;
	}

	public void setTypeFunc(TypeFunc typeFunc) {
		this.typeFunc = typeFunc;
	}

	public boolean isMultisession() {
		return multisession;
	}

	public void setMultisession(boolean multisession) {
		this.multisession = multisession;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public List<FunctionalityPeripheral> getFunctionalityPeripherals() {
		return functionalityPeripherals;
	}

	public void setFunctionalityPeripherals(List<FunctionalityPeripheral> functionalityPeripherals) {
		this.functionalityPeripherals = functionalityPeripherals;
	}

	public List<FunctionalityBankCode> getFunctionalityBankCodes() {
		return functionalityBankCodes;
	}

	public void setFunctionalityBankCodes(List<FunctionalityBankCode> functionalityBankCodes) {
		this.functionalityBankCodes = functionalityBankCodes;
	}

	public List<FunctionalityBin> getFunctionalityBins() {
		return functionalityBins;
	}

	public void setFunctionalityBins(List<FunctionalityBin> functionalityBins) {
		this.functionalityBins = functionalityBins;
	}
	

	
}
