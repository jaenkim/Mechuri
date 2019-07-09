package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.membersDto;

@Repository
public class MembersDao implements IMembersDao {
	
	private String namespace="com.hk.mechuri.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
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
	/*@Override
	public membersDto memLoginBoard(String mem_id,String mem_pw) {
		 Map<String,Object> map=new HashMap<String, Object>();
	        map.put("id", mem_id);
	        map.put("password", mem_pw);
	     
	        return sqlSession.selectOne("member.password", map);
	       */
	//로그인
	/*@Override
	public membersDto memLoginBoard(membersDto dto) {
		System.out.println(dto +"전달");
		return sqlSession.selectOne(namespace+"memLoginBoard", dto);
	}
	
	@Override
	public int loginChk(String mem_id) 
	{
		return sqlSession.selectOne(namespace+"loginChk",mem_id);*/
}
	

