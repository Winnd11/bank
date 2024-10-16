package org.william.bank.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String agency;
	
	public String getAgency() {
		return agency;
	}
	
	public void setAgency(String agency) {
		this.agency = agency;
	}
}
