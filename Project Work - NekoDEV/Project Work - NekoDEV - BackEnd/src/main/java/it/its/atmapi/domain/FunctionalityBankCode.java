package it.its.atmapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FunctionalityBankCode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Functionality functionality;
	@ManyToOne
	private BankCode bankcode;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Functionality getFunctionality() {
		return functionality;
	}
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}
	public BankCode getBankcode() {
		return bankcode;
	}
	public void setBankcode(BankCode bankcode) {
		this.bankcode = bankcode;
	}
	
	

}
