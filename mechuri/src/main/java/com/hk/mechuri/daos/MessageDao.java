package com.hk.mechuri.daos;


import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.mechuri.dtos.msgDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.tempinfoDto;


@Repository
public class MessageDao {

	private String namespace="com.hk.mechuri.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
		
	public boolean sendMessage2(productDto pdto) {	//쪽지 추가(제품등록)
		int count=sqlSession.insert(namespace+"sendMessage2",pdto);
		return count>0?true:false;
	}
	
	public boolean sendMessage3(tempinfoDto dto) {	//쪽지 추가(제품수정)
		int count=sqlSession.insert(namespace+"sendMessage3",dto);
		return count>0?true:false;
	}
	
	
	public List<msgDto> getAllList(int mem_no,String mem_status) {
		if(mem_status.equals("M")) {
			return sqlSession.selectList(namespace+"msgList2",mem_no);

		}else {
			return sqlSession.selectList(namespace+"msgList",mem_no);
		}
	}
	
	public boolean gogomsg(String msg_title, String msg_conts,int msg_receiverno) {	//쪽지 전체발송
		msgDto dto = new msgDto(msg_title, msg_conts, msg_receiverno);
		
		int count=sqlSession.insert(namespace+"gogomsg2",dto);
		return count>0?true:false;
	}
	
}
