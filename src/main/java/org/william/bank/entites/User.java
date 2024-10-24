package org.william.bank.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "tb_users")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long userId;
	
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "user_name")
	String userName;
	
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "last_name")
	String lastName;
	
	@NotNull
	@Email
	@Column(name = "user_email")
	String userEmail;
	
	public String getName() {
		return userName;
	}
	
	public void setName(String userName) {
		this.userName = userName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return userEmail;
	}
	
	public void setEmail(String userEmail) {
		this.userEmail = userEmail;
	}	
}
