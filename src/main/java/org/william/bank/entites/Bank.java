package org.william.bank.entites;

import jakarta.persistence.Column;
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
	@Column(name = "bank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long bankId;
	
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "bank_name")
	String bankName;
	
	public String getAgency() {
		return bankName;
	}
	
	public void setAgency(String bankName) {
		this.bankName = bankName;
	}
}
