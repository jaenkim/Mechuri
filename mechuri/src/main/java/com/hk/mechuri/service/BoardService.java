package com.hk.mechuri.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.mechuri.daos.IBoardDao;
import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.replyDto;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDao boardDao;

	@Override
	public List<boardDto> getAllList(String board_pnum) {
		return boardDao.getAllList(board_pnum);
	}

	
 /*  	@Override
	public int insertBoard(boardDto dto) {
		return boardDao.insertBoard(dto);		
	}*/

	@Override
	public boardDto getBoard(int board_no) {
		return boardDao.getBoard(board_no);
	}

	@Override
	public boolean updateBoard(HttpServletRequest request) {
		
		int isS = 0;

		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
		System.out.println("11서비스multi["+multiFile+"]");
		String board_originfile=multiFile.getOriginalFilename();
		System.out.println("1122서비스origin["+board_originfile+"]");
		if(board_originfile==null||board_originfile=="") {
			System.out.println("if문 안 서비스 업데이트파일-첨부파일 수정 안할 때 ");
			
			isS=boardDao.updateBoard(new boardDto(Integer.parseInt(request.getParameter("board_no")),request.getParameter("writernick"),
					request.getParameter("titlename"),request.getParameter("content")
					,"empty","empty",0
					));	
		
		} else {
			System.out.println("서비스 업데이트 else안");
		
			String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("1122서비스creatUUID["+creatUUID+"]");
			String board_storedfile=creatUUID+board_originfile.substring(board_originfile.lastIndexOf("."));
			System.out.println("1122서비스board_storedfile["+board_storedfile+"]");
			int board_filesize=(int)multiFile.getSize();
			System.out.println("22서비스board_filesize["+board_filesize+"]");
			//상대경로 : 내가 지정하는게 아닌 톰캣이 알아서 경로정해서 저장해줌
			//String realPath=request.getSession().getServletContext().getRealPath("upload");
			//절대경로 : 경로를 내가 직접 지정해서 저장해줘야함
			//File f=new File("C:/Users/82108/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile);//깃에있는 재원언니경로
		//	File f=new File("C:/Users/서은영/git/Mechuri03/mechuri/src/main/webapp/upload/"+board_storedfile); //깃에있는 경로
			//File f=new File("C:/Users/HKEDU/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile); //은영학원컴 깃에있는 경로
			File f=new File("C:/Users/alfk0/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile); //은영학원컴 깃에있는 경로
		
			//File f=new File("C:/SRCNEW02/mechuri2/src/main/webapp/upload/"+board_storedfile);//복사한폴더경로
			try {
				
				multiFile.transferTo(f);
				System.out.println("서비스try문 안 아래isS=["+isS+"]");
				System.out.println("서비스try문 안 아래 board_no=["+multi.getParameter("board_no")+"]");
				System.out.println("서비스try문 안 아래 board_nick=["+multi.getParameter("writernick")+"]");
				System.out.println("서비스try문 안 아래 board_title=["+multi.getParameter("titlename")+"]");
				System.out.println("서비스try문 안 아래 board_conts=["+multi.getParameter("content")+"]");
				System.out.println("서비스try문 안 아래 board_originfile=["+multi.getParameter("board_originfile")+"]");
				System.out.println("서비스try문 안 아래 board_storedfile=["+board_storedfile+"]");
				System.out.println("서비스try문 안 아래 board_storedfile=["+board_originfile+"]");
				System.out.println("서비스try문 안 아래  board_filesize=["+board_filesize+"]");
			
				isS=boardDao.updateBoard(new boardDto(Integer.parseInt(request.getParameter("board_no")),request.getParameter("writernick"),
						request.getParameter("titlename"),request.getParameter("content")

					
						,board_storedfile,board_originfile,board_filesize
						));	

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return isS>0?true:false;
		
		
	}

	@Override
	public boolean delBoard(int board_no) {
		return boardDao.delBoard(board_no);
	}

	@Transactional
	@Override
	public boolean replyBoard(replyDto dto) {
		//boardDao.replyUpdate(dto.getReply_no());
		int count=boardDao.replyInsert(dto);
		return count>0?true:false;
	}
	
	@Override
	public List<replyDto> replyDetail(int board_no) {
		System.out.println("board_no서비스=["+board_no);
		return boardDao.getReplyList(board_no);
	}

	@Override
	public boolean readCount(int board_no) {
		return boardDao.readCount(board_no);
	}

	//여기부터 첨부파일, 커뮤니티 글 이미지랑 내용 같이보내는거

	@Override
	public boolean insertFileInfo(HttpServletRequest request, boardDto dto) {
		
		String board_title = dto.getBoard_title();
		String board_conts = dto.getBoard_conts();
		String board_nick = dto.getBoard_nick();
		System.out.println("서비스에서 타이틀 파라미터 확인 ["+dto.getBoard_title()+"]");
		
		int isS = 0;
		
		
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
		System.out.println("11서비스multi["+multiFile+"]");
		String board_originfile=multiFile.getOriginalFilename();
		System.out.println("1122서비스origin["+board_originfile+"]");
		if(board_originfile=="") {
			System.out.println("서비스insertFileInfo오리진파일 없을 때 여기들어옴 if문 안");
			isS=boardDao.insertBoard(new boardDto(board_nick,board_title,board_conts,"empty","empty",0));
		}else {
			System.out.println("서비스insertFileInfo오리진파일 있을 때 여기들어옴 else문 안");
			String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("1122서비스creatUUID["+creatUUID+"]");
			String board_storedfile=creatUUID+board_originfile.substring(board_originfile.lastIndexOf("."));
			System.out.println("1122서비스board_storedfile["+board_storedfile+"]");
			int board_filesize=(int)multiFile.getSize();
			System.out.println("22서비스board_filesize["+board_filesize+"]");
			//상대경로 : 내가 지정하는게 아닌 톰캣이 알아서 경로정해서 저장해줌
			//String realPath=request.getSession().getServletContext().getRealPath("upload");
			//절대경로 : 경로를 내가 직접 지정해서 저장해줘야함
			//File f=new File("C:/Users/82108/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile);//깃에있는 재원언니경로
			//File f=new File("C:/Users/서은영/git/Mechuri03/mechuri/src/main/webapp/upload/"+board_storedfile);//깃에있는 은영경로
			//File f=new File("C:/SRCNEW02/mechuri2/src/main/webapp/upload/"+board_storedfile);//복사한폴더경로
			//File f=new File("C:/Users/HKEDU/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile); //은영학원컴 깃에있는 경로
			File f=new File("C:/Users/alfk0/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile); //은영학원컴 깃에있는 경로
			
			try {
				System.out.println("서비스try문 안 위 multi["+multiFile+"]");
				multiFile.transferTo(f);
				System.out.println("서비스에서 확인하는 닉네임: ["+board_nick+"]");
				System.out.println("서비스에서 확인하는 글제목: ["+board_title+"]");
				System.out.println("서비스에서 확인하는 글내용: ["+board_conts+"]");
				System.out.println("서비스에서 확인하는 원본파일명: ["+board_originfile+"]");
				System.out.println("서비스에서 확인하는 파일저장명: ["+board_storedfile+"]");
				System.out.println("서비스에서 확인하는 파일크기(숫자): ["+board_filesize+"]");
				
				isS=boardDao.insertBoard(new boardDto(board_nick,board_title,board_conts,board_originfile,board_storedfile,board_filesize));	
				System.out.println("서비스try문 안 아래 multi["+multiFile+"]");
				System.out.println("서비스 try아래2=["+board_storedfile+"]");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isS>0?true:false;
	}

	@Override
	public List<boardDto> getFileList() {
		return boardDao.getFileList();
	}

	@Override
	public boardDto getFileInfo(int board_fileno) {
		return boardDao.getFileInfo(board_fileno);
	}


	@Override
	public int getPcount() {
		return boardDao.getPagecount();
	}


	@Override
	public boolean delReply(int reply_no) {
		return boardDao.delReply(reply_no);
	}


	
	
}
