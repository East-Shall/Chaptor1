package com.itheima.ioc;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		// ��ʼ��Spring���������������ļ���ͨ��������ȡUserDao����
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao exa=(UserDao)applicationContext.getBean("userDao");
		exa.play();
	}
}
