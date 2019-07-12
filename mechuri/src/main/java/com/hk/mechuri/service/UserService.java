package com.hk.mechuri.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

import com.hk.mechuri.daos.MembersDao;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.naver.TempKey;

public class UserService {
	@Inject
	private JavaMailSender mailSender;


	/*@Override
	public void regist(membersDto dto) throws Exception {

		System.out.println("서비스레지스");

		String encPassword = passwordEncoder.encode(dto.getMem_pw());
		dto.setMem_pw(encPassword);
		//System.out.println("암호화된 비밀번호 : "+user.getUserPassword());

		MembersDao.insertUser(dto);
		System.out.println(dto);
		System.out.println("///////////////////////  찍히");
		String key = new TempKey().getKey(50,false);  // 인증키 생성

		MembersDao.createAuthKey(dto.getMem_email(),key); //인증키 db 저장
		//메일 전송
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("FAINT  서비스 이메일 인증]");
		sendMail.setText(
				new StringBuffer().append("<h1>메일인증</h1>").append("<a href='http://localhost:8888/mechuri/emailConfirm?Mem_email=").
						append(dto.getMem_email()).
						append("&memberAuthKey=").append(key).
						append("' target='_blank'>이메일 인증 확인</a>").toString());
				sendMail.setFrom("alfk9393@gmail.com", "서어비스센터 ");


				sendMail.setTo(dto.getMem_email());
				sendMail.send();
	}

	//이메일 인증 키 검증
	@Override
	public membersDto userAuth(membersDto dto) throws Exception {
		membersDto dto =new membersDto();
		System.out.println(dto+"dto");
		dto=MembersDao.chkAuth(dto);

		if(dto!=null){
			try{
				System.out.println(dto+"vo");
				MembersDao.userAuth(dto);
				MembersDao.successAuth(dto);
			}catch (Exception e) {
				e.printStackTrace();
			}}
		return dto;
	}*/
}
