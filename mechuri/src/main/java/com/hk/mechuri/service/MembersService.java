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
	public boolean signUpBoard(membersDto dto) {
		return membersDao.signUpBoard(dto); 
	}

	@Override
	public boolean compSignUpBoard(membersDto dto) {
		return membersDao.compSignUpBoard(dto); 
	}
	@Override
	public boolean memLogin(membersDto dto) {
		return membersDao.memLogin(dto);
	}
}
