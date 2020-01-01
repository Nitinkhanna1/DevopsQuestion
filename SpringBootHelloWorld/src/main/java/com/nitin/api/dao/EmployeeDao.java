package com.nitin.api.dao;

import java.util.List;

import com.vinay.esri.dto.EmployeeDTO;

public interface EmployeeDao {
	void insertEmployee(EmployeeDTO cus);
	void insertEmployees(List<EmployeeDTO> employees);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getEmployeeByName(String empName);
	void insertUpdateEmployee(EmployeeDTO emp);
}
