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
 * �����࣬�ڴ��൱�б�д֪ͨ
 * */
@Aspect
@Component
public class MyAspect {
	// ���������ı��ʽ
	@Pointcut("execution(* com.itheima.aspectJWithAnnotation.*.*(..))")
	private void myPointCut() {//���Զ��������Ŀշ���(������Ϊ�˷�������֪ͨʹ��)
		
	}
	// ǰ��֪ͨ
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("ǰ��֪ͨ��ģ��ִ��Ȩ�޼��");
		System.out.println("Ŀ������" + joinPoint.getTarget());
		System.out.println("��ֲ����ǿ����Ŀ�귽��" + joinPoint.getSignature().getName());
	}

	// ����֪ͨ
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("����֪ͨ����ֲ����ǿ�����Ŀ�귽��" + joinPoint.getSignature().getName() + "\n");
	}

	/*
	 * ����֪ͨ ProceedingJoinPoint��ʾ����ִ�е�Ŀ�귽�� 1.Ҫ��Object���͵ķ���ֵ
	 * 2.����Ҫ����һ��ProceedingJoinPoint���� 3.�������throws Trowable
	 */
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���ƿ�ʼ��ģ�⿪������");
		Object obj = pjp.proceed();
		System.out.println("���ƽ�����ִ��Ŀ�귽��֮��ģ��ر�����");
		return obj;
	}

}
