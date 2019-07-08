package com.hk.mechuri.daos;

import java.util.List;

import com.hk.mechuri.dtos.boardDto;

public interface IBoardDao {

	public List<boardDto> getAllList();
	//커뮤니티 리스트 출력
	
	
	public int insertBoard(boardDto dto);
	//새 글 추가: insert문, 결과값 반환x, 파라미터: id,title,content

	
	public boardDto getBoard(int board_no);
	//글 상세보기: select문, 결과: DTO, 파라미터: seq
	
	
	public boolean updateBoard(boardDto dto);
	//글 수정하기: update문, 결과:x, 파라미터: title,content,seq

	
	public boolean delBoard(int board_no);
	//글 삭제하기(글 여러개, 글 한개 둘 다 기능 구현):update문 날릴꺼임, 결과x, 파라미터:seqs(seq여러개라 배열로 넘어갈꺼임)
	
	
	//답글달기(여기서 트랜잭션 처리를 해야함,update문, insert문 -->한 번 요청에 두 개의 작업 실행 그러므로 트랜잭션 처리 필요
	//파라미터 : id, title, content, 부모의 seq도 필요
	public int replyUpdate(int board_no);
	public int replyInsert(boardDto dto);
	//public boolean replyBoard(AnsDto dto); JSP서블릿 MVC2버전
	
	public boolean readCount(int board_no);
	//조회수 증가하기: update문, 결과:x, 파라미터:해당되는 아이의 seq
	
	
	//여기부터 파일 업로드
	public boolean insertFileInfo(boardDto dto);
	
	public List<boardDto> getFileList();
	
	public boardDto getFileInfo (int board_fileno);
	
	
	
	
	
	
}
