package com.hk.mechuri.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.userManageDao;
import com.hk.mechuri.dtos.membersDto;

@Service
public class userManageService {

	@Autowired
	private userManageDao usermanageDao;
	
	public List<membersDto> getUserList() {
		return usermanageDao.getUserList();
	}
	
	public List<membersDto> getComUserList() {
		return usermanageDao.getComUserList();
	}
	
	public boolean userdel(Integer mem_no) {
		return usermanageDao.userdel(mem_no);
	}
	
	
	public boolean compAppr(Integer mem_no) {
		return usermanageDao.compAppr(mem_no);
	}
	
	public List<membersDto> comInfo(int mem_no) {
		return usermanageDao.comInfo(mem_no);
	}
	
	public boolean comtal(Integer mem_no) {
		return usermanageDao.comtal(mem_no);
	}
	
	public boolean infoUpdate(membersDto dto) {
		return usermanageDao.infoUpdate(dto);
	}
	
	public List<membersDto> userInfo(int mem_no) {
		return usermanageDao.userInfo(mem_no);
	}
	
	public List<membersDto> infoinfo(int mem_no) {
		return usermanageDao.infoinfo(mem_no);
	}
	
}

