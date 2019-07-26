package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public List<boardDto> getAllList(String board_pnum) {	//커뮤니티 리스트 출력
//		Map<String,Integer> mmap = new HashMap<String,Integer>();
//		mmap.put("pnum", pnum);
		return sqlSession.selectList(namespace+"boardlist2",board_pnum);
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
	public int updateBoard(boardDto dto) {
		
		Map<String,Object> mapdetail = new HashMap<String,Object>();
		System.out.println("오리진if 다오업데이트보드로 들어옴");
		mapdetail.put("board_no", dto.getBoard_no());
		mapdetail.put("board_nick", dto.getBoard_nick());
		mapdetail.put("board_title", dto.getBoard_title());
		mapdetail.put("board_conts", dto.getBoard_conts());
		mapdetail.put("board_originfile", dto.getBoard_originfile());
		mapdetail.put("board_storedfile", dto.getBoard_storedfile());
		mapdetail.put("board_filesize", dto.getBoard_filesize());
		
		System.out.println("다오 업데이트보드 board_no=["+dto.getBoard_no()+"]");
		System.out.println("다오 업데이트보드 getBoard_nick=["+dto.getBoard_nick()+"]");
		System.out.println("다오 업데이트보드 board_title=["+dto.getBoard_title()+"]");
		System.out.println("다오 업데이트보드 getBoard_conts=["+dto.getBoard_conts()+"]");
		System.out.println("다오 업데이트보드 getBoard_originfile=["+dto.getBoard_originfile()+"]");
		System.out.println("다오 업데이트보드 getBoard_storedfile=["+dto.getBoard_storedfile()+"]");
		System.out.println("다오 업데이트보드 getBoard_filesize=["+dto.getBoard_filesize()+"]");
		return sqlSession.update(namespace+"updateboard",mapdetail);
		
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
	public List<replyDto> getReplyList(int bno) {
		System.out.println("board_no다오=["+bno);
		return sqlSession.selectList(namespace+"replylist",bno);
	}

	@Override
	public boolean readCount(int board_no) {
		int count=sqlSession.update(namespace+"readcount",board_no);
		return count>0?true:false;
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


	@Override
	public int getPagecount() {
		
		return sqlSession.selectOne(namespace+"pcount");
	}


	@Override
	public boolean delReply(int reply_no) {
		int count=sqlSession.delete(namespace+"delreply",reply_no);
		return count>0?true:false;
	}


}
