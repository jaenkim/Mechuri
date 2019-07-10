package com.hk.mechuri.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersService {
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);
	
	public boolean loginCheck(membersDto dto);
	
	
	/*public void regist(membersDto dto);

	public membersDto userAuth(membersDto dto);
	
	public membersDto loginBoard(membersDto dto); 

	public void logout(HttpSession session);

	boolean idChk(String id);

	boolean loginChk(Map<String, String> map);

	public Integer countmessage(membersDto dto);*/
	
/*	public membersDto memLoginBoard(membersDto dto);
	
	public boolean loginChk(Map<String, String> map);

	boolean loginChk(String mem_id); */
}
