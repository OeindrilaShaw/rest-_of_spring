package com.pack;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory;
static{
	try{
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	catch(Throwable ex){
		System.out.println("SessionFactory creation failed" +ex);
		throw new ExceptionInInitializerError(ex);
	}
}
public static SessionFactory getSessionFactory(){
	return sessionFactory;
}
}
