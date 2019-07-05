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
	public String signUp(membersDto dto, Locale locale, Model model) {
		boolean isS=membersService.singUp(dto);
		if(isS) {
			return "ranking/main";
		}else {
			model.addAttribute("msg","회원가입 실패");
			return "error";
		}

	}

	
	//여기부터 커뮤니티 기능
	@RequestMapping(value = "/boardlist2.do") /*커뮤니티리스트*/
	public String boardlist2(Locale locale, Model model) {
		
		List<boardDto> list=boardService.getAllList();
		model.addAttribute("list",list);
		
		return "boardlist2";
	}
	
	@RequestMapping(value = "/boardwrite.do") /*글작성 폼으로 이동*/
	public String boardwrite(Locale locale, Model model) {	
		
		return "insertWrite";
	}
	
	
	@RequestMapping(value = "/insertWrite.do") /*커뮤니티 글 작성*/
	public String insertWrite(Locale locale, Model model, HttpServletRequest request, boardDto dto) {	
		logger.info("글 추가하기 {}.", locale);
		
		String title = request.getParameter("titlename");
		String content = request.getParameter("content");
		
		boardDto dto1 = new boardDto(title,content);
		/*model.addAttribute("titlename",titlename);
		model.addAttribute("content",content); 얘는 화면에 보여줄 때만 필요한애 지금필요x
		System.out.println( "title:["+request.getParameter("titlename")+"]");
		System.out.println( "content:["+request.getParameter("content")+"]");*/
		
		//파일업로드
		boolean isS = boardService.insertFileInfo(request, dto1);
		
		
		if(isS) {
			return "community/boardlist2";
		} else {
			logger.info("파일업로드 실패");
			return "insertWrite";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
