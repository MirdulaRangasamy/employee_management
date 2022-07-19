package com.sql.employee_management.service;

import com.sql.employee_management.dao.EmployeeDao;

public class EmployeeService {
	private EmployeeDao empdao = new EmployeeDao();
	
	public void createEmpTable()
	{
		empdao.createTable();
		System.out.println("Table created successfully");
	}
	
	public boolean insertEmployee(int empId, String empName, String empDept, String empDoj) {
		empdao.insertEmployeeData(empId, empName, empDept, empDoj);
		return true;
	}
	
	public boolean updateEmployee(int empId, String empName, String empDept, String empDoj) {
		empdao.updateEmployee(empId, empName, empDept, empDoj);
		return true;
	}
	
	public void viewEmployee(int empId)
	{
		empdao.viewEmployee(empId);
	}
	
	public void viewAllEmployee()
	{
		empdao.viewAllEmployee();
	}
	
	public boolean deleteEmployee(int empId)
	{
		if(empdao.deleteEmployee(empId) == 1)
			return true;
		else
			return false;
	}
}
