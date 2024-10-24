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
	StatusEnum status200 = StatusEnum.OK;

	ApiError error = new ApiError();
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.getAllUsers();
	}
	
	public ResponseEntity<Object> getName(String name) {
		Optional<User> r = Optional.ofNullable(userRepository.getUserByName(name));
		
		if (r.isEmpty()) {
			return error.sendError(name + " " + status404.getName());
		} else {
			return ResponseEntity.accepted().body(r.get());
		}
	}
	
	public ResponseEntity<Object> getId(Long id) {
		Optional<User> r = Optional.ofNullable(userRepository.getUserById(id));
		
		if (r.isEmpty()) {
			return error.sendError("Id " + id + " " + status404.getName());
		} else {
			return ResponseEntity.accepted().body(r.get());
			}
		}
	
	public ResponseEntity<Object> insertUser(User user) {
		userRepository.save(user);
		return error.sendError(status200.getName());
	}
	
	//public ResponseEntity<Object> withdrawCurrency(Long id, int balance) {
		//Optional<User> r = Optional.ofNullable(userRepository.withdrawCurrency(id, balance));
		//Integer balanceSearch = userRepository.getBalanceById(id);
		//Integer rank = userRepository.getRank(id);
		
		//if (r.isEmpty()) {
			//return error.sendError("Id " + id + " " + status404.getName());
		//} else {
			//if (Integer.signum(balanceSearch) > 0 && rank > 1) {
				//return ResponseEntity.accepted().body(r.get());
			//} else {
				//userRepository.rankLow(id);
				//return error.sendError(status404.getName());
			//}
		//}
	//}
}
