package com.exam.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	
	
	public static void main(String[] args) {
		//MyApp, MyServiceKo를 사용하여, 콘솔에 "안녕"이 출력되도록 구현
//		MyApp mapp = new MyApp();
//		
//		MyServiceKo msk = new MyServiceKo();
//		myapp.setMyService(msk);
//		
//		MyServiceEn mse =new MyServiceEn();
//		myapp.setMyService(mse);
		
		
	// 스프링 ==(IoC/DI 기능을 가진) 객체컨테이너 (객체들을 여러개 가지고있는 틀) -(유사표현) == BeanFactory == ApplicationContext
	//클래스패스 상의 XML 파일로부터 설정을 읽어서, 스프링 객체 컨테이너를 생성
	//ApplicationContext ctx = new ClassPathXmlApplicationContext("/com/exam/ex/context.xml");
	
	//JAVA 클래스로부터 설정을 읽어서, 스프링 객체 컨테이너를 생성
	ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
	//스프링에 "ma"라는 이름으로 등록되어있는 개체를 가져오기
	MyApp mapp =(MyApp) ctx.getBean("ma");
	
	mapp.say();
	
	} 
}
