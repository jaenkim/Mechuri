package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.daos.MembersDao;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.service.IMembersService;
import com.hk.mechuri.service.MembersService;

import sun.print.resources.serviceui;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AController {
	private static final Logger logger = LoggerFactory.getLogger(AController.class);
	
	@Autowired
	private IMembersService membersService;
	
	@RequestMapping(value = "/signUp.do", method = {RequestMethod.GET})
	public String signUp(Model model) {
		logger.info("회원 추가폼으로 이동 {}.");
		return "signUp";
		}

	@RequestMapping(value = "/signUpBoard.do", method = {RequestMethod.POST})
	public String signUpBoard(Model model, membersDto dto) {
					
		logger.info("회원 추가합니다. {}.");
		
		boolean isS=membersService.signUpBoard(dto);
		if(isS) {
			return "redirect:main.do";
		}else {
			model.addAttribute("msg","회원가입 실패");
			return "error";
		}
	}
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/memLogin.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String memLogin() {
		 logger.info("login폼 이동");
		
		 return "memLogin";
		}
	
	/*@RequestMapping(value = "/memLoginBoard.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String memLoginBoard(membersDto dto, HttpServletRequest request, HttpSession session, Model model){
		 logger.info("login 한다!");
		
		 String url = "";
		 MembersDao dao = sqlSession.getMapper(MembersDao.class);
		 
		 if (dao.memLoginBoard(dto)==null){
			 //로그인 실패 시 다시 로그인 화면으로
			 url = "memLogin";
			 String msg = "로그인 실패하였습니다";
			 model.addAttribute("msg", msg);
			 return url;
		 }
		 else if (dao.memLoginBoard(dto)!=null){
			 //로그인 성공시 로그인 메인화면으로
			 dto = dao.memLoginBoard
		 }
	}*/
		 
	@RequestMapping(value = "/compSignUp.do", method = {RequestMethod.GET})
	public String compSignUp(Model model) {
	
		return "compSignUp";
	}
	
	@RequestMapping(value = "/compSignUpBoard.do", method = {RequestMethod.POST})
	public String compSignUpBoard(Model model, membersDto dto) {
					
		logger.info("회원 추가합니다. {}.");
		
		boolean isS=membersService.compSignUpBoard(dto);
		if(isS) {
			return "redirect:main.do";
		}else {
			model.addAttribute("msg","회원가입 실패");
			return "error";
		}
	}
	
	/*@RequestMapping(value = "/callback.do")
	public String callback(Model model) {
		return "callback";
	}*/
	
	@RequestMapping(value = "/groupbuying.do", method = RequestMethod.GET)
	public String groupbuying(Model model) {
	
		return "groupbuying";
	}
	
	@RequestMapping(value = "/groupbuyingContents.do", method = RequestMethod.GET)
	public String groupbuyingContents(Model model) {
	
		return "groupbuyingContents";
	}
	@RequestMapping(value = "/groupbuyingContents2.do", method = RequestMethod.GET)
	public String groupbuyingContents2(Model model) {
	
		return "groupbuyingContents2";
	}
	@RequestMapping(value = "/groupbuyingContents3.do", method = RequestMethod.GET)
	public String groupbuyingContents3(Model model) {
	
		return "groupbuyingContents3";
	}
	
	@RequestMapping(value = "/groupbuyingContents4.do", method = RequestMethod.GET)
	public String groupbuyingContents4(Model model) {
	
		return "groupbuyingContents4";
	}
	@RequestMapping(value = "/groupbuyingContents5.do", method = RequestMethod.GET)
	public String groupbuyingContents5(Model model) {
	
		return "groupbuyingContents5";
	}
	@RequestMapping(value = "/groupbuyingContents6.do", method = RequestMethod.GET)
	public String groupbuyingContents6(Model model) {
	
		return "groupbuyingContents6";
	}
	@RequestMapping(value = "/groupbuyingContents7.do", method = RequestMethod.GET)
	public String groupbuyingContents7(Model model) {
	
		return "groupbuyingContents7";
	}
	@RequestMapping(value = "/groupbuyingContents8.do", method = RequestMethod.GET)
	public String groupbuyingContents8(Model model) {
		System.out.println("test");
		return "groupbuyingContents8";
	}
}	