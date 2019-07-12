package com.hk.mechuri.daos;

import java.util.List;
import java.util.Map;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;

public interface iRankDao {

	//페이지에 제품의 전체 목록을 출력하는 다오
	List<productDto> getAllProductList();

	List<productDto> getFilterProductList(filterDto dto);
	
	productDto getDetailProductList(int product_no);
	
	reviewDto getDetailPoint(int product_no);
	
	List<reviewDto> getProductReview(int product_no);

	List<ingreDto> getProductIngre(productDto pDto);

	List<productDto> FilterDao(String[] ageArray, String[] genderArray, String[] cateArray);

}


//	String ageFilterDao(String[] ageArray);
//
//String genderFilterDao(String[] genderFilter);
//
//String categoryFilterDao(String[] cateArray);