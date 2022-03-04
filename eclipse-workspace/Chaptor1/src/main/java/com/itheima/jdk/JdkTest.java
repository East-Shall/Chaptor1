package com.itheima.jdk;

public class JdkTest {
	public static void main(String[] args) {
		JdkProxy jp = new JdkProxy();
		UserDao userDao = new UserDaoImpl();
		UserDao ud = (UserDao) jp.createProxy(userDao);// 从代理对象中获得增强后的目标对象
		ud.addUser();
		ud.deleteUser();
	}
}
