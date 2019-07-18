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

	List<reviewDto> getProductReview(int product_no);

	List<ingreDto> getProductIngre(productDto pDto);

	List<productDto> FilterDao(String[] ageArray, String[] genderArray, String[] cateArray);

	//여기부터 검색기능~
	List<productDto> listSearch(SearchCriteria srci) throws Exception; //목록+페이징+검색

	int countSearch(SearchCriteria srci); //검색 결과 갯수
}


//	String ageFilterDao(String[] ageArray);
//
//String genderFilterDao(String[] genderFilter);
//
//String categoryFilterDao(String[] cateArray);