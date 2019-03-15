package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
		javaCollection jc=(javaCollection)f.getBean("collection");
		System.out.println(jc.getAddresslist());
		System.out.println(jc.getAddressset());
		System.out.println(jc.getAddressmap());
		System.out.println(jc.getAddressprop());
	}

}
