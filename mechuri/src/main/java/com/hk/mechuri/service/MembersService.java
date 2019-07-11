package com.hk.mechuri.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public boolean loginCheck(membersDto dto, HttpSession session) {
		boolean result=membersDao.loginCheck(dto);
		if(result) { // 세션 변수 저장, 세션 관리 기능->controller에서 할 것을 service에 넘겨서 한거...
			membersDto dto2 = viewMember(dto.getMem_id());
			session.setAttribute("mem_id", dto2.getMem_id());
			session.setAttribute("mem_name", dto2.getMem_name());
			System.out.println(dto2);
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}

	@Override
	public membersDto viewMember(String mem_id) {
		return membersDao.viewMember(mem_id);
	}

	
	/*@Override
	public Map<String, Object> selectUserInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int loginCheck(HashMap<String, String> hstParam) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	
	/*@Override
	public Map<String, Object> selectUserInfo(Map<String, Object> map) throws Exception {
		return membersDao.selectUserInfo(map);
    }*/
	

/*//	<!-- 로그인 -->
	@Override
	public membersDto memLoginBoard(membersDto dto) {
		System.out.println("memLoginBoard Service");
		return membersDao.memLoginBoard(dto);
	}
	

	public static boolean loginChk(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}*/


}
