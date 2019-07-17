package com.hk.mechuri.dtos;

import java.util.Date;

public class membersDto {
	
	private int mem_no;
	private String mem_id;
	private String mem_pw;
	private String mem_status;
	private String mem_brand;
	private String mem_name;
	private String mem_nick;
	private String mem_phone;
	private String mem_email;
	private String mem_post;
	private String mem_addr1;
	private String mem_addr2;
	private Date mem_regdate;
	private Date mem_deldate;
	private String mem_delflag;
	private String mem_apprflag;
	private String mem_homepage;
	private String mem_naverid;
	private String mem_others02;

	//생성자
	public membersDto() {	super(); }

	public membersDto( String mem_id, String mem_name, String mem_nick, String mem_naverid) {	
		super(); 
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_naverid = mem_naverid;
		this.mem_nick = mem_nick;
	}
	
	
	
	//Getter and Setter
	public int getMem_no() {	return mem_no;	}
	public void setMem_no(int mem_no) {	this.mem_no = mem_no;	}
	
	public String getMem_id() {	return mem_id;}
	public void setMem_id(String mem_id) {	this.mem_id = mem_id;}

	public String getMem_pw() {	return mem_pw;}
	public void setMem_pw(String mem_pw) {	this.mem_pw = mem_pw;	}

	public String getMem_status() {return mem_status;	}
	public void setMem_status(String mem_status) {	this.mem_status = mem_status;	}

	public String getMem_brand() {	return mem_brand;	}
	public void setMem_brand(String mem_brand) {this.mem_brand = mem_brand;}

	public String getMem_name() {	return mem_name;	}
	public void setMem_name(String mem_name) {this.mem_name = mem_name;	}

	public String getMem_nick() {	return mem_nick;	}
	public void setMem_nick(String mem_nick) {	this.mem_nick = mem_nick;	}

	public String getMem_phone() {return mem_phone;	}
	public void setMem_phone(String mem_phone) {	this.mem_phone = mem_phone;	}

	public String getMem_email() {	return mem_email;	}
	public void setMem_email(String mem_email) {	this.mem_email = mem_email;}

	public String getMem_post() {return mem_post;}
	public void setMem_post(String mem_post) {this.mem_post = mem_post;	}

	public String getMem_addr1() {	return mem_addr1;	}
	public void setMem_addr1(String mem_addr1) {this.mem_addr1 = mem_addr1;}

	public String getMem_addr2() {	return mem_addr2;	}
	public void setMem_addr2(String mem_addr2) {this.mem_addr2 = mem_addr2;}

	public Date getMem_regdate() {return mem_regdate;}
	public void setMem_regdate(Date mem_regdate) {	this.mem_regdate = mem_regdate;}

	public Date getMem_deldate() {	return mem_deldate;}
	public void setMem_deldate(Date mem_deldate) {	this.mem_deldate = mem_deldate;}

	public String getMem_delflag() {return mem_delflag;}
	public void setMem_delflag(String mem_delflag) {	this.mem_delflag = mem_delflag;}

	public String getMem_apprflag() {	return mem_apprflag;}
	public void setMem_apprflag(String mem_apprflag) {	this.mem_apprflag = mem_apprflag;	}

	public String getMem_homepage() {	return mem_homepage;}
	public void setMem_homepage(String mem_homepage) {	this.mem_homepage = mem_homepage;}

	public String getMem_naverid() {return mem_naverid;}
	public void setMem_naverid(String mem_naverid) {this.mem_naverid = mem_naverid;}

	public String getMem_others02() {return mem_others02;}
	public void setMem_others02(String mem_others02) {this.mem_others02 = mem_others02;}

	
	@Override
	public String toString() {
		return "membersDto [mem_no=" + mem_no + ", mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_status="
				+ mem_status + ", mem_brand=" + mem_brand + ", mem_name=" + mem_name + ", mem_nick=" + mem_nick
				+ ", mem_phone=" + mem_phone + ", mem_email=" + mem_email + ", mem_post=" + mem_post + ", mem_addr1="
				+ mem_addr1 + ", mem_addr2=" + mem_addr2 + ", mem_regdate=" + mem_regdate + ", mem_deldate="
				+ mem_deldate + ", mem_delflag=" + mem_delflag + ", mem_apprflag=" + mem_apprflag + ", mem_homepage="
				+ mem_homepage + ", mem_naverid=" + mem_naverid + ", mem_others02=" + mem_others02 + "]";
	}
	
}
