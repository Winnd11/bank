package org.william.bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.william.bank.entites.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	@Query(value = "SELECT * FROM tb_bank", nativeQuery = true)
	List<Bank> getAllAgency();
	
	@Query(value = "SELECT * FROM tb_bank WHERE agency = :agency", nativeQuery = true)
	Bank getByName(@Param("agency") String agency);
	
	@Query(value = "SELECT * FROM tb_bank WHERE id = :id", nativeQuery = true)
	Bank getBankById(@Param("id") Long id);
	
}
