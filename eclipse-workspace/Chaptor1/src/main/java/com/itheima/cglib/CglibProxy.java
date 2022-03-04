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
		en.setCallback((Callback) this);// 用于添加调用的intercept，添加的是实现了MethodInterceptor接口的类对象
		return en.create();// 这个时候返回的也就是一个经过加强的目标类
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
