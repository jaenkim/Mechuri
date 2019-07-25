package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.mechuri.dtos.membersDto;


@Repository
public class MembersDao implements IMembersDao {

	private String namespace="com.hk.mechuri.";

	@Autowired
	private SqlSession sqlSession; //의존관계 주입

	@Override
	public boolean signUpBoard(membersDto dto) {
		int count=sqlSession.insert(namespace+"signUpBoard",dto);
		return count>0?true:false;
	}

	@Override
	public boolean compSignUpBoard(membersDto dto) {
		int count=sqlSession.insert(namespace+"compSignUpBoard",dto);
		return count>0?true:false;		
	}
	@Override
	public boolean loginCheck(membersDto dto) {
		String name=sqlSession.selectOne(namespace+"login_check", dto);
		//mapper.xml이름, mapper의 select id!! 
		return (name!=null)? true:false;
	}
	@Override
	public membersDto viewMember(String mem_id) {
		return sqlSession.selectOne(namespace+"viewMember", mem_id);
	}

	//네이버 로그인시 이메일 체크
	@Override
	public membersDto NaverLogCheck(String mem_email) {
		return sqlSession.selectOne(namespace+"naverEmail", mem_email);
	}

	@Override
	public boolean NaverSignUp(String mem_email, String mem_name, String mem_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mem_name", mem_name);
		map.put("mem_id", mem_id);
		map.put("mem_email", mem_email);
		int cnt= sqlSession.insert(namespace+"naverSignUp", map);
		return cnt>0?true:false;
	}
	@Override
	public membersDto idcheck(String mem_id) {
		return sqlSession.selectOne(namespace+"idcheck", mem_id);

	}

	@Override
	public membersDto existNaverId(membersDto mDto) {
		membersDto temp = sqlSession.selectOne(namespace+"existNaver",mDto);

		return temp;
	}

	//네이버 로그인 시 기존 네이버 가입자의 이름과 별명을 가져오는 메서드
	@Override
	public membersDto getNameForNaverMember(String naverEmail) {
		membersDto mdto = sqlSession.selectOne(namespace+"forNaverSession",naverEmail);
		return mdto;
	}

	@Override
	public boolean delflagCheck(membersDto dto) {
		int delflag = sqlSession.selectOne(namespace+"delflagCheck",dto);
		return delflag>0?true:false;
	}

	@Override
	public String memIdSearch(Map<String, String> map) {
		String result = sqlSession.selectOne(namespace+"memIdSearch", map);
		return result;
	}

	//	비밀번호 찾기
	@Override
	public membersDto pwSearch(membersDto dto) {
		return sqlSession.selectOne(namespace+"pwSearch", dto);
	}
	
	//	비밀번호 변경
	@Transactional
	public int updatePw(membersDto dto) {
		return sqlSession.update(namespace+"updatePw", dto);
	}
	
}