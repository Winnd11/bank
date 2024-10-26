package org.william.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.william.bank.entites.Employee;
import org.william.bank.enums.StatusEnum;
import org.william.bank.handler.ApiError;
import org.william.bank.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	StatusEnum status404 = StatusEnum.NOTFOUND;
	StatusEnum status200 = StatusEnum.OK;
	
	ApiError error = new ApiError();
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAll() {
		return employeeRepository.getAllEmployee();
	}
	
	public ResponseEntity<Object> getName(String name) {
		Optional<Employee> r = Optional.ofNullable(employeeRepository.getEmployeeByName(name));
		
		if (r.isEmpty()) {
			return error.sendError(name + " " + status404.getName());
		} 
		return ResponseEntity.accepted().body(r.get());
	}
	
	public ResponseEntity<Object> getId(Long id) {
		Optional<Employee> r = Optional.ofNullable(employeeRepository.getEmployeeById(id));
		
		if (r.isEmpty()) {
			return error.sendError(id + " " + status404.getName());
		}
		return ResponseEntity.accepted().body(r.get());
	}
	
	public ResponseEntity<Object> insertEmployee(Employee employee) {
		employeeRepository.save(employee);
		return error.sendError(status200.getName());
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteEmployeeById(id);
	}
	
	public ResponseEntity<Object> updateEmployee(Long id, Employee employee) {
		Optional<Employee> r = Optional.ofNullable(employeeRepository.getEmployeeById(id));
		
		if (r.isEmpty()) {
			return error.sendError(id + " " + status404.getName());
		}
		Employee employeeUpdate = r.get();
		
		employeeUpdate.setName(employee.getName());
		employeeUpdate.setLastName(employee.getLastName());
		employeeUpdate.setEmail(employee.getEmail());
		//employeeUpdate.setBank(employee.getBank());
		
		return ResponseEntity.accepted().body(employeeRepository.save(employeeUpdate));
	}
}


