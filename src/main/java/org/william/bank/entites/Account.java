package org.william.bank.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long account_id;
	
	@NotNull
	int balance;
	
	@NotNull
	@Max(value = 3)
	@Column(name = "account_rank")
	int rank;
	
	@NotNull
	@Column(name = "account_type")
	String accountType;
	
	@NotNull
	@Column(name = "account_status")
	boolean accountStatus;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
		
	public boolean getAccountStatus() {
		return accountStatus;
	}
	
	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
}
