package com.goldilocks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	 private final DataSource dataSource;
	 
	 @Autowired
	 public EmployeeDaoImpl(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	
	@Override
	public List<Employee> getAllEmployees() {

		 List<Employee> emps = new ArrayList<>();

	        try{
	        	
	        	 Connection connection = dataSource.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
	             ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Employee emp = new Employee();
	                emp.setEmpId(resultSet.getInt(1));
	                emp.setEmpName(resultSet.getString(2));
	                emp.setEmpAge(resultSet.getInt(3));
	                emps.add(emp);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return emps;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		try{
        	
       	 Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee where empName = ?");
          
            
            preparedStatement.setString(1, name);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            Employee emp = new Employee();
            
           while (resultSet.next()) {
               emp.setEmpId(resultSet.getInt(1));
               emp.setEmpName(resultSet.getString(2));
               emp.setEmpAge(resultSet.getInt(3));
           }
           
           return emp;
           
       } catch (SQLException e) {
           e.printStackTrace();
       }
		
		return null;
	}

}
