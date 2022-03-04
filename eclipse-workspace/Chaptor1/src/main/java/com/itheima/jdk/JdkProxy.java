package com.itheima.jdk;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;

import java.lang.reflect.Proxy;

import com.itheima.aspect.MyAspect;

/*�����ࣨ��̬�������ڽ�֪ͨӦ�õ�����㣩*/
public class JdkProxy implements InvocationHandler {
	private UserDao userDao;

	public Object createProxy(UserDao userDao) {
		this.userDao = userDao;
		ClassLoader cLoader = JdkProxy.class.getClassLoader();// �������
		Class[] clazz = userDao.getClass().getInterfaces();// ������Ķ�������нӿ�
		return Proxy.newProxyInstance(cLoader, clazz, this);//���е�userDao��ʵ���൱�еķ������ᱻ�����֪ͨ����
	}

	/*
	 * ���ж�̬������ķ������ã�������invoke()����ȥ���� �����Ĳ����ľ��庬�壺proxy��ʾ�������Ķ���method��ʾ��Ҫ��ִ�еķ�����Ϣ��
	 * argsΪִ�з���ʱ��Ҫ�Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MyAspect myAspect = new MyAspect();
		myAspect.check();//�����෽���ľ��������
		Object obj = method.invoke(userDao, args);
		myAspect.log();
		return obj;
	}

}
