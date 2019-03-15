package com.pack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.pack.Model.Employee;
import com.pack.Service.EmployeeBO;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
     Scanner s=new Scanner(System.in);
     int ch,num;
     String name,dob,desg;
     float sal;
     do{
    	 System.out.println("Enter Choice");
    	 ch=Integer.parseInt(s.nextLine());
     System.out.println("#########Employee Info###########");
     System.out.println("Menu");
     System.out.println("1.Add Employee");
     System.out.println("2.Update Employee");
     System.out.println("3.Delete Employee");
     System.out.println("4.View Employee");
     switch(ch){
     case 1:System.out.println("enter employee name");
            name=s.nextLine();
            System.out.println("enter salary");
            sal=Float.parseFloat(s.nextLine());
            System.out.println("enter date of birth");
            dob=s.nextLine();
            System.out.println("Enter designation");
            desg=s.nextLine();
            Random x=new Random();
            num=x.nextInt(900000)+100000;
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);//show exception
            Date d=null;
            try{
            	d=sdf.parse(dob);
            }catch(ParseException e){
            	System.out.println(e);
            }
            
            Employee e=new Employee(num,name,sal,d,desg);
           EmployeeBO.insertEmployee(e);
            /*if(i==1){
            	System.out.println("Employee inserted successfully");
            }*/
            
    	 break;
     case 2:System.out.println("Enter emp id");
            num=Integer.parseInt(s.nextLine());
            System.out.println("Enter employee salary");
            sal=Float.parseFloat(s.nextLine());
            System.out.println("Enter designation");
            desg=s.nextLine();
            Employee e1=new Employee(num,sal,desg);
            EmployeeBO.updateEmployee(e1);
            /*if(i1==1){
            	System.out.println("Employee updated successfully");
            }*/
    	 break;
     case 3:System.out.println("enter employee id");
            num=Integer.parseInt(s.nextLine());
            
            EmployeeBO.deleteEmployee(num);
           /* if(i2==1){
            	System.out.println("Employee deleted successfully");
            }*/
    	 break;
     case 4:
        		 List<Employee> l=EmployeeBO.viewEmployee();
        		 System.out.format("%-10s %-20s %-10s %-10s %-10s\n","EmployeeId","Employee name","Salary","Date of Birth","Designation");
        		 SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
        		 for(Employee ex:l){
        			 System.out.format("%-10s %-20s %-10s %-10s %-10s\n",ex.getId(),ex.getName(),ex.getSalary(),sdf1.format(ex.getDob()),ex.getDesignation());
        		 }
    	 break;
    	 default:System.out.println("Wrong choice");
    	 break;
     }
	}while(ch<5);
	}
}
