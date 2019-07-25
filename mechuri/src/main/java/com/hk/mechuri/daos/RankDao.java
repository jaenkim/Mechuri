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
	
		maap.put("age10",dto.getAge10()==null?"empty":dto.getAge10());
		maap.put("age20",dto.getAge20()==null?"empty":dto.getAge20());
		maap.put("age30",dto.getAge30()==null?"empty":dto.getAge30());
		maap.put("age40",dto.getAge40()==null?"empty":dto.getAge40());
		maap.put("age50",dto.getAge50()==null?"empty":dto.getAge50());
		maap.put("female",dto.getFemale()==null?"empty":dto.getFemale());
		maap.put("male",dto.getMale()==null?"empty":dto.getMale());
		maap.put("catelname",dto.getCatelname()==null?"empty":dto.getCatelname());
		maap.put("catesname",dto.getCatesname()==null?"empty":dto.getCatesname());

		return sqlSession.selectList(namepace+"applyFilter",maap);
	}

	//필터에서 뭣 좀 해보려 한것 
	@Override
	public List<productDto> FilterDao(String[] ageArray, String[] genderArray, String[] cateArray) {
		Map<String,Object> mmap = new HashMap<String,Object>();
//		System.out.println("다오(ageArray) ["+ageArray[0]+"]");
//		System.out.println("다오(genderArray) ["+genderArray[0]+"]");
		mmap.put("ages", ageArray);
		mmap.put("genders", genderArray);
		mmap.put("catelname", cateArray[0]);
		mmap.put("catesname", cateArray[1]);
		return sqlSession.selectList(namepace+"doFilter2",mmap);
	}
		
	
	@Override
	public List<productDto> setFilterProductList(String[] ages, String[] genders, String[] skins, String catelname, String catesname){
		Map<String,Object> mapp = new HashMap<String,Object>();
	
		mapp.put("ages", ages);
		mapp.put("genders", genders);
		mapp.put("skins", skins);
		mapp.put("catelname", catelname==""?null:catelname);
		mapp.put("catesname", catesname==""?null:catesname);
		System.out.println("catelname ["+mapp.get("catelname")+"]");
		System.out.println("catesname ["+mapp.get("catesname")+"]");

	
	return sqlSession.selectList(namepace+"doFilter",mapp);
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

	//리뷰 작성할 때, 작성되는 리뷰의 대상이되는 제품정보를 불러오는 메서드
		@Override
		public productDto getOneProductInfo(int pNo) {
			return sqlSession.selectOne(namepace+"getOneProductInfo", pNo);
		}
		
		//리뷰 작성하는 메서드
		@Override
		public int insertReview(reviewDto dto) {
			Map<String,Object> mmapp = new HashMap<String,Object>();
			mmapp.put("review_membernick", dto.getReview_membernick());
			mmapp.put("review_productno", dto.getReview_productno());
			mmapp.put("review_conts", dto.getReview_conts());
			mmapp.put("review_point", dto.getReview_point());
			mmapp.put("review_originfile", dto.getReview_originfile());
			mmapp.put("review_storedfile", dto.getReview_storedfile());
			mmapp.put("review_filesize", dto.getReview_filesize());
			
			return sqlSession.insert(namepace+"insertReview", mmapp);
		}

		@Override
		public int deleteReview(reviewDto rDDto) {
			return sqlSession.delete(namepace+"deleteReview", rDDto);
		}

		@Override
		public List<productDto> getBrandlist(String product_brand) {
			return sqlSession.selectList(namepace+"brandlist", product_brand);
		}
		
		
		
		
	
}
