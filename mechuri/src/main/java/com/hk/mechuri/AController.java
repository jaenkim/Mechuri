package com.hk.mechuri;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.mail.MailSend;
import com.hk.mechuri.service.IMembersService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class AController {
	private static final Logger logger = LoggerFactory.getLogger(AController.class);

	@Autowired
	private IMembersService MembersService;
	
	@Autowired
	private IMembersDao MembersDao;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/signUp.do", method = {RequestMethod.GET})
	public String signUp(Model model) {
		logger.info("회원 추가폼으로 이동 {}.");
		return "signUp";
	}

	@RequestMapping(value = "/signUpBoard.do", method = {RequestMethod.POST})
	public String signUpBoard(Model model, membersDto dto) {

		logger.info("회원 추가합니다. {}.");
		
		boolean isS=MembersService.signUpBoard(dto);
		if(isS) {
			return "redirect:main.do";
		}else {
			model.addAttribute("msg","회원가입 실패");
			return "error";
		}
	}
	
	@RequestMapping(value= "/memLogin.do", method = RequestMethod.GET)
	public String memLogin() {
		return "login"; //memLogin.jsp로
	}
	
	@RequestMapping(value= "/login_check.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login_check(							//spring에선 선언하면 session 객체 만들어줘
	@ModelAttribute membersDto dto, HttpServletRequest request, HttpSession session) { //Model 대신 request param(id,pw)으로 두 번 받아도 돼.
		System.out.println(dto);
		System.out.println(session);
		boolean result 
			=MembersService.loginCheck(dto, session);
		System.out.println(MembersService);
		ModelAndView mav=new ModelAndView();
		System.out.println(mav);
		if(result) { //로그인 성공
			mav.setViewName("loginresult"); //main.jsp
			mav.addObject("message", "success"); 
		}else { //로그인 실패 
			mav.setViewName("memLogin");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping(value= "/logout.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}
	
	

	@RequestMapping(value = "/compSignUp.do", method = {RequestMethod.GET})
	public String compSignUp(Model model) {

		return "compSignUp";
	}

	@RequestMapping(value = "/compSignUpBoard.do", method = {RequestMethod.POST})
	public String compSignUpBoard(Model model, membersDto dto) {

		logger.info("회원 추가합니다. {}.");

		boolean isS=MembersService.compSignUpBoard(dto);
		if(isS) {
			return "redirect:main.do";
		}else {
			model.addAttribute("msg","회원가입 실패");
			return "error";
		}
	}

	@RequestMapping(value = "/mail.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer mail(Model model, String mem_id) 
	{
		MailSend ms = new MailSend();
		
		String title = "회원가입 인증코드 발급안내 입니다.";
		
		Random random = new Random();
		int result = random.nextInt(10000)+1000;
		if(result>10000) {
			result = result - 1000;
		}
		String content = "회원님의 인증 코드는 " + result +" 입니다.";
		ms.mailSend(mem_id, title, content);
		
		return result;
	}
	

	}
