
package com.fernbird.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernbird.entity.Employer;
import com.fernbird.repo.Employerrepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
public class Employercontroller {

	@Autowired
	Employerrepo emprepo;
	

	@GetMapping("/all")
	public ResponseEntity<Iterable<Employer>> getAllEmployer() {
		return ResponseEntity.ok(emprepo.findAll());
	}

	@GetMapping("/{id}")
	public List<Employer> getEmployerById(@PathVariable("id") int id ) {
		return  emprepo.findById(id);
	}
	
	@GetMapping("/page")
	public List<Employer> getEmployer(Pageable pageable ) {
		return  (List<Employer>) emprepo.findAll(pageable);
	}
	@PostMapping("/insert")
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
		return ResponseEntity.ok(emprepo.save(employer));
	}
	@PutMapping
	public ResponseEntity<Employer> updateEmployer(@RequestBody Employer employer) {
		return ResponseEntity.ok(emprepo.save(employer));
	}

	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<Object>
	 * deleteEmployer(@PathVariable int id) { emprepo.delete(id); return
	 * ResponseEntity.ok().build(); }
	 */
}
