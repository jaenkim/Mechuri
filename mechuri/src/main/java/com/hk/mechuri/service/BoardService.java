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

	
	@Override
	public boolean insertBoard(boardDto dto) {
		return boardDao.insertBoard(dto);
		
		
	}

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

	//여기부터 첨부파일
	@Override
	public boolean insertFileInfo(HttpServletRequest request) {
		boolean isS=true;
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
		
		String board_originfile=multiFile.getOriginalFilename();
		String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
		String board_storedfile=creatUUID+board_originfile.substring(board_originfile.lastIndexOf("."));
		int board_filesize=(int)multiFile.getSize();
		
		//상대경로 : 내가 지정하는게 아닌 톰캣이 알아서 경로정해서 저장해줌
		String realPath=request.getSession().getServletContext().getRealPath("upload");
				//절대경로 : 경로를 내가 직접 지정해서 저장해줘야함
		File f=new File("C:/SRCNEW/mechuri/src/main/webapp/upload/"+board_storedfile);
		try {
			multiFile.transferTo(f);
			isS=boardDao.insertFileInfo(new boardDto(board_originfile,board_storedfile,board_filesize))	;			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return isS;
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
