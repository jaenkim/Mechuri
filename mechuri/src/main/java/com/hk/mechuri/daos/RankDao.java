package com.hk.mechuri.daos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.list.SearchCriteria;


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

		maap.put("filter_age10",dto.getFilter_age10()==null?"empty":dto.getFilter_age10());
		maap.put("filter_age20",dto.getFilter_age20()==null?"empty":dto.getFilter_age20());
		maap.put("filter_age30",dto.getFilter_age30()==null?"empty":dto.getFilter_age30());
		maap.put("filter_age40",dto.getFilter_age40()==null?"empty":dto.getFilter_age40());
		maap.put("filter_age50",dto.getFilter_age50()==null?"empty":dto.getFilter_age50());
		maap.put("filter_genderF",dto.getFilter_genderF()==null?"empty":dto.getFilter_genderF());
		maap.put("filter_genderM",dto.getFilter_genderM()==null?"empty":dto.getFilter_genderM());
		maap.put("filter_catelname",dto.getFilter_catelname()==null?"empty":dto.getFilter_catelname());
		maap.put("filter_catesname",dto.getFilter_catesname()==null?"empty":dto.getFilter_catesname());

		return sqlSession.selectList(namepace+"applyFilter",maap);
	}

	@Override
	public List<productDto> FilterDao(String[] ageArray, String[] genderArray, String[] cateArray) {
		Map<String,String[]> mmap = new HashMap<String,String[]>();
		//		System.out.println("다오(ageArray) ["+ageArray[0]+"]");
		//		System.out.println("다오(genderArray) ["+genderArray[0]+"]");
		mmap.put("ages", ageArray);
		mmap.put("genders", genderArray);
		return sqlSession.selectList(namepace+"applyFilter",mmap);
	}

	@Override
	public productDto getDetailProductList(int product_no) {

		System.out.println("다오의 제품상세보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return sqlSession.selectOne(namepace+"productDetail", product_no);
	}
	@Override
	public reviewDto getDetailPoint(int product_no) {

		System.out.println("다오의 제품상세보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return sqlSession.selectOne(namepace+"reviewDetailPoint", product_no);
	}
	@Override
	public List<reviewDto> getProductReview(int product_no) {
		System.out.println("다오의 리뷰보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return sqlSession.selectList(namepace+"productReview", product_no);
	}

	@Override
	public List<ingreDto> getProductIngre(productDto pDto) {
		int product_no = pDto.getProduct_no();
		String ingre = pDto.getProduct_ingre();

		String[] ingreArray = ingre.split(",");

		Map<String,String[]> mapp = new HashMap<String,String[]>();

		mapp.put("product_ingre", ingreArray);
		//		mapp.put("product_no", product_no);

		return sqlSession.selectList(namepace+"productIngre",mapp);
	}

	//여기부터 검색

	@Override
	public List<productDto> listSearch(SearchCriteria scri) throws Exception{ //목록+페이징+검색
		return sqlSession.selectList(namepace +"listSearch", scri);
	}

	@Override
	public int countSearch(SearchCriteria scri){ //검색 결과 갯수
		return sqlSession.selectOne(namepace +"countSearch", scri);
	}	

}
