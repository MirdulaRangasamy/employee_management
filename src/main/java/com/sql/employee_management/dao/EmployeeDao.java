package com.sql.employee_management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
	private Connection con;
	private Statement st;
	public EmployeeDao()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b7262","root","Kuzhazhi@123456");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("No class found");
		}
		catch(SQLException e)
		{
			System.out.println("SQL Error");
		}
	}
	
	public void createTable() {
		try {
			st = con.createStatement();
			String sql = "create table employee(empid int primary key, empname varchar(30), empdept varchar(10), empDOJ date)";
			st.execute(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
		}
	}
	
	public void insertEmployeeData(int empid,String empname, String dept, String empDOJ)
	{
		try {
			st = con.createStatement();
			String sql = "insert into employee values("+empid+",'"+empname+"','"+dept+"','"+empDOJ+"')";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
		}		
	}
	
	public void viewEmployee(int empId)
	{
		try {
			st = con.createStatement();
			String sql = "select * from employee where empid = "+empId;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				System.out.println(rs.getString("empid")+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
		}
	}
	
	public void viewAllEmployee()
	{
		try {
			st = con.createStatement();
			String sql = "select * from employee";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString("empid")+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
		}
	}
	
	public void updateEmployee(int empId, String empname, String dept, String empDOJ)
	{
		try {
			st = con.createStatement();
			String sql = "update employee set empname ='"+empname+"',empdept='"+dept+"',empDOJ='"+empDOJ+"' where empid = "+empId;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
		}
	}
	
	public int deleteEmployee(int empId)
	{
		try {
			st = con.createStatement();
			String sql = "delete from employee where empid = "+empId;
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
			return 0;
		}
	}
}
