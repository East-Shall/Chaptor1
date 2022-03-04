package com.itheima.jdk;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;

import java.lang.reflect.Proxy;

import com.itheima.aspect.MyAspect;

/*代理类（动态创建用于将通知应用到切入点）*/
public class JdkProxy implements InvocationHandler {
	private UserDao userDao;

	public Object createProxy(UserDao userDao) {
		this.userDao = userDao;
		ClassLoader cLoader = JdkProxy.class.getClassLoader();// 类加载器
		Class[] clazz = userDao.getClass().getInterfaces();// 被代理的对象的所有接口
		return Proxy.newProxyInstance(cLoader, clazz, this);//所有的userDao的实现类当中的方法都会被添加上通知程序
	}

	/*
	 * 所有动态代理类的方法调用，均交由invoke()方法去处理 方法的参数的具体含义：proxy表示被代理后的对象，method表示将要被执行的方法信息，
	 * args为执行方法时需要的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MyAspect myAspect = new MyAspect();
		myAspect.check();//切面类方法的具体切入点
		Object obj = method.invoke(userDao, args);
		myAspect.log();
		return obj;
	}

}
