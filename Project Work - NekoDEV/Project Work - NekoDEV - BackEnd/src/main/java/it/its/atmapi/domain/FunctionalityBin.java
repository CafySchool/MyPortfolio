package it.its.atmapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FunctionalityBin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Functionality functionality;
	@ManyToOne
	private Bin bin;
	
	
	
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
	public Bin getBin() {
		return bin;
	}
	public void setBin(Bin bin) {
		this.bin = bin;
	}
	
	
	

}
