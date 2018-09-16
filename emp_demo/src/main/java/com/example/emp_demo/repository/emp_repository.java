package com.example.emp_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.emp_demo.model.emp_data;
import org.springframework.stereotype.Repository;

	
	@Repository
	public interface emp_repository extends JpaRepository<emp_data, Long> {

	}

