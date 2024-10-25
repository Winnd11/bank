package org.william.bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.william.bank.entites.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT * FROM tb_users", nativeQuery = true)
	List<User> getAllUsers();
	
	@Query(value = "SELECT * FROM tb_users WHERE user_name = :name", nativeQuery = true)
	User getUserByName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM tb_users WHERE user_id = :id", nativeQuery = true)
	User getUserById(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tb_account WHERE user_id = :id; DELETE FROM tb_users WHERE user_id = :id ", nativeQuery = true)
	void deleteUserById(@Param("id") Long id);
	
	// VERIFY IF BALANCE ACCOUNT IS NEGATIVE
	//@Query(value = "SELECT balance FROM tb_users WHERE user_id = :id", nativeQuery = true)
	//Integer getBalanceById(@Param("id") Long id);
	
	// WITHDRAW AND TRANSFER
	//@Query(value = "UPDATE tb_users SET balance = balance - :balance WHERE id = :id", nativeQuery = true)
	//User withdrawCurrency(@Param("id") Long id, @Param("balance") int balance);
	
	//@Query(value = "UPDATE tb_users SET rank = 1 WHERE id = :id", nativeQuery = true)
	//User rankLow(@Param("id") Long id);
	
	//@Query(value = "SELECT rank FROM tb_users WHERE id = :id", nativeQuery = true)
	//Integer getRank(@Param("id") Long id);
}
