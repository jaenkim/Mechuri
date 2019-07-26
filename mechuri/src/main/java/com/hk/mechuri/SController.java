package com.hk.mechuri;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.replyDto;
import com.hk.mechuri.service.IBoardService;

@Controller
public class SController {
	
private static final Logger logger = LoggerFactory.getLogger(SController.class);
	
	@Autowired
	private IBoardService boardService;

	//여기부터 커뮤니티 기능                    
	@RequestMapping(value = "/boardlist2.do") /*커뮤니티리스트*/
	public String boardlist2(HttpSession session,Locale locale, Model model,HttpServletRequest request) {
		String loginInfo = (String)session.getAttribute("mem_name");  //세션에서 일반회원 로그인정보 꺼내기
		String naverLoginInfo = (String)session.getAttribute("naverEmail");  //세션에서 네이버 일반회원 로그인정보 꺼내기
		if((loginInfo==null || loginInfo=="") && (naverLoginInfo==null || naverLoginInfo=="")) { //로그인 안했으면 commuError.jsp로 보내기
			return "commuError";
		}else {
		
			String board_pnum = request.getParameter("board_pnum");  //해당 페이지 갖고옴
			System.out.println("board_pnum=["+board_pnum+"]");
			session = request.getSession();//세션생성
			session.setAttribute("board_pnum", board_pnum);//해당페이지 세션에 넣음
			//request.getSession().removeAttribute("readcount");
			if(board_pnum == null ||board_pnum == "") {  //로그인 후 커뮤니티 1페이지로 들어오나 클릭한 기록이 없어null인 상태임, null처리위한if문
				board_pnum="1";//null일 때 1페이지로 기본세팅
				List<boardDto> list=boardService.getAllList(board_pnum); 
				int pcount = boardService.getPcount(); //총 페이지 수			
				model.addAttribute("list",list);
				model.addAttribute("pcount",pcount);
				
			} else {
				
			//pnum="1";//1페이지로 기본세팅
			List<boardDto> list=boardService.getAllList(board_pnum);
			int pcount = boardService.getPcount(); //총 페이지 수	
			
			System.out.println("최신글 뉴=["+list.get(0).getBoard_new()+"]");
			
			model.addAttribute("list",list);
			System.out.println("pcount=["+pcount+"]");
			model.addAttribute("pcount",pcount);
			}
		}
		return "community/boardlist2";
	}
	
	@RequestMapping(value = "/boardwrite.do") /*글작성 폼으로 이동*/
	public String boardwrite(HttpSession session,Locale locale, Model model) {	
		String mem_nick = (String)session.getAttribute("mem_nick");//세션에 담긴 닉 
		String loginInfo = (String)session.getAttribute("mem_name");
		String naverLoginInfo = (String)session.getAttribute("naverEmail");
		String status = (String)session.getAttribute("mem_status");
		
		if(status.equals("C")|| status==null) {//기업회원 세션체크
			return "youcannotwriteboard";
		}else{
		
		if((loginInfo==null || loginInfo=="") && (naverLoginInfo==null || naverLoginInfo=="")) {
			return "commuError";
		}else {
			return "community/boardwrite";
		}
	}
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
		System.out.println("isS=["+isS+"]");
		if(isS) {
			return "redirect:boardlist2.do";
		} else {
			System.out.println("글작성을 실패하였습니다.");
			return "redirect:boardwrite.do";
		}
		
	}
	
	
	@RequestMapping(value = "/boardDetail.do") /*글 상세보기 폼으로 이동*/
	public String boardDetail(HttpServletRequest request,Locale locale, Model model, Integer board_no,HttpSession session, Integer reply_no) {	
		logger.info("게시글 상세보기 {}.", locale);
		System.out.println("board_no["+board_no+"]");
		//String pnum = request.getParameter("pnum");
		
		String loginInfo = (String)session.getAttribute("mem_name");  //세션에서 일반회원 로그인정보 꺼내기
		String naverLoginInfo = (String)session.getAttribute("naverEmail");  //세션에서 네이버 일반회원 로그인정보 꺼내기
		if((loginInfo==null || loginInfo=="") && (naverLoginInfo==null || naverLoginInfo=="")) { //로그인 안했으면 commuError.jsp로 보내기
			return "commuError";
		}else {
		
		String bPnum = (String)request.getSession().getAttribute("board_pnum");//세션에서 현재페이지 꺼내기
		String rCount = (String)request.getSession().getAttribute("readcount");//세션에서 카운트  꺼내기
		
/*		if(rCount==null) {
			boardService.readCount(board_no);
			request.getSession().setAttribute("readcount", board_no+"");
		} else {
			
		}*/
		
		boardDto dto=boardService.getBoard(board_no); //게시글
		List<replyDto> replylist = boardService.replyDetail(reply_no); //해당 게시글의 댓글
		
		System.out.println("reply_nick=["+dto.getBoard_nick()+"]");
		model.addAttribute("dto",dto); //게시글 화면출력
		model.addAttribute("replylist",replylist); //댓글화면출력
		
		
		return "community/boarddetail";
	}
	}
	
	
	@RequestMapping(value = "/boardDelete.do") /* 삭제 */
	public String boardDelete(HttpSession session,Locale locale, Model model, int board_no) {	
		logger.info("상세보기 글 삭제 {}.", locale);	
		boolean isS;
		
		String myLogin = (String)session.getAttribute("mem_name");
		String myNaverLogin = (String)session.getAttribute("naverEmail");
		
		isS=boardService.delBoard(board_no);

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
		System.out.println("업데이트 컨트롤러 board_no=["+board_no+"]");
		boardDto dto=boardService.getBoard(board_no);
		model.addAttribute("dto",dto);
		
		return "community/boardupdate";
	}
	
	
	
	@RequestMapping(value = "/updateBoard.do") /*커뮤니티 상세글 업데이트*/
	public String updateBoard(HttpServletRequest request, Locale locale, Model model,boardDto dto) {	
		logger.info("게시글 수정하기 {}.", locale);
		
		System.out.println("컨트롤러업데이트보드리쿼스트=["+request+"");
		boolean isS = boardService.updateBoard(request);
		System.out.println("컨트롤러업데이트[="+isS+"]");
		if(isS) {
			System.out.println("컨트롤러업데이트IF안[-"+isS+"]");
			return "redirect:boardDetail.do?board_no="+dto.getBoard_no();
			
		} else {
			model.addAttribute("msg","글 수정 실패");
			return "community/boardupdate";
		}
	}
	
	
	
	@RequestMapping(value = "/replyboard.do") /*댓글 추가작업 컨트롤러*/
	public String replyboard(HttpServletRequest request,Locale locale, Model model, replyDto dto,Integer reply_no,Integer board_no) {	
		logger.info("답글 추가하기 {}.", locale);
		
		dto.setReply_nick(request.getParameter("reply_nick"));
		dto.setReply_conts(request.getParameter("reply_contents"));
		dto.setReply_communo(board_no);
		System.out.println("댓글 글번호 컨트롤러 isS위=["+dto.getReply_communo()+"]");
		boolean isS = boardService.replyBoard(dto);
		System.out.println("댓글 글번호 컨트롤러 isS아래=["+dto.getReply_communo()+"]");
		if(isS) {
			System.out.println("댓글 글번호 컨트롤러 IF안=["+dto.getReply_communo()+"]");
			return "redirect:boardDetail.do?board_no="+board_no;
		} else {
			return "community/boarddetail";
		}
	}
	
	
	
	@RequestMapping(value = "/replyDelete.do") /* 댓글 삭제 */
	public String replyDelete(HttpSession session,Locale locale, Model model, Integer board_no) {	
		logger.info("상세보기 글 삭제 {}.", locale);	
		boolean isS;
		
		String myLogin = (String)session.getAttribute("mem_name");
		String myNaverLogin = (String)session.getAttribute("naverEmail");
		
		isS=boardService.delReply(board_no);

		if(isS) {
			return "redirect:boardDetail.do?board_no="+board_no;
		} else {
			model.addAttribute("msg","글삭제실패");
			return "community/boarddetail";
		}	
	}

	
	
	
	
	
	
	
}
