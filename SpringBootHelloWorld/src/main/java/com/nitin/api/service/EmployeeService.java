package com.nitin.api.service;

import java.sql.Date;
import java.util.List;

import com.vinay.esri.dto.EmployeeDTO;


public interface EmployeeService {
	void insertEmployee(EmployeeDTO emp);
	void insertEmployees(List<EmployeeDTO> employees);
	void getAllEmployees();
    EmployeeDTO getEmpDOB(String name);
	void insertUpdateEmployee(String name, Date dob);
}
