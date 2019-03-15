package com.pack;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args){

		ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
Student s=(Student)f.getBean("studentbean");
s.display();
}
}
