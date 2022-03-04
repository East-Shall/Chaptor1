package com.itheima.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("com/itheima/annotation/Bean6.xml");
		UserService us=(UserService)ap.getBean("userService");
		us.save();
	}
}
