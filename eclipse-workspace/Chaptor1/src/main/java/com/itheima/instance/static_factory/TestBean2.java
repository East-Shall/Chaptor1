package com.itheima.instance.static_factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean2 {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("Bean2.xml");
		Bean2 b=(Bean2)ac.getBean("bean2");
		b.show();
	}
}
