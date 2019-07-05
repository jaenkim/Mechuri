package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.service.IBoardService;
import com.hk.mechuri.service.IMembersService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SController {
	
	private static final Logger logger = LoggerFactory.getLogger(SController.class);
	
	@Autowired
	private IBoardService boardService;
	
	@Autowired
	private IMembersService membersService;
	
	@RequestMapping(value = "/signUp.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String signUp(Locale locale, Model model) {
		logger.info("회원 추가폼으로 이동 {}.", locale);
		return "signUp";
		}
	
	@RequestMapping(value = "/signUpBoard.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String insertBoard(Locale locale, Model model, membersDto dto) {
					
		logger.info("회원 추가합니다. {}.", locale);
		
		boolean isS=membersService.signUpBoard(dto);
		if(isS) {
			return "redirect:main.do";
		}else {
			model.addAttribute("msg", "회원추가실패");
			return "error";
		}	
	}
	@RequestMapping(value = "/memLogin.do", method = RequestMethod.GET)
	public String memLogin(Locale locale, Model model) {
	
		return "memLogin";
	}
	
	@RequestMapping(value = "/compSignUp.do")
	public String compSignUp(Locale locale, Model model) {
	
		return "compSignUp";
	}
	
	@RequestMapping(value = "/addProduct.do")
	public String addProduct(Locale locale, Model model) {
	
		return "addProduct";
	}
	
	@RequestMapping(value = "/testLogin.do")
	public String testLogin(Locale locale, Model model) {
	
		return "testLogin";
	}
	
	//여기부터 랭킹 기능
	@RequestMapping(value = "/boardlist2.do")
	public String boardlist2(Locale locale, Model model) {
		
		List<boardDto> list=boardService.getAllList();
		model.addAttribute("list",list);
		
		return "boardlist2";
	}
	
	@RequestMapping(value = "/boardwrite.do") /*글작성 폼으로 이동*/
	public String boardwrite(Locale locale, Model model) {	
		
		return "insertBoard";
	}
	
	
	@RequestMapping(value = "/insertWrite.do") /*커뮤니티 글 작성*/
	public String insertWrite(Locale locale, Model model, HttpServletRequest request) {	
		logger.info("글 추가하기 {}.", locale);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boardDto dto = new boardDto(title,content);
		model.addAttribute("title",title);
		model.addAttribute("content",content);
		
		
		//파일업로드
		boolean isS = boardService.insertFileInfo(request);
		return "boardlist2";
		
/*		if(isS) {
			return "boardlist2";
		} else {
			logger.info("파일업로드 실패");
			return "boardwrite";
		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
