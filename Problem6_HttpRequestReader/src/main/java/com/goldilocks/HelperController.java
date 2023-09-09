package com.goldilocks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController // @Controller + @ResponseBody
public class HelperController {
	
	@Autowired
	private EmployeeDao empDao;
	
	
	//http://localhost:8088/employees
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeesHandler(){
		
		   List<Employee> employess = empDao.getAllEmployees();
		
		return new ResponseEntity<>(employess, HttpStatus.OK);
	}
	
	
	//http://localhost:8088/employee?name=singh
	@RequestMapping(value ="/employee", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeHandler(@RequestParam String name){
		Employee employee = empDao.getEmployeeByName(name);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
}