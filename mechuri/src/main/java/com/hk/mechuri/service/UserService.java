package com.hk.mechuri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

import com.hk.mechuri.daos.MembersDao;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.utils.MailUtils;
import com.hk.mechuri.utils.TempKey;

public class UserService {
	@Autowired

	private JavaMailSender mailSender;	



	@Transactional

	public void create(membersDto dto) throws Exception {

		MembersDao.create(dto);

	

		// 임의의 authkey 생성

		String authkey = new TempKey().getKey(50, false);



		membersDto.setAuthkey(authkey);

		MembersDao.updateAuthkey(dto);



		// mail 작성 관련 

		MailUtils sendMail = new MailUtils(mailSender);



		sendMail.setSubject("[Hoon's Board v2.0] 회원가입 이메일 인증");

		sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")

				.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")

				.append("<a href='http://localhost:8888/mechuri/joinConfirm?authkey=")

				.append(dto.getMem_id())

				.append("&email=")

				.append(dto.getMem_email())

				.append("&authkey=")

				.append(authkey)

				.append("' target='_blenk'>이메일 인증 확인</a>")

				.toString());

		sendMail.setFrom("관리자 ", "관리자명");

		sendMail.setTo(dto.getMem_email());

		sendMail.send();

	}
}
