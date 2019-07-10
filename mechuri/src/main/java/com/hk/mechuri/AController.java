package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.daos.MembersDao;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.service.IMembersService;
import com.hk.mechuri.service.MembersService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class AController {
	private static final Logger logger = LoggerFactory.getLogger(AController.class);

	@Autowired
	private IMembersService MembersService;
	private IMembersDao membersDao;

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
		return "memLogin"; //memLogin.jsp로
	}
	
	@RequestMapping(value= "/login_check.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login_check(							//spring에선 선언하면 session 객체 만들어줘
	@ModelAttribute membersDto dto, HttpServletRequest request, HttpSession session) { //Model 대신 request param(id,pw)으로 두 번 받아도 돼.
		boolean result 
			=MembersService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) { //로그인 성공
			mav.setViewName("Header"); //Header.jsp
			mav.addObject("message", "success"); 
		}else { //로그인 실패 
			mav.setViewName("memLogin");
			mav.addObject("message", "error");
		}
		return mav;
	}
	

/*	@RequestMapping(value = "/memLoginBoard.do", method = RequestMethod.POST)
	public ModelAndView memLoginBoard(HttpSession session) {
		
		ModelAndView mav= new ModelAndView();
		String member_id = (String) session.getAttribute("id");
		if(member_id!=null) {
			mav.setViewName("redirect:/main.do");
			return mav;
		}
		mav.setViewName("/memLoginBoard");
		return mav;
	}*/
	
	
	
	
	
	
	
	//로그인

	/*@RequestMapping(value = "/memLogin.do", method = {RequestMethod.GET})
	public String memLogin(Model model) {
		logger.info("로그인폼으로 이동 {}.");
		return "memLogin";
	}

	@RequestMapping(value = "/memLoginBoard.do", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView memLoginBoard(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		logger.info("들어온다 {}.");
		//세션정보가 null이 아닐 때
		if (request.getSession().getAttribute("loginInfo") != null)
		{
			String msg = "이미 로그인된 상태입닌다.";
			mav.addObject("msg", msg);
			mav.setViewName("loginSuccess");
			
		}
		else
		{
			mav.setViewName("memLogin.do");
			
		}
		return mav;
	}

	@RequestMapping(value="/loginTry.do", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginTry(HttpServletRequest request,Map<String, Object> map ) throws Exception {
		ModelAndView mav = new ModelAndView("loginSuccess");

		Map<String, Object> map = MembersService.selectUserInfo();

		//로그인 정보가 있다면 로그인
		if (map == null)
		{
			mav.addObject("msg", "로그인에 실패하였습니다.");
		}
		else
		{
			request.getSession().setAttribute("loginInfo", map);
			request.getSession().setMaxInactiveInterval(60*30);

			mav.addObject("msg","로그인에 성공하였습니다.");
		}
		return mav;
	}*/

	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		//	        session.invalidate();
		session.removeAttribute("userid");
		return "redirect:memLogin.do";

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