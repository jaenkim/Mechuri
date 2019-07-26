package com.hk.mechuri.daos;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.replyDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.dtos.tempinfoDto;


@Repository
public class addProductDao {

	
	private String namespace="com.hk.mechuri.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int addProduct(productDto dto) {	//제품 등록 신청
		return sqlSession.insert(namespace+"insertProduct",dto);
		
	}

	public List<productDto> getAllList() { //(제품등록)승인할 목록 가져오기
		return sqlSession.selectList(namespace+"approveProductList");
	}
	
	public List<tempinfoDto> getAllList1() { //(제품수정)승인할 목록 가져오기
		return sqlSession.selectList(namespace+"approveProductList1");
	}
	
	public List<productDto> getProductList(int mem_no) { //자사 제품 목록
		return sqlSession.selectList(namespace+"getProductList",mem_no);
	}
	
	public boolean approveProduct(int product_no) { //제품 등록 승인
		int count= sqlSession.update(namespace+"approveProduct",product_no);
		return count>0?true:false;
	}
	

	public productDto getUpdateProductInfo(int product_no) { //수정할 제품 목록 가져오기
		Map<String, Integer>map = new HashMap<String,Integer>();
		map.put("product_no", product_no);
		return sqlSession.selectOne(namespace+"updateProductInfo",product_no);
	}
	
	
	public tempinfoDto geTempinfo(int tempinfo_no) { 
		return sqlSession.selectOne(namespace+"geTempinfo",tempinfo_no);
	}
	
	public productDto geProduct(int product_no) { 
		return sqlSession.selectOne(namespace+"geProduct",product_no);
	}
	
	
	public boolean approveProduct1(tempinfoDto dto) { //제품 수정 승인
		int count= sqlSession.update(namespace+"approveProduct1",dto);
		int count1=0;
		int count2=0;
		if(count>0) {
			count1 = sqlSession.update(namespace+"approveProduct2",dto);
			if(count1>0) {
			count2 = sqlSession.update(namespace+"productOthersY",dto);
		}
		}
		return count2>0?true:false;
	}

	
	public boolean productdj(int product_no) { //제품 단종처리 dao
		int count= sqlSession.update(namespace+"productdj",product_no);
		return count>0?true:false;
	}
	
	public boolean productdel(int product_no) { //제품 삭제 dao
		int count= sqlSession.delete(namespace+"productdel",product_no);
		if(count>0) { //제품 삭제하고, tempinfo에 있는 제품도 삭제하기
			sqlSession.delete(namespace+"tempinfodel",product_no);
		}
		return count>0?true:false;
	}
	
	
	
	public int tempinfoInsert(tempinfoDto dto) {	//제품 수정 신청 dao
		int count = sqlSession.update(namespace+"productOthersN",dto);
		int count1=0;
		if(count>0) {
			count1 = sqlSession.insert(namespace+"tempinfoInsert",dto);
		}
		return count1;
	
	}
	
	
	public List<boardDto> myboardlist(String mem_nick) { //내가 쓴 커뮤니티 글 목록
		return sqlSession.selectList(namespace+"myboardlist",mem_nick);
	}
	
	public List<reviewDto> myreviewlist(String mem_nick) { //내가 쓴 리뷰 목록
		return sqlSession.selectList(namespace+"myreviewlist",mem_nick);
	}
	
	public List<replyDto> myreplylist(String mem_nick) { //내가 쓴 댓글 목록
		return sqlSession.selectList(namespace+"myreplylist",mem_nick);
	}

	public List<boardDto> mainCommuList() {	//메인 페이지에 최신 커뮤니티글 4개 가져오기
		return sqlSession.selectList(namespace+"mainCommuList");
	}
	
	public List<productDto> mainRankList() {	//메인 페이지에 대분류별 랭킹 1위 제품 가져오기
		return sqlSession.selectList(namespace+"mainRankList");
	}
	
}
