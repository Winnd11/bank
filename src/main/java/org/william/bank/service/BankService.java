package org.william.bank.service;

import org.springframework.stereotype.Service;
import org.william.bank.entites.Bank;
import org.william.bank.repositories.BankRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;
	
	public List<Bank> getAll() {
		return bankRepository.getAllAgency();
	}
	
	public ResponseEntity<Bank> getName(String name) {
		Optional<Bank> r = Optional.ofNullable(bankRepository.getByName(name));
		
		if (r.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.accepted().body(r.get());
		}
	}
	
	public ResponseEntity<Bank> getId(Long id) {
		Optional<Bank> r = Optional.ofNullable(bankRepository.getById(id));
		
		if (r.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.accepted().body(r.get());
		}
	}
	
	public void insertBank(Bank bank) {
		bankRepository.save(bank);
	}
}
