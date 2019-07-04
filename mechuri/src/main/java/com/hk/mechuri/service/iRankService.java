package com.hk.mechuri.service;

import java.util.List;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.productDto;

public interface iRankService {

	//전체 상품의 랭링 목록을 출력함
	List<productDto> getAllProductList();

	public List<productDto> getFilterProductList(filterDto dto);
	
}