package com.itheima.jdk;

public class JdkTest {
	public static void main(String[] args) {
		JdkProxy jp = new JdkProxy();
		UserDao userDao = new UserDaoImpl();
		UserDao ud = (UserDao) jp.createProxy(userDao);// �Ӵ�������л����ǿ���Ŀ�����
		ud.addUser();
		ud.deleteUser();
	}
}
