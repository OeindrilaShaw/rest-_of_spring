package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext c=new ClassPathXmlApplicationContext("hello.xml");
		Profile p=(Profile)c.getBean("profile");
		p.showAge();
		p.showName();
	}

}
