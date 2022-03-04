package com.itheima.aspectJWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.jdk.UserDao;

public class TestAnnotation {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itheima/aspectJWithAnnotation/ap.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.addUser();
	}
}
