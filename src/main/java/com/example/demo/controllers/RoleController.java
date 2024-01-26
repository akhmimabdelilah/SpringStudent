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

import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;

	@PostMapping("/save")
	public Role save(@RequestBody Role e) {
		return roleRepository.save(e);
	}

	@GetMapping("/all")
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		roleRepository.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public Role update(@PathVariable int id, @RequestBody Role newRole) {
		newRole.setId(id);
		return roleRepository.save(newRole);
	}
}
