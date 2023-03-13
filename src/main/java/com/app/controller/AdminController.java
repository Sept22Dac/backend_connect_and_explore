package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserService;

@RestController
@RequestMapping("/user")

public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
	}

}
