package com.exam.myapp.comm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.exam.myapp.member.MemberVo;

//필터 : 서블릿의 실행 전후에 끼어들어가서 실행
//	다수의 서블릿들이 수행라는 공통작업을 실행하도록 사용
// Filter 인터페이스를 구현하여 필터 클래스 정의
//web.xml 에 <filter> 태그로 등록하거나, 클래스에 @WebFilter 적용

//다수의 컨트롤러 실행 전후에 수행해야 하는 공통 작업들은 핸들러인터셉터를 사용하여 구현 가능

public class LoginInterceptor implements HandlerInterceptor{
	
	//요청- 로그인 보낸사람인지 아닌지 확인후 안한 사람이면 못쓰게 하려고 함>> preHandle 사용
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 컨드롤러 실행 전에 실행되는 메서드
		//handler : 현재 인터셉터 이후에 실행될 인터셉터 또는 컨트롤러
		//반환값 : 이후에 실행될 인터셉터 또는 컨트롤러의 싱행 여부
		//요청보낸 사용자의 세션을 가져옴
		HttpSession session = request.getSession(); 
		//세션에 로그인한 사용자 정보
		MemberVo vo = (MemberVo) session.getAttribute("loginUser");
		//로그인 정보가 없다면,
		if(vo==null) {
			//로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/login.do");
			return false; //컨트롤러 실행하지 않음 false로 주는 이유는 로그인정보가 없다면 결과값을 반환하지않게 하기 위해서 (보안!)
		}
		return true;
	}
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// 컨트롤러 실행 후, 뷰(JSP) 실행 전에 실행되는 메서드
//		
//	}
//	
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// 뷰렌더링(JSP실행및출력) 완료 후에 실행되는 메서드
//		
//	}
	
}