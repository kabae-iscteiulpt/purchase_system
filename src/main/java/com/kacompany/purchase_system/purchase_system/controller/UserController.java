package com.kacompany.purchase_system.purchase_system.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kacompany.purchase_system.purchase_system.dto.UserDto;
import com.kacompany.purchase_system.purchase_system.service.SystemPurchaseService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	@Autowired
	SystemPurchaseService servicesofPurchase;

	@GetMapping
	public ResponseEntity<?> getAllUsers() {

		final List<UserDto> users = servicesofPurchase.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createNewUser(@RequestBody UserDto userDto) {

		final UserDto userDto2 = servicesofPurchase.createNewUser(userDto);

		return new ResponseEntity<>(userDto2, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {

		final UserDto userDto2 = servicesofPurchase.updateUser(userDto);
		return new ResponseEntity<>(userDto2, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestBody UserDto userDto) {
		
		servicesofPurchase.deleteUser(userDto);
		return new ResponseEntity<>("Done", HttpStatus.OK);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<?> handleError() {

		return new ResponseEntity<>("The Content type must be application/json", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleError1() {

		return new ResponseEntity<>("The user does not exist", HttpStatus.NOT_FOUND);
	}
}