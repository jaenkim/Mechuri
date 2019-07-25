package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersDao {
	
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);
	
	public boolean loginCheck(membersDto dto);
	
	public membersDto viewMember(String userid);
	
	public membersDto NaverLogCheck(String mem_email);//네이버 로그인시 이메일 체크

	public boolean NaverSignUp(String mem_email, String mem_name, String mem_id);//네이버 로그인시 회원가입하기

	public membersDto idcheck(String mem_id);

	public membersDto existNaverId(membersDto mDto);

	public membersDto getNameForNaverMember(String naverEmail);

	public boolean delflagCheck(membersDto dto);

	public String memIdSearch(Map<String, String> map);

	public membersDto pwSearch(membersDto dto);
	
	public int updatePw(membersDto dto);
}
