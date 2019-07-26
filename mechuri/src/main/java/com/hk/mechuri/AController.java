package com.hk.mechuri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.list.PageMaker;
import com.hk.mechuri.list.SearchCriteria;
import com.hk.mechuri.mail.MailSend;
import com.hk.mechuri.service.IMembersService;
import com.hk.mechuri.service.RankService;
import com.hk.mechuri.service.iRankService;


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

	@Autowired
	private iRankService RankService;

	@RequestMapping(value = "/signUp.do", method = {RequestMethod.GET})
	public String signUp(Model model) {
		logger.info("회원 추가폼으로 이동 {}.");
		return "signUp";
	}

	@RequestMapping(value = "/signUpBoard.do", method = {RequestMethod.POST})
	public String signUpBoard(Model model, HttpSession session, membersDto dto) {

		logger.info("회원 추가합니다. {}.");
		System.out.println("A컨트롤러에서 출력: ["+dto.getMem_id()+"]");
		System.out.println("에러위치찾기 0");
		boolean isS=MembersService.signUpBoard(dto);
		System.out.println("에러위치찾기 1");
		if(isS) {
			System.out.println("에러위치찾기 2");
			return "redirect:login.do";
		}else {
			System.out.println("에러위치찾기 3");
			model.addAttribute("msg","회원가입 실패");
			return "error";
		}
	}

	@RequestMapping(value= "/memLogin.do", method = RequestMethod.GET)
	public String memLogin() {
		return "memLogin"; //memLogin.jsp로
	}

	@RequestMapping(value= "/login_check.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String login_check(							//spring에선 선언하면 session 객체 만들어줘
			@ModelAttribute membersDto dto, HttpServletRequest request, HttpSession session) { //Model 대신 request param(id,pw)으로 두 번 받아도 돼.
		System.out.println(dto);
		System.out.println(session);

		boolean delflagchk = MembersService.delflagCheck(dto);
		if(delflagchk) {
			boolean result =MembersService.loginCheck(dto, session);
			System.out.println(MembersService);
			ModelAndView mav=new ModelAndView();
			System.out.println(mav);
			if(result) { //로그인 성공
				mav.setViewName("loginresult"); //main.jsp
				mav.addObject("message", "success"); 		

				return "redirect:main.do" ;

			}else { //로그인 실패 
				mav.setViewName("memLogin");
				mav.addObject("message", "error");

			}return "loginerror" ;
		}return "delflagerror";
	}


	@RequestMapping(value= "/logout.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("로그아웃 들어오니?");
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
			return "redirect:login.do";
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
		String content = "<html><b>회원님의 인증 코드는 " + result +" 입니다.</b>"
				+"<br>아래 링크를 누르시면 메추리 홈페이지로 이동합니다."
				+ "<br><a href='http://127.0.0.1:8888/mechuri/main.do'>메추리 홈페이지</a>";
		ms.mailSend(mem_id, title, content);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/idcheck.do", method = {RequestMethod.POST})
	public String idcheck(Model model, String mem_id, membersDto dto) {

		logger.info("아이디 중복체크 {}.");

		dto=MembersService.idcheck(mem_id);
		if(dto==null) {
			return "a";
		}else {
			return "b";
		}
	}
	//  검색기능 Board꺼
	// 글 목록+페이징+검색
	@RequestMapping(value = "/listSearch.do", method=RequestMethod.GET)
	public void listSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, membersDto dto) throws Exception {
		logger.info("리스트 찾기");

		List<productDto> list = RankService.listSearch(scri);
		model.addAttribute("list", list);

		logger.info("리스트 들어왔닝");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		logger.info("scri 잘 들어오닝");
		model.addAttribute("pageMaker", pageMaker);
		logger.info("pageMaker 잘 들어오닝");

	}

	//아이디 찾기(화면이동)
	@RequestMapping(value = "/searchAccount.do" , method=RequestMethod.GET)
	public String searchAccount(){
		logger.info("searchAccount 실행");
		return "searchId";
	}

	//아이디찾기
	@RequestMapping(value = "/searchId.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, String> searchId(Model model, HttpServletRequest req){
		logger.info("searchId 실행");
		String name = req.getParameter("mem_name");
		String phone =req.getParameter("mem_phone");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_name", name);
		map.put("mem_phone", phone);
		logger.info("맵에 들어가니 실행");
		String id = MembersService.memIdSearch(map);
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("resultId", id);
		return resultMap;
	}

	//비밀번호 찾기 페이지로 이동
	@RequestMapping(value="/pwFindForm.do",method={RequestMethod.POST, RequestMethod.GET})
	public String pwFindForm(membersDto dto, Model model) {
		return "pwFindForm";
	}

	//비밀번호 찾기(이메일전송)
	@RequestMapping(value="/pwFind.do",method=RequestMethod.POST)
	public String pwFind(membersDto dto) 
	{
		boolean isS = MembersService.pwFind(dto);

		if(isS)
		{
			return "login";
		}
		else
		{
			return "error";
		}
	}

}		