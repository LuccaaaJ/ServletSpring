package com.exam.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//이 클래스의 객체를 생성하여 "ma"라는 이름으로 스프링에 등록
//자바 언옵테이션 문법 :  value는 사용해도 되고 안해도 된다.
// 만약 value값 즉 이름을 넣어주지 않으면 클래스의 이름으로 저장된다(소문자로)
@Component("ma")
public class MyApp {
	//@Autowired,@Inject, @Qualifier("--") @Named("--") ---type으로 먼저 찾고 name을 찾는다.
	//@Resoure: 스프링에 등록된 객체를 이 변수(속성)에 주입(저장) 	---name으로 먼저 찾고 없으면 type으로 찾는다.
	@Autowired
	private MyService myService;
	
	public void say() {
		System.out.println(myService.getMessage());
	}

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
}
