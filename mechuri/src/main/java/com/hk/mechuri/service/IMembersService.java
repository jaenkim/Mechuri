package com.hk.mechuri.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersService {
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);
	
	public boolean loginCheck(membersDto dto, HttpSession session);
	
	public membersDto viewMember(String mem_id);
	
	public void logout(HttpSession session);
	
	public membersDto NaverLogCheck(String mem_email);//네이버 로그인시 이메일 체크

	public boolean NaverSignUp(String mem_email, String mem_name, String mem_id);//네이버 로그인시 회원가입하기




	
	
	
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
