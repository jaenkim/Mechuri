package com.hk.mechuri.service;

import java.util.List;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.productDto;

public interface iRankService {

	//전체 제품의 랭링 목록을 출력함
	List<productDto> getAllProductList();
	
	//필터를 적용한 제품의 랭킹 목록을 출력함
	public List<productDto> getFilterProductList(filterDto dto);
	
}