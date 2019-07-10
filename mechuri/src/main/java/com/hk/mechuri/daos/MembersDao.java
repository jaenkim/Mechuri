package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		String name=sqlSession.selectOne("sqls.login_check", dto);
										//mapper.xml이름, mapper의 select id!! 
		return (name==null)? true:false;
	}


	/*@Override
	public Map<String, Object> selectUserInfo(Map<String, Object>map) throws Exception {
		return (Map<String, Object>)selectOne("Members.selectUserInfo", map);
	}

	private Map<String, Object> selectOne(String string, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public membersDto get(membersDto dto) {
		return sqlSession.selectOne(namespace+"memLogin",dto);
	}*/
}