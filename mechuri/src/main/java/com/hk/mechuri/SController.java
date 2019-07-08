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
	


	//여기부터 커뮤니티 기능
	@RequestMapping(value = "/boardlist2.do") /*커뮤니티리스트*/
	public String boardlist2(Locale locale, Model model,HttpServletRequest request) {
		List<boardDto> list=boardService.getAllList();
		model.addAttribute("list",list);
	//	System.out.println("그림2:["+dto.getBoard_storedfile()+"]");
		return "community/boardlist2";
		
	}
	
	@RequestMapping(value = "/boardwrite.do") /*글작성 폼으로 이동*/
	public String boardwrite(Locale locale, Model model) {	
		return "insertWrite";
	}
	
	
	@RequestMapping(value = "/insertWrite.do") /*커뮤니티 글 작성*/
	public String insertWrite(Locale locale, Model model, HttpServletRequest request) {	
		logger.info("글 추가하기 {}.", locale);
		
		String nick = request.getParameter("nickname");
		String title = request.getParameter("titlename");
		String content = request.getParameter("content");
		
		
		boardDto dto1 = new boardDto(nick,title,content);
		
	
		//파일업로드
		boolean isS = boardService.insertFileInfo(request, dto1);
		
		if(isS) {
			return "redirect:boardlist2.do";
		} else {
			logger.info("파일업로드 실패");
			return "insertWrite";
		}
		
	}
	
	
	@RequestMapping(value = "/boardDetail.do") /*글 상세보기 폼으로 이동*/
	public String boardDetail(Locale locale, Model model, int board_no) {	
		logger.info("게시글 상세보기 {}.", locale);
		
		boardDto dto=boardService.getBoard(board_no);
		model.addAttribute("dto",dto);
		
		return "community/boarddetail";
	}
	
	
	
	@RequestMapping(value = "/boardDelete.do") /*글작성 폼으로 이동*/
	public String boardDelete(Locale locale, Model model, int board_no) {	
		logger.info("상세보기 글 삭제 {}.", locale);	
		
		boolean isS=boardService.delBoard(board_no);
		if(isS) {
			return "redirect:boardlist2.do";
		} else {
			model.addAttribute("msg","글삭제실패");
			return "community/boarddetail";
		}	
	}
	
	
	
	@RequestMapping(value = "/updateForm.do") /*상세글 업데이트폼으로 가기*/
	public String updateForm(Locale locale, Model model,int board_no) {	
		logger.info("게시글 수정하기 폼 이동 {}.", locale);
		
		boardDto dto=boardService.getBoard(board_no);
		model.addAttribute("dto",dto);
		
		return "community/boardupdate";
	}
	
	
	
	@RequestMapping(value = "/updateBoard.do") /*커뮤니티 상세글 업데이트*/
	public String updateBoard(Locale locale, Model model,boardDto dto) {	
		logger.info("게시글 수정하기 {}.", locale);
		
		boolean isS = boardService.updateBoard(dto);
		if(isS) {
			return "redirect:boardDetail.do?board_no="+dto.getBoard_no();
		} else {
			model.addAttribute("msg","글 수정 실패");
			return "community/boardupdate";
		}
	}
	
	
	
	@RequestMapping(value = "/replyboard.do") /*글작성 폼으로 이동*/
	public String replyboard(Locale locale, Model model, boardDto dto,int board_no) {	
		logger.info("답글 추가하기 {}.", locale);
		boolean isS = boardService.replyBoard(dto);
		
		if(isS) {
			return "redirect:boardlist2.do";
		} else {
			return "community/boarddetail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
