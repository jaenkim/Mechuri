package com.hk.mechuri.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.daos.MembersDao;
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
	public void regist(membersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public membersDto userAuth(membersDto dto) {
		// TODO Auto-generated method stub
		return null;
	}


/*//	<!-- 로그인 -->
	@Override
	public membersDto memLoginBoard(membersDto dto) {
		System.out.println("memLoginBoard Service");
		return membersDao.memLoginBoard(dto);
	}
	
	@Override
		public boolean loginChk(String mem_id) 
		{
			return membersDao.loginChk(mem_id)>0?true:false;
		}*/

}

	

