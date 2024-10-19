package org.william.bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.william.bank.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT * FROM tb_users", nativeQuery = true)
	List<User> getAllUsers();
	
	@Query(value = "SELECT * FROM tb_users WHERE name = :names", nativeQuery = true)
	User getUserByName(@Param("names") String names);
	
	@Query(value = "SELECT * FROM tb_users WHERE id = :id", nativeQuery = true)
	User getUserById(@Param("id") Long id);
	
	// VERIFY IF BALANCE ACCOUNT IS NEGATIVE
	@Query(value = "SELECT balance FROM tb_users WHERE id = :id", nativeQuery = true)
	int getBalanceById(@Param("id") Long id);
	
	// WITHDRAW AND TRANSFER
	@Query(value = "UPDATE tb_users SET balance = balance - :balance WHERE id = :id", nativeQuery = true)
	User withdrawCurrency(@Param("balance") int balance, @Param("id") Long id);
	
	@Query(value = "UPDATE tb_users SET rank = 1 WHERE id = :id", nativeQuery = true)
	User rankLow(@Param("id") Long id);
}
