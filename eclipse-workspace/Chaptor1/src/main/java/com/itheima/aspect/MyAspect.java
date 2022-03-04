package com.itheima.aspect;

public class MyAspect {// 进行通知的的代码，切入点当中将要执行的程序代码
	public void check() {
		System.out.println("模拟检查~~~");
	}

	public void log() {
		System.out.println("模拟日志~~~");
	}
}
