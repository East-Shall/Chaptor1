package com.itheima.ioc;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		// 初始化Spring容器，加载配置文件，通过容器获取UserDao对象
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao exa=(UserDao)applicationContext.getBean("userDao");
		exa.play();
	}
}
