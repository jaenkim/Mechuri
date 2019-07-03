package com.hk.mechuri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.iRankDao;
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
	
	
	
	
	
	
}
