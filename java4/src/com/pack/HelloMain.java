package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
HelloWorld hw=(HelloWorld)f.getBean("hello");
System.out.println(hw.getMessage1());
System.out.println(hw.getMessage2());
HelloIndia hw1=(HelloIndia)f.getBean("hello1");
System.out.println(hw1.getMessage1());
System.out.println(hw1.getMessage2());
System.out.println(hw1.getMessage3());



	}

}
