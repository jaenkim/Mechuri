package com.hk.mechuri.daos;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.membersDto;


@Repository
public class userManageDao {

	
	private String namespace="com.hk.mechuri.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	public List<membersDto> getUserList() { //일반회원 리스트 가져오기
		return sqlSession.selectList(namespace+"getUserList");
	}
	
	public List<membersDto> getComUserList() { //기업회원 리스트 가져오기
		return sqlSession.selectList(namespace+"getComUserList");
	}
	
	public List<membersDto> infoinfo(int mem_no) { //회원 정보 리스트(관리자메뉴에서 보는) 가져오기
		return sqlSession.selectList(namespace+"infoinfo",mem_no);
	}
	
	public boolean userdel(int mem_no) { //회원삭제하기
		int count= sqlSession.delete(namespace+"userdel",mem_no);
		return count>0?true:false;
	}
	
	public boolean compAppr(int mem_no) { //기업회원삭제하기
		int count= sqlSession.update(namespace+"compAppr",mem_no);
		return count>0?true:false;
	}
	
	public List<membersDto> comInfo(int mem_no) { //내 정보 가져오기(기업)
		return sqlSession.selectList(namespace+"comInfo",mem_no);
	}
	
	public boolean comtal(int mem_no) { //기업회원 탈퇴하기(실제탈퇴X,탈퇴 플래그만 바꿈)
		int count= sqlSession.delete(namespace+"comtal",mem_no);
		return count>0?true:false;
	}
	
	
	
	//dto.getMem_brand()==null || dto.getMem_email()==null || dto.getMem_post()==null || dto.getMem_addr1()==null || dto.getMem_addr2() ==null || 
	public boolean infoUpdate(membersDto dto) { //회원 정보 수정하기
		if(dto.getMem_homepage()==null || dto.getMem_homepage()=="0") { //일반회원
			dto.setMem_brand("0");
			dto.setMem_email("0");
			dto.setMem_post("0");
			dto.setMem_addr1("0");
			dto.setMem_addr2("0");
			dto.setMem_homepage("0");
		}else if(dto.getMem_nick()==null ||dto.getMem_nick()=="0" ) { //기업회원
			dto.setMem_nick("0");
		}
		int count= sqlSession.update(namespace+"infoUpdate",dto);
		return count>0?true:false;
	}
	
	public List<membersDto> userInfo(int mem_no) { //내 정보 가져오기(일반회원)
		return sqlSession.selectList(namespace+"userInfo",mem_no);
	}
	
}
