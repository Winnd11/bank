package org.william.bank.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_bank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	@Size(min = 1, max = 20)
	String agency;
	
	public String getAgency() {
		return agency;
	}
	
	public void setAgency(String agency) {
		this.agency = agency;
	}
}
