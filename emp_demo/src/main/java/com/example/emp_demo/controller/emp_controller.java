package com.example.emp_demo.controller;

import com.example.emp_demo.exception.ResourceNotFoundException;
import com.example.emp_demo.model.emp_data;
import com.example.emp_demo.repository.emp_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class emp_controller {

	 @Autowired
	    emp_repository emp_rep;

	    // Get All Notes
	 @GetMapping("/employees")
	 public List<emp_data> getAllEmp_datas() {
	     return emp_rep.findAll();
	 }
	    // Create a new Note
	 @PostMapping("/employees")

	 public emp_data createEmp_data(@Valid @RequestBody emp_data empd) {
		    return emp_rep.save(empd);
		}
	    // Get a Single Note
	 
	 @GetMapping("/employees/{emp_id}")
	 public emp_data getEmpById(@PathVariable(value = "emp_id") long empId) {
	     return emp_rep.findById(empId)
	             .orElseThrow(() -> new ResourceNotFoundException("emp_data", "emp_id", empId));
	 }

	    // Update a Note
	 
	 @PutMapping("/employees/{emp_id}")
	 public emp_data updateEmp_data(@PathVariable(value = "emp_id") long empId,
	                                         @Valid @RequestBody emp_data empDetails) {

		 emp_data empp = emp_rep.findById(empId)
	             .orElseThrow(() -> new ResourceNotFoundException("emp_data", "emp_id",empId));

	     empp.setFirstname(empDetails.getFirstname());

	     emp_data updatedEmp = emp_rep.save(empp);
	     return updatedEmp;
	 }

	}

