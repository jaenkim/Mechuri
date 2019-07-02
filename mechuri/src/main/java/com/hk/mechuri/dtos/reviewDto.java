package com.hk.mechuri.dtos;

import java.util.Date;

public class reviewDto {

	private int review_no;
	private String review_memberid;
	private int review_productno;
	private String review_conts;
	private int review_point;
	private Date review_regdate;
	private int review_fileno;
	private String review_originfile;
	private String review_storedfile;
	private Date review_fileregdate;
	private int review_filesize;
	private String review_others01;
	private String review_others02;
	
	//생성자
	public reviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getter and Setter
	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public String getReview_memberid() {
		return review_memberid;
	}

	public void setReview_memberid(String review_memberid) {
		this.review_memberid = review_memberid;
	}

	public int getReview_productno() {
		return review_productno;
	}

	public void setReview_productno(int review_productno) {
		this.review_productno = review_productno;
	}

	public String getReview_conts() {
		return review_conts;
	}

	public void setReview_conts(String review_conts) {
		this.review_conts = review_conts;
	}

	public int getReview_point() {
		return review_point;
	}

	public void setReview_point(int review_point) {
		this.review_point = review_point;
	}

	public Date getReview_regdate() {
		return review_regdate;
	}

	public void setReview_regdate(Date review_regdate) {
		this.review_regdate = review_regdate;
	}

	public int getReview_fileno() {
		return review_fileno;
	}

	public void setReview_fileno(int review_fileno) {
		this.review_fileno = review_fileno;
	}

	public String getReview_originfile() {
		return review_originfile;
	}

	public void setReview_originfile(String review_originfile) {
		this.review_originfile = review_originfile;
	}

	public String getReview_storedfile() {
		return review_storedfile;
	}

	public void setReview_storedfile(String review_storedfile) {
		this.review_storedfile = review_storedfile;
	}

	public Date getReview_fileregdate() {
		return review_fileregdate;
	}

	public void setReview_fileregdate(Date review_fileregdate) {
		this.review_fileregdate = review_fileregdate;
	}

	public int getReview_filesize() {
		return review_filesize;
	}

	public void setReview_filesize(int review_filesize) {
		this.review_filesize = review_filesize;
	}

	public String getReview_others01() {
		return review_others01;
	}

	public void setReview_others01(String review_others01) {
		this.review_others01 = review_others01;
	}

	public String getReview_others02() {
		return review_others02;
	}

	public void setReview_others02(String review_others02) {
		this.review_others02 = review_others02;
	}


	@Override
	public String toString() {
		return "reviewDto [review_no=" + review_no + ", review_memberid=" + review_memberid + ", review_productno="
				+ review_productno + ", review_conts=" + review_conts + ", review_point=" + review_point
				+ ", review_regdate=" + review_regdate + ", review_fileno=" + review_fileno + ", review_originfile="
				+ review_originfile + ", review_storedfile=" + review_storedfile + ", review_fileregdate="
				+ review_fileregdate + ", review_filesize=" + review_filesize + ", review_others01=" + review_others01
				+ ", review_others02=" + review_others02 + "]";
	}
	
	
	
	
}
