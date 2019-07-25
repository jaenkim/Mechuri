package com.hk.mechuri.daos;

import java.util.List;
import java.util.Map;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.list.SearchCriteria;

public interface iRankDao {
	
	
	//페이지에 제품의 전체 목록을 출력하는 다오
	List<productDto> getAllProductList();

	List<productDto> getFilterProductList(filterDto dto);

	productDto getDetailProductList(int product_no);

	reviewDto getDetailPoint(int product_no);
	
	List<productDto> setFilterProductList(String[] ages, String[] genders, String[] skins, String catelname, String catesname);
	
	List<reviewDto> getProductReview(int product_no);

	List<ingreDto> getProductIngre(productDto pDto);

	List<productDto> FilterDao(String[] ageArray, String[] genderArray, String[] cateArray);

	//여기부터 검색기능~
	List<productDto> listSearch(SearchCriteria srci) throws Exception; //목록+페이징+검색

	int countSearch(SearchCriteria srci); //검색 결과 갯수
	
	//리뷰 작성할 때, 작성되는 리뷰의 대상이되는 제품정보를 불러오는 메서드
	productDto getOneProductInfo(int pNo);

	int insertReview(reviewDto reviewDto);

	int deleteReview(reviewDto rDDto);

	List<productDto> getBrandlist(String brand);

	

}

