package org.william.bank.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	Long employeeId;
	
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "employee_name")
	String employeeName;
	
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "last_name")
	String lastName;
	
	@NotNull
	@Email
	@Column(name = "employee_email")
	String employeeEmail;
	
	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
	public String getName() {
		return employeeName;
	}
	
	public void setName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return employeeEmail;
	}
	
	public void setEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
