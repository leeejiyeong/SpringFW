package co.micol.prj.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect	//aspect그룹에 들어갈 advice라는 뜻
public class AopAspect {
	
	@Pointcut("execution(* co.micol.prj..*impl.*(..))")
	public void allPointCut() {}
	
	//위빙
	@Before("allPointCut()")
	public void beforeLog() {
		System.out.println("시작 전 수행==-=======-==");
	}
	
	@After("execution(* co.micol.prj..*impl.*(..))")
	public void afterLog() {
		System.out.println("메소드 실행 후 동작========================");
	}
	
//	@Around("allPointcut")
	public void aroundLog() {
		System.out.println("메소드 시작과 끝에 동작 ===========");
	}
}
