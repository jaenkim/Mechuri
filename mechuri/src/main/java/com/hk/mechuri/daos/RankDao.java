package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;


/**
 * @author 82108
 *
 */
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

	@Override
	public List<productDto> getFilterProductList(filterDto dto) {
		//dto에 값이 담겨있는 걸 꺼내서
		Map<String,String> maap = new HashMap<String,String>();
	
		maap.put("filter_age10",dto.getFilter_age10()==null?"":dto.getFilter_age10());
		maap.put("filter_age20",dto.getFilter_age20()==null?"":dto.getFilter_age20());
		maap.put("filter_age30",dto.getFilter_age30()==null?"":dto.getFilter_age30());
		maap.put("filter_age40",dto.getFilter_age40()==null?"":dto.getFilter_age40());
		maap.put("filter_age50",dto.getFilter_age50()==null?"":dto.getFilter_age50());
		maap.put("filter_genderF",dto.getFilter_genderF()==null?"":dto.getFilter_genderF());
		maap.put("filter_genderM",dto.getFilter_genderM()==null?"":dto.getFilter_genderM());
		maap.put("filter_catelname",dto.getFilter_catelname()==null?"":dto.getFilter_catelname());
		maap.put("filter_catesname",dto.getFilter_catesname()==null?"":dto.getFilter_catesname());
		return sqlSession.selectList(namepace+"filterdlist",maap);
	}

//	maap.put("filter_age10",dto.getFilter_age10());
//	maap.put("filter_age20",dto.getFilter_age20());
//	maap.put("filter_age30",dto.getFilter_age30());
//	maap.put("filter_age40",dto.getFilter_age40());
//	maap.put("filter_age50",dto.getFilter_age50());
//	maap.put("filter_genderF",dto.getFilter_genderF());
//	maap.put("filter_genderM",dto.getFilter_genderM());
//	maap.put("filter_catelname",dto.getFilter_catelname());
//	maap.put("filter_catesname",dto.getFilter_catesname());
	



//	System.out.println("다오에서 출력 10대의 값이 들어왔는지? ["+dto.getFilter_age10()+"]");
//	System.out.println("다오에서 출력 30대의 값이 들어왔는지? ["+dto.getFilter_age30()+"]");
//	System.out.println("다오에서 출력 카테고리 대분류의 값이 들어왔는지? ["+dto.getFilter_catelname()+"]");
//	System.out.println("다오에서 출력 카테고리 소분류 값이 들어왔는지? ["+dto.getFilter_catesname()+"]");
	
	@Transactional
	@Override
	public List<productDto> getDetailProductList(int product_no) {
		System.out.println("다오의 제품상세보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return sqlSession.selectOne(namepace+"productDetail");
	}

	@Override
	public List<reviewDto> getProductReview(int product_no) {
		System.out.println("다오의 리뷰 전체보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return sqlSession.selectList(namepace+"productReview");
	}

	
	
	
	
}
