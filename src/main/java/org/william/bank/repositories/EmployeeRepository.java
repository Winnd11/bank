package org.william.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.william.bank.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
