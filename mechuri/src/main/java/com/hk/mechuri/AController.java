package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@Autowired
//	private JaavaMailSender MailSender;
	
	//이메일 아이디 중복확인
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String RegisterPost(membersDto dto, Model model, RedirectAttributes rttr, HttpServletRequest request, HttpSession session) throws Exception {
		logger.info("회원가입...");
		logger.info(dto.toString());
		MembersService.create(dto);
		rttr.addFlashAttribute("authmsg" , "가입시 사용한 이메일로 인증해주 3");
		return "redirect:/";
	}
	

	
	@RequestMapping(value = "/memLogin.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String memLogin(membersDto dto,Model model) {
		 logger.info("login폼 이동");
		
		 return "memLogin";
		}
	
	
	/*
	//로그인 안되어있을때
	
		@RequestMapping(value="/memLoginBoard.do",method= {RequestMethod.POST, RequestMethod.GET})
		public String memLoginBoard(Model model, String lo,String mem_id, String mem_pw) {
			model.addAttribute("lo",lo);
			model.addAttribute("pw",mem_pw);
			model.addAttribute("mem_id",mem_id);
			System.out.println("mem_id"+mem_id);
			return "main";
		}
	
		//로그인하고난 후 메인페이지
				@RequestMapping(value="/main.do",method= {RequestMethod.POST, RequestMethod.GET})
				public String index(membersDto dto,HttpSession session, Model model) 
				{

					session.setAttribute("ldto",ldto);
					System.out.println("로그인 된후ldto :"+ldto);
					model.addAttribute("mem_id",membersDto.getMem_id());
					System.out.println("membersDto.getMem_id()"+membersDto.getMem_id());
						return "main";
				}
				//로그인시 아이디 체크	
				@RequestMapping(value="/loginChk.do",method= {RequestMethod.POST, RequestMethod.GET})
				@ResponseBody
				public String loginChk(String mem_id,String mem_pw,Model model) 
				{	
					Map<String, String> map = new HashMap<String, String>();
					map.put("id", mem_id);
					map.put("pw", mem_pw);
					return MembersService.loginChk(map)?"EXIST":"NOPE";
				}	*/
						
	

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