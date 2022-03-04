package com.itheima.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("com/itheima/scope/Bean4.xml");
		System.out.println(ap.getBean("scope"));//查看第一个获得的实例
		System.out.println(ap.getBean("scope"));
		
	}
}
