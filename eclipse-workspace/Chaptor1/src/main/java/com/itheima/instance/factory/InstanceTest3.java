package com.itheima.instance.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest3 {
	public static void main(String[] args) {
		String xmlPath = "com/itheima/instance/factory/Bean3.xml";
		ApplicationContext ap=new ClassPathXmlApplicationContext(xmlPath);
		Bean3 b=(Bean3)ap.getBean("Bean3");
		b.show();
	}
}
