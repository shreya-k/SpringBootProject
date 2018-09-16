package com.example.emp_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "emp_tab")
//@EntityListeners(AuditingEntityListener.class)

public class emp_data {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;
	
	public long getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }


    private Date dateofbirth;
    public Date getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    private String firstname;
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    private String dept_id;
    public String getDept_id() {
        return dept_id;
    }
    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
}

