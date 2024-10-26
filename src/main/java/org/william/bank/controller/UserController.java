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
import org.william.bank.entites.User;
import org.william.bank.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "")
	@ResponseBody
	public ResponseEntity<List<User>> getAll() {
		List<User> result = userService.getAll();
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "{name}")
	@ResponseBody
	public ResponseEntity<Object> getByName(@PathVariable String name) {
		ResponseEntity<Object> result = userService.getName(name);
		
		return result;
	}
	
	@GetMapping(value = "/id/{id}")
	@ResponseBody
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		ResponseEntity<Object> result = userService.getId(id);
		
		return result;
	}
	
	@PostMapping(value = "")	
	@ResponseBody
	public ResponseEntity<Object> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	@DeleteMapping(value = "/id/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PatchMapping(value = "/id/{id}")
	@ResponseBody
	public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	//@PatchMapping(value = "/withdraw")
	//@ResponseBody
	//public void withdrawCurrency(@RequestBody Long id, @RequestBody int balance) {
		//userService.withdrawCurrency(id, balance);
	//}
	 
	//@PostMapping(value = "transfer")
	//@ResponseBody
	//public void transfer(@RequestBody Long id, @RequestBody int balance) {
		//
	//}
}
