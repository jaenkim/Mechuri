package com.hk.mechuri.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.productDto;


@Repository
public class RankDao implements iRankDao {
	
	//myBatis 사용하기 위해 namespace 준비 '3'
	private String namepace="com.hk.mechuri.";

	@Autowired //application-context.xml에 빈 생성해놓은 sqlSession 가져와서 의존관계를 설정
	private SqlSessionTemplate sqlSession;
	
	//페이지에 제품의 전체 목록을 출력하는 다오

	@Override
	public List<productDto> getAllProductList() {
		return sqlSession.selectList(namepace+"productlist");
	}
	
	
	
	
	
	
	
}
