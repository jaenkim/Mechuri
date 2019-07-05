package com.hk.mechuri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.dtos.membersDto;

@Service
public class MembersService implements IMembersService {
	
	@Autowired
	private IMembersDao membersDao;
	
	@Override
	public boolean singUp(membersDto dto) {
		return membersDao.singUp(dto);
	}
}
