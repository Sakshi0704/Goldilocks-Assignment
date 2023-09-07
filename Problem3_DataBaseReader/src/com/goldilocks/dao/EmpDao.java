package com.goldilocks.dao;

import java.util.List;

import com.goldilocks.dto.Employee;
import com.goldilocks.exception.EmployeeException;

public interface EmpDao {

	public String registerEmployee(Employee employee);
	
	public Employee getEmployeeById(int empId)throws EmployeeException;
	
	public List<Employee> getAllEmployee();
	
}
