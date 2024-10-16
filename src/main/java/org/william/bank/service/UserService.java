package org.william.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.william.bank.entites.User;
import org.william.bank.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.getAllUsers();
	}
	
	public ResponseEntity<User> getName(String names) {
		Optional<User> r = Optional.ofNullable(userRepository.getUserByName(names));
		
		if (r.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.accepted().body(r.get());
		}
	}
	
	public ResponseEntity<User> getId(Long id) {
		Optional<User> r = Optional.ofNullable(userRepository.getUserById(id));
		
		if (r.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.accepted().body(r.get());
			}
		}
}
