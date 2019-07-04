package com.hk.mechuri.daos;

import java.util.List;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.productDto;

public interface iRankDao {

	//페이지에 제품의 전체 목록을 출력하는 다오
	List<productDto> getAllProductList();

	List<productDto> getFilterProductList(filterDto dto);

}