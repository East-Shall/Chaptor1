package com.itheima.aspectJWithAnnotation;

import org.springframework.stereotype.Component;

import com.itheima.jdk.UserDao;

//import org.springframework.stereotype.Repository;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {
	public void addUser() {
		System.out.println("添加用户");
	}

	public void deleteUser() {
		System.out.println("删除用户");
	}
	
	public void searchUser() {
		System.out.println("查询用户");
	}
	
}
