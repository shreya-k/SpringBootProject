package com.example.emp_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.emp_demo.model.emp_data;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

	@Repository
	public interface emp_repository extends JpaRepository<emp_data, Long> {
	//  //@Query("SELECT e FROM employee e WHERE LOWER(e.dept_id) = LOWER(:dept_id)")
		  //  public List<emp_data> find(@Param("dept_id") String dept_id);
	//List<emp_data> findBydept_id(String deptid);	
	}

