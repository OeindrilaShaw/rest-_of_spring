package com.pack.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.HibernateUtil;
import com.pack.JDBCConnection;
import com.pack.Model.Employee;

public class EmployeeDAO {
 public static void insertEmployee(Employee e) throws Exception{
	/* Connection con=JDBCConnection.getConnection();
	 PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
	 ps.setInt(1,e.getId());
	 ps.setString(2,e.getName());
	 ps.setFloat(3,e.getSalary());
	 java.sql.Date d1=new java.sql.Date(e.getDob().getTime());//convert util date to sql date
	 ps.setDate(4,d1);
	 ps.setString(5,e.getDesignation());
	 int i=ps.executeUpdate();
	 con.close();
	 return i;*/
	 Session s=HibernateUtil.getSessionFactory().openSession();// we write hibernate because configuration and sessiofactory are prsnt in hibernateutil
    //open session creates the session
	 Transaction t=null;
	 try{
		 t=s.beginTransaction();
		 s.save(e);//to insert
		 System.out.println("Employee added successfully");
		 t.commit();
	 }
	 catch(HibernateException e1){
		 System.out.println(e1);
		 t.rollback();
	 }
	 finally{
		 s.close();
	 }
 }
 public static void updateEmployee(Employee e) throws Exception{ 
	 /*Connection con=JDBCConnection.getConnection();
	 PreparedStatement ps=con.prepareStatement("update employee set salary=?,designation=? where id=?");
	 ps.setFloat(1,e.getSalary());
	 ps.setString(2,e.getDesignation());
	 ps.setInt(3,e.getId());
	 int i=ps.executeUpdate();
	 con.close();
	 return i;*/
	 Session s=HibernateUtil.getSessionFactory().openSession();
	 Transaction t=null;
	 try{
		 t=s.beginTransaction();
		/* String hql="From Employee e where e.id=:eid";
		 Query q=s.createQuery(hql);
		 q.setInteger("eid",e.getId());
		 Employee e1=(Employee)q.uniqueResult();
		 e1.setSalary(e.getSalary());
		 e1.setDesignation(e.getDesignation());
		 s.update(e1);*/
		 String hql1="update Employee e1 set e1.salary=:sal,e.designation=:des where e1.id=:eid";
		 Query q=s.createQuery(hql1);
		 q.setParameter("sal",e.getSalary());
		 q.setParameter("des", e.getDesignation());
		 q.setParameter("eid",e.getId());
		 int i=q.executeUpdate();
		 if(i==1){
			 System.out.println("upadted succesfully");
		 /*int id=e.getId();
		 Employee e1=(Employee)s.get(Employee.class,id);
		 e1.setSalary(e.getSalary());
		 e1.setDesignation(e.getDesignation());
		 s.update(e1);
		 System.out.println("Employee updated successfully");*/
		 t.commit();
		 }
	 }
	 catch(HibernateException e1){
		 System.out.println(e1);
		 t.rollback();
	 }
	 finally{
		 s.close();
	 }
 }
 public static void deleteEmployee(int id) throws Exception{
	 /*Connection con=JDBCConnection.getConnection();
	 PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
	 ps.setInt(1,e);
	 int i=ps.executeUpdate();
	 con.close();
	 return i;*/
	 Session s=HibernateUtil.getSessionFactory().openSession();
	 Transaction t=null;
	 try{
		 t=s.beginTransaction();
		 String hql="delete from Employee e where e.id=:eid";
		 Query q=s.createQuery(hql);
		 q.setParameter("eid",id);
		 int i=q.executeUpdate();
		 if(i==1)
		 {
			 System.out.println("deletedsuccessfully");
		/* int id=e.getId();
		 Employee e1=(Employee)s.get(Employee.class,id);
		 if(e1!=null)
		 {
			 s.delete(e1);
		 
		 System.out.println("Employee updated successfully");*/
		 t.commit();
		 }
	 }
	 catch(HibernateException e1){
		 System.out.println(e1);
		 t.rollback();
	 }
	 finally{
		 s.close();
	 }
 } 
 public static List<Employee> viewEmployee() throws Exception{
	/* Connection con=JDBCConnection.getConnection();
	 Statement st=con.createStatement();
	 ResultSet rst=st.executeQuery("select * from employee");
	 //ResultSet rst=st.executeQuery("select name,salary from employee");
	 List<Employee> l=new ArrayList<>();
	  while(rst.next()){
		Employee e=new Employee();
		e.setId(rst.getInt(1));
		e.setName(rst.getString(2));//String s=rst.getString(1);
		e.setSalary(rst.getFloat(3));//int sa=rst.getInt(2);
		java.util.Date d=new java.util.Date(rst.getDate(4).getTime());
		e.setDob(d);
		e.setDesignation(rst.getString(5));
	    l.add(e);
	  }*/
	 Session s=HibernateUtil.getSessionFactory().openSession();
	 Transaction t=null;
	 List<Employee> l=null;
	 try{
		 t=s.beginTransaction();
		 Query q=s.createQuery("From Employee");
		 l=q.list();

	 }
	 catch(HibernateException e1)
	 {
		 System.out.println(e1);
		 t.rollback();
	 }
	 finally{
	  s.close();
	return l;
 }
}
}
