package com.hk.mechuri.dtos;

import java.util.Date;

public class msgDto {
	
	private int msg_no;
	private String msg_title;
	private String msg_conts;
	private Date msg_regdate;
	private int msg_receiverno;
	private String msg_returnconts;
	private String msg_others01;
	private String msg_others02;
	
	
	
	public msgDto() {	super();	}


	public msgDto(int msg_no, String msg_title, String msg_conts, Date msg_regdate, int msg_receiverno,
			String msg_returnconts, String msg_others01, String msg_others02) {
		super();
		this.msg_no = msg_no;
		this.msg_title = msg_title;
		this.msg_conts = msg_conts;
		this.msg_regdate = msg_regdate;
		this.msg_receiverno = msg_receiverno;
		this.msg_returnconts = msg_returnconts;
		this.msg_others01 = msg_others01;
		this.msg_others02 = msg_others02;
	}


	public msgDto(String msg_title, String msg_conts, int msg_receiverno) {
		this.msg_title = msg_title;
		this.msg_conts = msg_conts;
		this.msg_receiverno = msg_receiverno;

		
		// TODO Auto-generated constructor stub
	}


	public int getMsg_no() {
		return msg_no;
	}


	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}


	public String getMsg_title() {
		return msg_title;
	}


	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}


	public String getMsg_conts() {
		return msg_conts;
	}


	public void setMsg_conts(String msg_conts) {
		this.msg_conts = msg_conts;
	}


	public Date getMsg_regdate() {
		return msg_regdate;
	}


	public void setMsg_regdate(Date msg_regdate) {
		this.msg_regdate = msg_regdate;
	}


	public int getMsg_receiverno() {
		return msg_receiverno;
	}


	public void setMsg_receiverno(int msg_receiverno) {
		this.msg_receiverno = msg_receiverno;
	}


	public String getMsg_returnconts() {
		return msg_returnconts;
	}


	public void setMsg_returnconts(String msg_returnconts) {
		this.msg_returnconts = msg_returnconts;
	}


	public String getMsg_others01() {
		return msg_others01;
	}


	public void setMsg_others01(String msg_others01) {
		this.msg_others01 = msg_others01;
	}


	public String getMsg_others02() {
		return msg_others02;
	}


	public void setMsg_others02(String msg_others02) {
		this.msg_others02 = msg_others02;
	}


	@Override
	public String toString() {
		return "msgDto [msg_no=" + msg_no + ", msg_title=" + msg_title + ", msg_conts=" + msg_conts + ", msg_regdate="
				+ msg_regdate + ", msg_receiverno=" + msg_receiverno + ", msg_returnconts=" + msg_returnconts
				+ ", msg_others01=" + msg_others01 + ", msg_others02=" + msg_others02 + "]";
	}
	
}
