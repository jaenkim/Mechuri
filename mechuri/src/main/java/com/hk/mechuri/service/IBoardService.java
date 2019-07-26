package com.hk.mechuri.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.replyDto;


public interface IBoardService {
	
	public List<boardDto> getAllList(String board_pnum);
	
	/*public int insertBoard(boardDto dto);*/
	public boolean insertFileInfo(HttpServletRequest request,boardDto dto);
	
	public boardDto getBoard(int board_no);
	
	public boolean updateBoard(HttpServletRequest request);

	public boolean delBoard(int board_no);
	
	public boolean replyBoard(replyDto dto);
	public List<replyDto> replyDetail(int board_no);
	
	public boolean readCount(int board_no);
	
	
	//여기부터 파일 업로드
	public List<boardDto> getFileList();
		
	public boardDto getFileInfo (int board_fileno);
	
	public int getPcount();

	public boolean delReply(int reply_no);
	
	
	
}
