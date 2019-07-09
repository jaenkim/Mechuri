package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.membersDto;

@Repository
public class MembersDao implements IMembersDao {
	
	private String namespace="com.hk.mechuri.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean signUpBoard(membersDto dto) {
		int count=sqlSession.insert(namespace+"signUpBoard",dto);
		return count>0?true:false;
		}
	@Override
	public boolean compSignUpBoard(membersDto dto) {
		int count=sqlSession.insert(namespace+"compSignUpBoard",dto);
		return count>0?true:false;
		}
	/*@Override
	public membersDto memLoginBoard(String mem_id,String mem_pw) {
		 Map<String,Object> map=new HashMap<String, Object>();
	        map.put("id", mem_id);
	        map.put("password", mem_pw);
	     
	        return sqlSession.selectOne("member.password", map);
	       */
	//로그인
	/*@Override
	public membersDto memLoginBoard(membersDto dto) {
		System.out.println(dto +"전달");
		return sqlSession.selectOne(namespace+"memLoginBoard", dto);
	}
	
	@Override
	public int loginChk(String mem_id) 
	{
		return sqlSession.selectOne(namespace+"loginChk",mem_id);*/
	//회원 정보 입력
    @Override
    public void insertUser(membersDto dto) throws Exception {
        System.out.println("회원등록완료 !!!");
        sqlSession.insert(namespace+".insertUser",dto);
        System.out.println("//////////////////////////////////");
        System.out.println("회원등록완료 !!!");
    }
    //email 중복 확인
    @Override
    public membersDto authenticate(String str) throws Exception {
        return sqlSession.selectOne(namespace+".checkdupl", str);
    }
 
    //해당 email에 인증 키 업데이트
    @Override
    public void createAuthKey(String memberEmail, String memberAuthKey, membersDto dto) throws Exception {
    	membersDto vo = new membersDto();
        vo.setMemberAuthKey(memberAuthKey);
        vo.setMemberEmail(memberEmail);
        sqlSession.update(namespace + ".createAuthKey", dto);
    }
    //이메일 인증 코드 확인
    @Override
    public membersDto chkAuth(membersDto dto) throws Exception {
        return sqlSession.selectOne(namespace + ".chkAuth", dto);
    }
    //인증 후 계정 활성화
    @Override
    public void userAuth(membersDto dto) throws Exception {
        System.out.println("인증하나요??");
        
        sqlSession.update(namespace + ".userAuth", dto);
        System.out.println(dto.getUserState());
    }
	public static void successAuth(membersDto dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void userAuth(String mem_email) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createAuthKey(String mem_email, String User_authCode) throws Exception {
		// TODO Auto-generated method stub
		
	}
	}

	

