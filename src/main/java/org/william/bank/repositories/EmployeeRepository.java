package org.william.bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.william.bank.entites.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "SELECT * FROM tb_employee", nativeQuery = true)
	List<Employee> getAllEmployee();
	
	@Query(value = "SELECT * FROM tb_employee WHERE employee_name = :name", nativeQuery = true)
	Employee getEmployeeByName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM tb_employee WHERE employee_id = :id", nativeQuery = true)
	Employee getEmployeeById(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tb_employee WHERE employee_id = :id", nativeQuery = true)
	void deleteEmployeeById(@Param("id") Long id);
}
