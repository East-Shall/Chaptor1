package com.itheima.cglib;

public class CglibTest {
	public static void main(String[] args) {
		//�����������
		CglibProxy cp=new CglibProxy();
		UserDao ud=new UserDao();
		UserDao example=(UserDao)cp.createProxy(ud);
		example.addUser();
		example.deleteUser();
	}
}
