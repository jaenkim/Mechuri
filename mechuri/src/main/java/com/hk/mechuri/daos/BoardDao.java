package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.replyDto;

@Repository
public class BoardDao implements IBoardDao {

	//마이바티스객체 
	private String namespace="com.hk.mechuri.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<boardDto> getAllList() {	//커뮤니티 리스트 출력
		return sqlSession.selectList(namespace+"boardlist2");
	}
	

	@Override
	public int insertBoard(boardDto dto) {	//새 글 추가
		Map<String,Object> mapp = new HashMap<String,Object>();
		mapp.put("board_nick", dto.getBoard_nick());
		mapp.put("board_title", dto.getBoard_title());
		mapp.put("board_conts", dto.getBoard_conts());
		mapp.put("board_originfile", dto.getBoard_originfile());
		mapp.put("board_storedfile", dto.getBoard_storedfile());
		mapp.put("board_filesize", dto.getBoard_filesize());
		System.out.println("다오에서 확인하는 글제목: ["+dto.getBoard_title()+"]");
		System.out.println("다오에서 확인하는 글내용: ["+mapp.get("board_conts")+"]");
		System.out.println("다오에서 확인하는 원본파일명: ["+dto.getBoard_originfile()+"]");
		System.out.println("다오에서 확인하는 파일저장명(mapp에 저장된 이름): ["+mapp.get("board_storedfile")+"]");
		System.out.println("다오에서 확인하는 파일크기(숫자): ["+dto.getBoard_filesize()+"]");
		return sqlSession.insert(namespace+"insertBoard",mapp);
	}	
	@Override
	public boolean insertFileInfo(boardDto dto) {
		int count=sqlSession.insert(namespace+"insertBoard",dto);
		return count>0?true:false;
	}

	@Override
	public boardDto getBoard(int board_no) {
		return sqlSession.selectOne(namespace+"getboard",board_no);
	}

	@Override
	public boolean updateBoard(boardDto dto) {
		int count=sqlSession.update(namespace+"updateboard",dto);
		return count>0?true:false;
	}

	@Override
	public boolean delBoard(int board_no) {
		int count=sqlSession.delete(namespace+"delboard",board_no);
		return count>0?true:false;
	}

	@Override
	public int replyUpdate(int board_no) {
		return sqlSession.update(namespace+"replyupdate",board_no);
	}
	@Override
	public int replyInsert(replyDto dto) {
		return sqlSession.insert(namespace+"replyinsert",dto);
	}
	
	@Override
	public List<replyDto> getReplyList() {
		return sqlSession.selectList(namespace+"replylist");
	}

	@Override
	public boolean readCount(int board_no) {
		// TODO Auto-generated method stub
		return false;
	}

//여기부터는 첨부파일


	@Override
	public List<boardDto> getFileList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boardDto getFileInfo(int board_fileno) {
		// TODO Auto-generated method stub
		return null;
	}


}
