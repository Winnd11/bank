package org.william.bank.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	@Size(min = 1, max = 20)
	String name;
	
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "last_name")
	String lastName;
	
	@NotNull
	@Email
	String email;

}
