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

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDao boardDao;

	@Override
	public List<boardDto> getAllList() {
		return boardDao.getAllList();
	}

	
 /*  	@Override
	public int insertBoard(boardDto dto) {
		return boardDao.insertBoard(dto);		
	}*/

	@Override
	public boardDto getBoard(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBoard(boardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean muldel(String[] seqs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int replyBoard(boardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean readCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

	//여기부터 첨부파일, 커뮤니티 글 이미지랑 내용 같이보내는거

	@Override
	public boolean insertFileInfo(HttpServletRequest request, boardDto dto) {
		
		String board_title = dto.getBoard_title();
		String board_conts = dto.getBoard_conts();
		System.out.println("서비스에서 타이틀 파라미터 확인 ["+dto.getBoard_title()+"]");
		int isS = 0;
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
//		multi.getParameter("titlename");
//		multi.getParameter("content");
//		System.out.println("11서비스multi["+multiFile+"]");
		String board_originfile=multiFile.getOriginalFilename();
		String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
		String board_storedfile=creatUUID+board_originfile.substring(board_originfile.lastIndexOf("."));
		int board_filesize=(int)multiFile.getSize();
		System.out.println("22서비스multi["+multiFile+"]");
		//상대경로 : 내가 지정하는게 아닌 톰캣이 알아서 경로정해서 저장해줌
		String realPath=request.getSession().getServletContext().getRealPath("upload");
				//절대경로 : 경로를 내가 직접 지정해서 저장해줘야함
		File f=new File("C:/Users/서은영/git/Mechuri/mechuri/src/main/webapp/upload/"+board_storedfile);
		try {
			System.out.println("서비스try문 안 위 multi["+multiFile+"]");
			multiFile.transferTo(f);
//			boardDao.insertBoard(dto);
			System.out.println("서비스에서 확인하는 글제목: ["+board_title+"]");
			System.out.println("서비스에서 확인하는 글내용: ["+board_conts+"]");
			System.out.println("서비스에서 확인하는 원본파일명: ["+board_originfile+"]");
			System.out.println("서비스에서 확인하는 파일저장명: ["+board_storedfile+"]");
			System.out.println("서비스에서 확인하는 파일크기(숫자): ["+board_filesize+"]");
			
			isS=boardDao.insertBoard(new boardDto(board_title,board_conts,board_originfile,board_storedfile,board_filesize));	
			System.out.println("서비스try문 안 아래 multi["+multiFile+"]");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
	
}
