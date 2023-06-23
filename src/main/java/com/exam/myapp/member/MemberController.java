package com.exam.myapp.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MemberController {

	
	@Autowired
	private MemberService memberService; 
	
	@RequestMapping(value = "/member/list.do",method = RequestMethod.GET)
	public String list(Model model) {		
		List<MemberVo> list = memberService.selectMemberList();
		model.addAttribute("memberList",list);
		return "member/memList";
		
	}
	@RequestMapping(value = "/member/add.do",method = RequestMethod.GET)
	public String addform() {
		return "member/memAdd";
	}
	
	@RequestMapping(value = "/member/add.do",method = RequestMethod.POST)
	public String add(MemberVo vo) {
		
//		req.setCharacterEncoding("UTF-8");	//필터로 이동		
		int n = memberService.insertMember(vo);
		System.out.println(n + "명의 회원 추가");
		// redirect 뷰를 만들어서 forword 하지않고 redirect 해준다. 
		return "redirect:/member/list.do";
	}
	
	
	@RequestMapping(value = "/member/edit.do",method = RequestMethod.GET)
	public String editform(String memId, Model model) {
							//요청파라미터 이름과 변수 이름이 같다면 @RequestParam("memId") 생략
			MemberVo vo = memberService.selectMember(memId);
			model.addAttribute("mvo", vo);
			return "/member/memEdit";
		}
	
	@RequestMapping(value = "/member/edit.do",method = RequestMethod.POST)
	public String edit(MemberVo vo) {
		int n = memberService.updateMember(vo);
		System.out.println(n + "명의 회원 변경");
		return "redirect:/member/list.do";
		}
	
	//1.삭제기능이 동작하도록 이 메서드 코드를 변경하시오.
	//2.회원정보변경 화면에 삭제버튼을 추가
	@RequestMapping(value = "/member/del.do",method = RequestMethod.GET)
	public String del(String memId) {
		int n = memberService.deleteMember(memId);
		System.out.println(n + "명의 회원 삭제");
		return "redirect:/member/list.do";
	
	}
	
	//로그인 동작이  수행되도록 아래 메서드들을 변경하기.
	@RequestMapping(value = "/member/login.do",method = RequestMethod.GET)
	public String loginform() {
			return "/member/login";
		}
		
	@RequestMapping(value = "/member/login.do",method = RequestMethod.POST)
	public String login(MemberVo vo, Model model,HttpServletRequest req) {
			
			MemberVo mvo = memberService.selectLogin(vo);
			if(mvo==null) { //로그인실패
				return "redirect:/member/login.do";
			}else {//로그인성공
				HttpSession session = req.getSession();
				session.setAttribute("loginUser", mvo);//세션에 로그인한 사용자 정보 저장
				return "redirect:/member/list.do";
			
			}
	}
	
	@RequestMapping(value = "/member/logout.do",method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
//					session.setAttribute("loginUser", null); //방식 1. 세션에 지정한 이름의 값을 null로 설정 (: 특정세션 삭제)
//					session.removeAttribute("loginUser"); //방식 2. 세션에서 지정한 이름의 속성을 삭제 (:특정세션 삭제)
		session.invalidate();//방식 3.세션객체를 제거(후 다시 생성), 모든 속성들도 함께 삭제 (:모든세션 삭제)
		
		return "redirect:/member/login.do"; // 로그아웃 후 로그인페이지 
		
		}	
	
	}

