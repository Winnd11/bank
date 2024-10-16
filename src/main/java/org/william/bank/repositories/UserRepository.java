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
}
