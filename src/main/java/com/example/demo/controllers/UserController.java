package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/hello")
	public String greeting() {
		return "Hello World";
	}

	@GetMapping("/all")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@PostMapping("/save")
	public User save(@RequestBody User e) {
		return userRepository.save(e);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public User update(@PathVariable int id, @RequestBody User newUser) {
		newUser.setId(id);
		return userRepository.save(newUser);
	}

	@GetMapping("/ById/{id}")
	public User getUser(@PathVariable int id) {
		return userRepository.findById(id).orElse(null);
	}

//	@GetMapping("/ById/{id}")
//	public List<User> findByNomUser(@PathVariable("id") int id) {
//		return userRepository.findById(id).orElse(null);
//	}

}
