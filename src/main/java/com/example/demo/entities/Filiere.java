package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;

	@OneToMany
	private List<Student> students = new ArrayList<>();

	public Filiere() {
		super();
	}

	public Filiere(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Filiere(int id, String code, String name, List<com.example.demo.entities.Student> students) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
