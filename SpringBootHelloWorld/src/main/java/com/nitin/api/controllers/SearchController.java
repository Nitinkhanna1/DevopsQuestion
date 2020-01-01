/**
 * 
 */
package com.nitin.api.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.api.dto.EmployeeDTO;
import com.nitin.api.serviceImpl.EmployeeServiceImpl;

/**
 * @author nitin
 *
 */

@RestController
public class SearchController {

	@Autowired
	EmployeeServiceImpl service;

	@GetMapping("/searchData")
	public ResponseEntity<ArrayList<EmployeeDTO>> getEmployeesList() {
		return new ResponseEntity<ArrayList<EmployeeDTO>>(getEmpList(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{username}", produces = {"application/JSON"})
	public ResponseEntity<HttpStatus> saveUpdateUser(@PathVariable("username") String empName) {
		Calendar cal = Calendar.getInstance();
		cal.set(1998, Calendar.JANUARY, 11);
		Date date = new Date(cal.getTime().getTime());
		service.insertUpdateEmployee(empName, date);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hello/{username}")
	public ResponseEntity<String> getUserDOB(@PathVariable("username") String name) {
		StringBuilder message = new StringBuilder("Hello, ").append(name).append("! Your birthday is in ");
		Date dob = service.getEmpDOB(name).getDateOfBirth();
		System.out.print(dob);
		long days = (Math.abs(dob.getTime() - System.currentTimeMillis())/(86400000))%365;
		message.append(days).append(" days.");
		return new ResponseEntity<String>(message.toString(), HttpStatus.OK);
	}
	
	private ArrayList<EmployeeDTO> getEmpList() {
		ArrayList<EmployeeDTO> empList = service.getAllEmployeesList();
		return empList;
	}

}
