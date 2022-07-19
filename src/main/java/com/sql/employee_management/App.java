package com.sql.employee_management;

import java.util.Scanner;

import com.sql.employee_management.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Welcome to Employee Management..");
    	char ch = 'Y';
    	Scanner ip = new Scanner(System.in);
    	EmployeeService empsvc = new EmployeeService();
    	int empId;
    	String empName, empDept, empDoj;
    	
    	while(ch == 'Y')
    	{
    		System.out.println("1.Add Employee\n2.View Employee\n3.Update Employee\n4.Delete Employee\n5View all Employee\n6.Exit");
    		int opt = ip.nextInt();
    		switch(opt)
    		{
    		case 1:
    			System.out.println("ADD AN EMPLOYEE..");
    			System.out.println("Enter Employee Id:");
    			empId = ip.nextInt();
    			System.out.println("Enter Employee Name:");
    			empName = ip.next();
    			System.out.println("Enter Employee Dept:");
    			empDept = ip.next();
    			System.out.println("Enter Employee DOJ:");
    			empDoj = ip.next();
    			if(empsvc.insertEmployee(empId, empName, empDept, empDoj))
    			{
    				System.out.println("Employee Added Successfully...");
    			}
    			else
    			{
    				System.out.println("Something Wrong...");
    			}
    			break;
    		case 2:
    			System.out.println("View Employee..");
    			System.out.println("Enter Employee Id:");
    			empId = ip.nextInt();
    			empsvc.viewEmployee(empId);
    			break;
    		case 3:
    			System.out.println("Update Employee");
    			System.out.println("Enter Employee Id:");
    			empId = ip.nextInt();
    			System.out.println("Enter Employee Name:");
    			empName = ip.next();
    			System.out.println("Enter Employee Dept:");
    			empDept = ip.next();
    			System.out.println("Enter Employee DOJ:");
    			empDoj = ip.next();
    			if(empsvc.updateEmployee(empId, empName, empDept, empDoj))
    			{
    				System.out.println("Employee Updated Successfully...");
    			}
    			else
    			{
    				System.out.println("Something Wrong...");
    			}
    			break;
    		case 4:
    			System.out.println("Delete Employee");
    			System.out.println("Enter Employee Id:");
    			empId = ip.nextInt();
    			if(empsvc.deleteEmployee(empId))
    			{
    				
    				System.out.println("Employee Deleted Successfully...");
    			}
    			else
    			{
    				System.out.println("Something Wrong...");
    			}
    			
    			break;
    		case 5:
    			System.out.println("View All Employee");
    			empsvc.viewAllEmployee();
    			break;
    			
    		default:
    			break;
    		}
    		System.out.println("Want to Continue(Y/N)");
    		ch = ip.next().charAt(0);
    	}
    }
}
