package org.william.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.william.bank.entites.Bank;
import org.william.bank.repositories.BankRepository;

@RestController
@RequestMapping(value = "/bank")
public class BankController {
	
	@Autowired
	BankRepository bankRepository;
	
	@GetMapping(value = "/getbank")
	public List<Bank> getAll() {
		return bankRepository.getAllAgency();
	}
	
	@GetMapping(value = "/byname/{agency}")
	public ResponseEntity<Bank> getByName(@PathVariable String agency) {
		Optional<Bank> result = Optional.ofNullable(bankRepository.getByName(agency));
		
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(bankRepository.getByName(agency));
		}
	}
	
	@GetMapping(value = "/byid/{id}")
	public ResponseEntity<Bank> getById(@PathVariable Long id) {
		Optional<Bank> result = Optional.ofNullable(bankRepository.getBankById(id));
		
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(bankRepository.getBankById(id));
	}
	
	
}
