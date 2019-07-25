package com.hk.mechuri.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.list.SearchCriteria;

public interface iRankService {

	//전체 제품의 랭링 목록을 출력함
	List<productDto> getAllProductList();

	//필터를 적용한 제품의 랭킹 목록을 출력함
	List<productDto> setFilterProductList(String[] ages, String[] genders, String[] skins, String catelname, String catesname);
	
	public List<productDto> getFilterProductList(filterDto dto);

	public List<productDto> Filter(String[] ageArray, String[] genderArray, String[] cateArray);
	
	//제품 상세보기를 위한 메서드(4)
	public productDto getDetailProductList(int product_no);
	public reviewDto getDetailPoint(int product_no);
	public List<reviewDto> getProductReview(int product_no);
	public List<ingreDto> getProductIngre(productDto pDto);

	//제품 검색
	List<productDto> listSearch(SearchCriteria scri) throws Exception;
	int countSearch(SearchCriteria scri) throws Exception;

	//리뷰 작성할 때, 작성되는 리뷰의 대상이되는 제품정보를 불러오는 메서드
	productDto getOneProductInfo(int pNo);

	boolean insertReview(HttpServletRequest request, reviewDto rDto);

	int deleteReview(reviewDto rDDto);

	List<productDto> getBrandlist(String brand);

	


}