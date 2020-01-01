/**
 * 
 */
package com.nitin.api.dto;


import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * @author Vinay
 *
 */
@Component
public class EmployeeDTO {
	private String empName;
	private Date dateOfBirth;
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
