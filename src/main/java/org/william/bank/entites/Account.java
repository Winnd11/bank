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
	Long accountId;
	
	@NotNull
	@Column(name = "account_balance")
	int accountBalance;
	
	@NotNull
	@Max(value = 3)
	@Column(name = "account_rank")
	int accountRank;
	
	@NotNull
	@Column(name = "account_type")
	String accountType;
	
	@NotNull
	@Column(name = "account_status")
	boolean accountStatus;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
	public int getBalance() {
		return accountBalance;
	}
	
	public void setBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public int getRank() {
		return accountRank;
	}
	
	public void setRank(int accountRank) {
		this.accountRank = accountRank;
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
	
	public User getUser() {
		return userId;
	}
	
	public void setUser(User userId) {
		this.userId = userId;
	}
}
