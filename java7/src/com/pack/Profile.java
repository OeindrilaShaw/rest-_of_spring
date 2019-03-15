package com.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	@Autowired
	@Qualifier("student")
private Student student;

public Profile() {
	super();
	System.out.println("inside profile constructor");
}
public void showAge(){
	System.out.println(student.getAge());

}
public void showName(){
	System.out.println(student.getName());

}
}
