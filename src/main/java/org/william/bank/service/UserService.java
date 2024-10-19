package org.william.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.william.bank.entites.User;
import org.william.bank.enums.StatusEnum;
import org.william.bank.handler.ApiError;
import org.william.bank.repositories.UserRepository;

@Service
public class UserService {
	StatusEnum status404 = StatusEnum.NOTFOUND;

	ApiError error = new ApiError();
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.getAllUsers();
	}
	
	public ResponseEntity<Object> getName(String names) {
		Optional<User> r = Optional.ofNullable(userRepository.getUserByName(names));
		
		if (r.isEmpty()) {
			return error.sendError(names + " " + status404.getName());
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
	
	public void insertUser(User user) {
		userRepository.save(user);
	}
	
	public ResponseEntity<User> withdrawCurrency(int balance, Long id) {
		Optional<User> r = Optional.ofNullable(userRepository.withdrawCurrency(balance, id));
		int balanceSearch = userRepository.getBalanceById(id);
		
		if (r.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			if (Integer.signum(balanceSearch) > 0) {
				return ResponseEntity.accepted().body(r.get());
			} else {
				userRepository.rankLow(id);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		}
	}
}
