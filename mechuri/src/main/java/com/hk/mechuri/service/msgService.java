package com.hk.mechuri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.MessageDao;
import com.hk.mechuri.dtos.msgDto;
import com.hk.mechuri.dtos.productDto;

@Service
public class msgService {

	
	@Autowired
	private MessageDao msgDao;

	public List<msgDto> getAllList(int mem_no) {
		return msgDao.getAllList(mem_no);
	}
	

	public boolean sendMessage2(productDto pdto) {
		return msgDao.sendMessage2(pdto);
		
	}
	
	
}
