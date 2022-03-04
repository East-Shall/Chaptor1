package com.itheima.aspectJWithAnnotation;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类，在此类当中编写通知
 * */
@Aspect
@Component
public class MyAspect {
	// 定义切入点的表达式
	@Pointcut("execution(* com.itheima.aspectJWithAnnotation.*.*(..))")
	private void myPointCut() {//用以定义切入点的空方法(可能是为了方便后面的通知使用)
		
	}
	// 前置通知
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知：模拟执行权限检查");
		System.out.println("目标类是" + joinPoint.getTarget());
		System.out.println("被植入增强处理目标方法" + joinPoint.getSignature().getName());
	}

	// 后置通知
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("后置通知：被植入增强处理的目标方法" + joinPoint.getSignature().getName() + "\n");
	}

	/*
	 * 环绕通知 ProceedingJoinPoint表示可以执行的目标方法 1.要求Object类型的返回值
	 * 2.必须要接受一个ProceedingJoinPoint参数 3.必须包含throws Trowable
	 */
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕开始：模拟开启事务");
		Object obj = pjp.proceed();
		System.out.println("环绕结束：执行目标方法之后，模拟关闭事务");
		return obj;
	}

}
