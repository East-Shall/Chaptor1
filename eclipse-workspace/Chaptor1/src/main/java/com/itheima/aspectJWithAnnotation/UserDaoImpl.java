package com.itheima.aspectJWithAnnotation;

import org.springframework.stereotype.Component;

import com.itheima.jdk.UserDao;

//import org.springframework.stereotype.Repository;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {
	public void addUser() {
		System.out.println("����û�");
	}

	public void deleteUser() {
		System.out.println("ɾ���û�");
	}
	
	public void searchUser() {
		System.out.println("��ѯ�û�");
	}
	
}
