package org.william.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.william.bank.entites.Employee;
import org.william.bank.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value =  "")
	@ResponseBody
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> r = employeeService.getAll();
		
		return ResponseEntity.ok(r);
	}
	
	@GetMapping(value = "{name}")
	@ResponseBody
	public ResponseEntity<Object> getByName(@PathVariable String name) {
		return employeeService.getName(name);
	}
	
	@GetMapping(value = "id/{id}")
	@ResponseBody
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		return employeeService.getId(id);
	}
	
	@PostMapping(value = "")
	@ResponseBody
	public ResponseEntity<Object> insertUser(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	
	@DeleteMapping(value = "id/{id}")
	@ResponseBody
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
	
	@PatchMapping(value = "id/{id}")
	@ResponseBody
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
}