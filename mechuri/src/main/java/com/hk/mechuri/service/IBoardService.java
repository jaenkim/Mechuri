package com.hk.mechuri.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hk.mechuri.dtos.boardDto;


public interface IBoardService {
	
	public List<boardDto> getAllList();
	
	public boolean insertBoard(boardDto dto);
	
	public boardDto getBoard(int no);
	
	public boolean updateBoard(boardDto dto);

	public boolean muldel(String[] seqs);
	
	public int replyBoard(boardDto dto);
	
	public boolean readCount(int seq);
	
	
	//여기부터 파일 업로드
	public boolean insertFileInfo(HttpServletRequest request);
		
	public List<boardDto> getFileList();
		
	public boardDto getFileInfo (int board_fileno);
	
}
