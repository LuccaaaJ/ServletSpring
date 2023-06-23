package com.exam.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */

//-컨트롤러(=핸들러) : 웹 요청을 받았을때 실행되는 객체
//- 모델 : 응답 출력시 사용(포함)할 데이터
//- 뷰 : 화면 출력을 담당하는 객체(JSP)
// 컨트롤러(요청을 받았을때 실행되는 객체)로서 스프링(DespatcherServlet)에 등록
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// "/"경로로 GET 방식 요청이 오면 실행
	//value="" == path==""
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Map map, ModelMap modelMap) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//모델 : 응답/화면(JSP) 출력시 포함할 데이터
		//모델에 데이터를 추가(저장)하기 위해서는,
		//인자로 받은 Model,Map,ModelMap 객체에 이름-값 형식으로 데이터를 저장
		//JSP에서는 ${모델이름} 으로 값을 꺼내서 사용가능
		model.addAttribute("a", formattedDate );
		map.put("b", formattedDate);
		modelMap.addAttribute("c",formattedDate);
		
		
		
		return "home"; //컨트롤러가 문자열을 반환하면 스프링은 문자열을 뷰이름으로 인식
		//Servlet-context.xml의 InternalResourceViewResolver 설정대로
		//문자열 앞에 /WEB-INF/views/ 를 추가하고
		//문자열 뒤에 .jsp를 추가한 주소(경로)로 이동( forward)
		// 값을 반환할때 주소를 home이라고만 써도 "WEB-INF/views/home.jsp" 에 포워딩 시킨다는 뜻
		// ( 즉, WEB-INF/views/home.jsp 파일 실행.
	}
	//브라우저에서 http://localhost:8000/myapp/test 로 접속하면,
	// test()메서드와 test.jsp가 순서대로 실행되어 
	//test.jsp의 h1태그 내용에 변수 s값("JSP에서 출력할 문자열")이 출력되도록 구현
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	// == @GetMapping(value="/test") //요청방식별 @RequestMapping 애노테이션도 사용 가능
	public String test(@RequestParam(value = "x") String xv
	//,@RequestParam(value = "y") 변수 이름이 파라미터 이름과 동일하면 생략가능
						
						,int y 
	//데이터 타입이 String일때 보통 형변환을 통하여 강제로 바꿔줬어야 했지만 spring에서는 알아서 바꿔줌!!
	//이름이 x인 요청 파라미터 값을 변수에 저장
						
						,@ModelAttribute("mv") MyVo vo 
	//ModelAttribute("모델명")dmf wjrdydgkdu
	//매개변수 값을 지정한 이름으로 모델에 저장(추가)가능
						
						,MyVo v
	//파라미터를 받기 위해서 배치한 매개변수는 자동으로 모델에 추가
	//@ModelAttribute에서 모델명을 생략한 경우, 모델이름은 타입명의 첫글자를 소문자로 변환하여 사용
	
	//사용자가 정의한 객체를 인자로 받는 경우
	//객체의 속성명과 동일한 이름의 파라미터 값을 객체의 속성에 자동 저장
						, Model model) {
		
		
		logger.info("xv: {},y: {}", xv,y);
		logger.info("vo.x: {},vo.y: {}", vo.getX(),vo.getY());
		
		String s = "JSP에서 출력할 문자열";
		
		model.addAttribute("aaa", s );
//		model.addAttribute("sd", vo);
//		model.addAttribute("ww", vo);
		model.addAttribute("mv", vo);
		return "test";
		
	}
	

	
}
