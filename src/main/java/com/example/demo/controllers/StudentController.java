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

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository StudentRepository;

	@PostMapping("/save")
	public Student save(@RequestBody Student e) {
		return StudentRepository.save(e);
	}

	@GetMapping("/all")
	public List<Student> findAll() {
		return StudentRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		StudentRepository.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public Student update(@PathVariable int id, @RequestBody Student newStudent) {
		newStudent.setId(id);
		return StudentRepository.save(newStudent);
	}
}
