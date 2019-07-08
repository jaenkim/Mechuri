package com.hk.mechuri.service;

import java.util.List;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;

public interface iRankService {

	//전체 제품의 랭링 목록을 출력함
	List<productDto> getAllProductList();

	//정렬
	public List<productDto> getAllProductListbyHighprice();	//높은 가격순
	public List<productDto> getAllProductListbyLowprice();		//낮은 가격순
	public List<productDto> getAllProductListbyASCname();	//이름순
	public List<productDto> getAllProductListbyMaxReview();	//리뷰 많은순
	public List<productDto> getAllProductListbyMinReview();	//리뷰 적은순

	//필터를 적용한 제품의 랭킹 목록을 출력함
	public List<productDto> getFilterProductList(filterDto dto);

	//
	public productDto getDetailProductList(int product_no);

	public reviewDto getDetailPoint(int product_no);
	
	public List<reviewDto> getProductReview(int product_no);


}