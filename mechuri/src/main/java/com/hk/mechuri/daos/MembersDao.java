package com.hk.mechuri.daos;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.membersDto;

@Repository
public class MembersDao implements IMembersDao {
	
	private String namespace="com.hk.mechuri";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public boolean singUp(membersDto dto) {
		int count=sqlSession.insert(namespace+"signUp",dto);
		return count>0?true:false;
		}

}
