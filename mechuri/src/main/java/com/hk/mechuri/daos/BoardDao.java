package com.hk.mechuri.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.boardDto;

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
	public boolean insertBoard(boardDto dto) {	//새 글 추가
		int count=sqlSession.insert(namespace+"boardwrite",dto);
		return count>0?true:false;
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
	public int replyUpdate(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replyInsert(boardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean readCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

//여기부터는 첨부파일
	@Override
	public boolean insertFileInfo(boardDto dto) {
		int count=sqlSession.insert(namespace+"insertfile",dto);
		return false;
	}


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
