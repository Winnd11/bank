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
import org.william.bank.entites.User;
import org.william.bank.repositories.*;
import org.william.bank.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/getusers")
	@ResponseBody
	public ResponseEntity<List<User>> getAll() {
		List<User> user = userService.getAll();
		
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping(value = "/byname/{names}")
	@ResponseBody
	public ResponseEntity<User> getByName(@PathVariable String names) {
		ResponseEntity<User> result = userService.getName(names);
		
		return result;
	}
	
	@GetMapping(value = "/byid/{id}")
	@ResponseBody
	public ResponseEntity<User> getById(@PathVariable Long id) {
		ResponseEntity<User> result = userService.getId(id);
		
		return result;
	}
	
	@PostMapping(value = "/insert")
	public void insertUser(@RequestBody User user) {
		
	}
}
