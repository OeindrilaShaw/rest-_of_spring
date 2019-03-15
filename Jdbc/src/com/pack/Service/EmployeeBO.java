package com.pack.Service;

import java.util.List;

import com.pack.Dao.EmployeeDAO;
import com.pack.Model.Employee;

public class EmployeeBO {

	public static void insertEmployee(Employee e) throws Exception{
		EmployeeDAO.insertEmployee(e);
		/*return i;*/
		
	}
	public static void updateEmployee(Employee e) throws Exception{
		EmployeeDAO.updateEmployee(e);
		/*return i;*/
		
	}
	public static void deleteEmployee(int e) throws Exception{
		EmployeeDAO.deleteEmployee(e);
		/*return i;*/
		
	}
	public static List<Employee> viewEmployee() throws Exception{
		List<Employee> i=EmployeeDAO.viewEmployee();
		return i;
		
	}
}
