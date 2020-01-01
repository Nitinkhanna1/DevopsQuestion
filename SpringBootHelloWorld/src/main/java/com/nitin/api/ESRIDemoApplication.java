package com.nitin.api;

//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//import com.nitin.api.dto.EmployeeDTO;
import com.nitin.api.service.EmployeeService;

@SpringBootApplication
public class apiDemoApplication {

	@Autowired
	EmployeeService employeeService;
	
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(apiDemoApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		
//		EmployeeDTO emp= new EmployeeDTO();
//		emp.setEmpName("emp1");
//		emp.setDateOfBirth(new Date(883239195000L));
//		
//		EmployeeDTO emp1= new EmployeeDTO();
//		emp1.setEmpName("emp2");
//		emp1.setDateOfBirth(new Date(883152795000L));
//		
//		EmployeeDTO emp2= new EmployeeDTO();
//		emp2.setEmpName("emp3");
//		emp2.setDateOfBirth(new Date(883066395000L));
//
//		
//		employeeService.insertEmployee(emp);
//
//		List<EmployeeDTO> employees = new ArrayList<>();
//		employees.add(emp1);
//		employees.add(emp2);
//		employeeService.insertEmployees(employees);

		employeeService.getAllEmployees();
		

	}
}
