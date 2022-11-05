package it.its.atmapi.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import it.its.atmapi.domain.TypeFunc;

public class TransactionDTO {
	private int id;
	@NonNull
	@NotBlank
	private String name;

	private String description;
	@NonNull
	@NotBlank
	private boolean enabled;
	@NonNull
	@NotBlank
	private TypeFunc typeFunc;
	@NonNull
	@NotBlank
	private boolean multisession;
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
	
}
