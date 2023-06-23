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

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.exam.myapp.member.MemberVo;

//필터 : 서블릿의 실행 전후에 끼어들어가서 실행
//	다수의 서블릿들이 수행라는 공통작업을 실행하도록 사용
// Filter 인터페이스를 구현하여 필터 클래스 정의
//web.xml 에 <filter> 태그로 등록하거나, 클래스에 @WebFilter 적용

//다수의 컨트롤러 실행 전후에 수행해야 하는 공통 작업들은 핸들러인터셉터를 사용하여 구현 가능

public class LoginFilter extends HandlerInterceptorAdapter{
	private List<String> whiteList = new ArrayList<String>();
	//로그인 없이 사용가능한 요청경로들을 저장한 목록
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			whiteList.add("/member/login.do");
			whiteList.add("/member/add.do");
		}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println("URI:" + req.getRequestURI());
		System.out.println("URL:" + req.getRequestURL());
		String reqPath = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("reqPath: "+ reqPath);

		
		if(whiteList.contains(reqPath) == false) {
			
			//요청보낸 사용자의 세션을 가져옴
			HttpSession session = req.getSession(); 
			//세션에 로그인한 사용자 정보
			MemberVo vo = (MemberVo) session.getAttribute("loginUser");
			//로그인 정보가 없다면,
			if(vo==null) {
				//로그인 페이지로 이동
				resp.sendRedirect(req.getContextPath() + "/member/login.do");
				return;
			}
			
		}
		
		
		chain.doFilter(request, response);
		
	}
	   @Override
	   public void destroy() {
	      // 필터 객체가 소멸(삭제)되기 전에 1번 실행
	      System.out.println("CharEncFilter destory() 실행");
	
	   }
}