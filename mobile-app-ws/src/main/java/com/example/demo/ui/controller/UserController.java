package com.example.demo.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	static Map<String, UserRest> users;

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		if (users.containsKey(userId)) {
			return new ResponseEntity(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest user = new UserRest();
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPassword(userDetails.getPassword());

		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, user);

		return new ResponseEntity(user, HttpStatus.OK);
	}

	
	@PutMapping(path = "/{userId}",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storedUserDetails;
		
		if(users.containsKey(userId)) {
			storedUserDetails = users.get(userId);
			storedUserDetails.setFirstName(userDetails.getFirstName());
			storedUserDetails.setLastName(userDetails.getLastName());
			
			users.put(userId, storedUserDetails);
			return new ResponseEntity(storedUserDetails, HttpStatus.OK);
		}
		else
			return null;
		
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity deleteUser(@PathVariable String userId) {
		
		if(users.containsKey(userId))
		{
			users.remove(userId);
			return new ResponseEntity(HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
