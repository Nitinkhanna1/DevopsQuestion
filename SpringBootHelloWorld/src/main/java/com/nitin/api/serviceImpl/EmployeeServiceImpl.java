/**
 * 
 */
package com.nitin.api.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.api.dao.EmployeeDao;
import com.nitin.api.dto.EmployeeDTO;
import com.nitin.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(EmployeeDTO employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<EmployeeDTO> employees) {
		employeeDao.insertEmployees(employees);
	}

	public void getAllEmployees() {
		List<EmployeeDTO> employees = employeeDao.getAllEmployees();
		for (EmployeeDTO employee : employees) {
			System.out.println(employee.toString());
		}
	}
	
	public ArrayList<EmployeeDTO> getAllEmployeesList(){
		return (ArrayList<EmployeeDTO>)employeeDao.getAllEmployees();
	}

	
	@Override
	public EmployeeDTO getEmpDOB(String name) {
		EmployeeDTO dto = employeeDao.getEmployeeByName(name);
		return dto;
	}
	
	@Override
	public void insertUpdateEmployee(String name, Date dob) {
		EmployeeDTO employee = new EmployeeDTO();
		employee.setDateOfBirth(dob);
		employee.setEmpName(name);
		employeeDao.insertUpdateEmployee(employee);
	}
}
