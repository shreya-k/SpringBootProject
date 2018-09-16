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

	    // fetch all employees
	 @GetMapping("/employees")
	 public List<emp_data> getAllEmp_datas() {
	     return emp_rep.findAll();
	 }
	    // insert new employee
	 @PostMapping("/employees")

	 public emp_data createEmp_data(@Valid @RequestBody emp_data empd) {
		    return emp_rep.save(empd);
		    
		   
		}
	 
	 /*@PostMapping("/employees/search")
	    public List<EmpDetails> search(@PathVariable(value = "deptId") String did){
	        return emp_rep.findBydeptid(did);
	    }*/

	    // Get a Single row
	 
	 @GetMapping("/employees/{emp_id}")
	 public emp_data getEmpById(@PathVariable(value = "emp_id") long empId) {
	     return emp_rep.findById(empId)
	             .orElseThrow(() -> new ResourceNotFoundException("emp_data", "emp_id", empId));
	 }

	    // Update a row
	 
	 @PutMapping("/employees/{emp_id}")
	 public emp_data updateEmp_data(@PathVariable(value = "emp_id") long empId,
	                                         @Valid @RequestBody emp_data empDetails) {

		 emp_data empp = emp_rep.findById(empId)
	             .orElseThrow(() -> new ResourceNotFoundException("emp_data", "emp_id",empId));

	     empp.setFirstname(empDetails.getFirstname());
	     empp.setDateofbirth(empDetails.getDateofbirth());
	     empp.setDept_id(empDetails.getDept_id());

	     emp_data updatedEmp = emp_rep.save(empp);
	     return updatedEmp;
	 }

	}

