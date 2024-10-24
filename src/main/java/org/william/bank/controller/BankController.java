package org.william.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.william.bank.entites.Bank;
import org.william.bank.repositories.BankRepository;
import org.william.bank.service.BankService;

@RestController
@RequestMapping(value = "/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@GetMapping(value = "/getbank")
	@ResponseBody
	public ResponseEntity<List<Bank>> getAll() {
		List<Bank> r = bankService.getAll();
		
		return ResponseEntity.ok(r);
	}
	
	@GetMapping(value = "/byname/{agency}")
	@ResponseBody
	public ResponseEntity<Bank> getByName(@PathVariable String agency) {
		ResponseEntity<Bank> result = bankService.getName(agency);
		
		return result;
		
	}
	
	@GetMapping(value = "/byid/{id}")
	@ResponseBody
	public ResponseEntity<Bank> getById(@PathVariable Long id) {
		ResponseEntity<Bank> result = bankService.getId(id);
		
		return result;	
	}
	
	@PostMapping(value = "/insert")
	public void insert(@RequestBody Bank bank) {
		bankService.insertBank(bank);
	}
	
	
}
