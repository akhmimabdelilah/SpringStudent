package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Filiere;
import com.example.demo.repositories.FiliereRepository;

@RestController
@RequestMapping("/filiers")
public class FiliereController {
private FiliereRepository filiereRepository;
	
	
	@PostMapping("/save")
	public Filiere save(@RequestBody Filiere e) {
		return filiereRepository.save(e);
	}
	
	@GetMapping("/all")
	public List<Filiere> findAll(){	
		return filiereRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		 filiereRepository.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Filiere update(@PathVariable int id, @RequestBody Filiere newFiliere) {
		 newFiliere.setId(id); 
		 return filiereRepository.save(newFiliere);
	}
}
