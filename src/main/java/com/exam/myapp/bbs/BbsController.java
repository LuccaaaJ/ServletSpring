package com.exam.myapp.bbs;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.myapp.member.MemberVo;



@Controller
@RequestMapping("/bbs/")
public class BbsController {

	
	@Autowired
	private BbsService bbsService; 
	
	
	@GetMapping("list.do") //@RequestMapping(value = "list.do",method = RequestMethod.GET)
	public String list(Model model) {		
		List<BbsVo> list = bbsService.selectBbsList();
		model.addAttribute("bbsList",list);
		return "bbs/bbsList";
		
	}
	@GetMapping("add.do") //@RequestMapping(value = "add.do",method = RequestMethod.GET)
	public String addform() {
		return "bbs/bbsAdd";
	}
	
	@PostMapping("add.do")	//@RequestMapping(value = "add.do",method = RequestMethod.POST)
	public String add(BbsVo vo
			, HttpSession sessionm
			,@SessionAttribute("loginUser") MemberVo mvo) { //지정한 세션 속성값을 이 변수에 저장
		
		//MemberVo mvo = (MemberVo) session.getAttribute("loginUser");//세션에서 로그인정보를 꺼내온다.
		vo.setBbsWriter(mvo.getMemId());//로그인한 사람의 아이디를 게시글 작성자로 설정
//		req.setCharacterEncoding("UTF-8");	//필터로 이동		
		int n = bbsService.insertBbs(vo);
		System.out.println(n + "개의 글 추가");
		// redirect 뷰를 만들어서 forword 하지않고 redirect 해준다. 
		return "redirect:/bbs/list.do";
	}
	
	
	@GetMapping("edit.do")//@RequestMapping(value = "edit.do",method = RequestMethod.GET)
	public String editform(int bbsNo, Model model) {
							//요청파라미터 이름과 변수 이름이 같다면 @RequestParam("memId") 생략
			BbsVo vo = bbsService.selectBbs(bbsNo);
			model.addAttribute("bbsVo", vo);
			return "/bbs/bbsEdit";
		}
	
	@PostMapping("edit.do")//@RequestMapping(value = "edit.do",method = RequestMethod.POST)
	public String edit(BbsVo vo) {
		int n = bbsService.updateBbs(vo);
		System.out.println(n + "개의 게시글 변경");
		return "redirect:/bbs/list.do";
		}
	
	//1.삭제기능이 동작하도록 이 메서드 코드를 변경하시오.
	//2.회원정보변경 화면에 삭제버튼을 추가
	@GetMapping("del.do") //@RequestMapping(value = "del.do",method = RequestMethod.GET)
	public String del(int bbsNo) {
		int n = bbsService.deleteBbs(bbsNo);
		System.out.println(n + "개의 게시글삭제");
		return "redirect:/bbs/list.do";
	
	}
	
	
	}

