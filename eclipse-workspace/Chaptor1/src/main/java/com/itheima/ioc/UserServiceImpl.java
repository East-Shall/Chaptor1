package com.itheima.ioc;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public void setUserDao(UserDao userdao) {//“¿¿µ◊¢»Î
		this.userDao=userdao;
	}
	public void say() {
		this.userDao.play();
		System.out.println("Always focus on your own buiness.");
	}
}
