package com.hk.mechuri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.iRankDao;
import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.productDto;

@Service
public class RankService implements iRankService {
	
	@Autowired
	private iRankDao rankDao;
	
	//전체 상품의 랭링 목록을 출력함
	@Override
	public List<productDto> getAllProductList(){
		return rankDao.getAllProductList();
	}
	
	@Override
	public List<productDto> getFilterProductList(filterDto dto){
		System.out.println("service에서 출력한 10대의 값: ["+dto.getFilter_age10()+"]");
		System.out.println("service에서 출력한 카테고리 대분류대의 값: ["+dto.getFilter_catelname()+"]");
		System.out.println("service에서 출력한 카테고리 소분류대의 값: ["+dto.getFilter_catesname()+"]");
		return rankDao.getFilterProductList(dto);
	}
	
	
	
	
	
}
