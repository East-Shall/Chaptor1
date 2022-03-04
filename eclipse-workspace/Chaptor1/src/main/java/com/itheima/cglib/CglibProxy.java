package com.itheima.cglib;

import java.lang.reflect.Method;


import com.itheima.aspect.MyAspect;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	public Object createProxy(Object target) {
		Enhancer en=new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback((Callback) this);// ������ӵ��õ�intercept����ӵ���ʵ����MethodInterceptor�ӿڵ������
		return en.create();// ���ʱ�򷵻ص�Ҳ����һ��������ǿ��Ŀ����
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		MyAspect myAspect = new MyAspect();
		myAspect.check();
		Object obj = methodProxy.invokeSuper(proxy, args);
		myAspect.log();
		return obj;
	}
}
