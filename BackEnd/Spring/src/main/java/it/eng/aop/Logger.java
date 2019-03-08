package it.eng.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	 	//  advise all methods in class employeeDao 
		@Pointcut("execution(* it.eng..dao..*(..))")
		public void daoMethod() {
		}

		@Around(value = "daoMethod()")
		public void daoMethod(ProceedingJoinPoint p) {
			System.out.println("Entering" + p.getThis().getClass() +  " method...");
//			try {
//				p.proceed();
//				System.out.println("CreateEmployee method finished...");
//			} catch (Throwable e) {
//				System.out.println("CreateEmployee method error: , " + e.getMessage());
//			}
		}

		@AfterThrowing(value = "cameraSnap()")
		public void afterThrowingAdvice() {
			System.out.println("After throwing...");
		}

		@AfterReturning(value = "cameraSnap()")
		public void afterReturningAdvice() {
			System.out.println("After succeeding...");
		}
}
