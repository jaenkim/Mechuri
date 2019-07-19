package com.hk.mechuri.dtos;

import java.util.Date;

public class reviewDto {

	private int review_no;
	private String review_membernick;
	private int review_productno;
	private String review_conts;
	private double review_point;
	private Date review_regdate;
	private int review_fileno;
	private String review_originfile;
	private String review_storedfile;
	private Date review_fileregdate;
	private int review_filesize;
	private String review_nick;
	private String review_others02;
	private double rev1count;
	private double rev2count;
	private double rev3count;
	private double rev4count;
	private double rev5count;


	//생성자
	public reviewDto() {
		super();
	}
	
	
	public reviewDto(int review_no, int review_productno, String review_membernick) {
		super();
		this.review_no = review_no;
		this.review_productno = review_productno;
		this.review_membernick = review_membernick;
	}
	
	public reviewDto(int review_productno, String review_membernick, String review_conts, Double review_point) {
		super();
		this.review_productno = review_productno;
		this.review_membernick = review_membernick;
		this.review_conts = review_conts;
		this.review_point = review_point;
	}

	public reviewDto(int review_productno, String review_membernick, String review_conts, Double review_point,
			String review_originfile, String review_storedfile, int review_filesize) {
		super();
		this.review_productno = review_productno;
		this.review_membernick = review_membernick;
		this.review_conts = review_conts;
		this.review_point = review_point;
		this.review_originfile = review_originfile;
		this.review_storedfile = review_storedfile;
		this.review_filesize = review_filesize;
	}


	//Getter and Setter
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReview_membernick() {
		return review_membernick;
	}
	public void setReview_membernick(String review_membernick) {
		this.review_membernick = review_membernick;
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
	public double getReview_point() {
		return review_point;
	}
	public void setReview_point(double review_point) {
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
	public String getReview_nick() {
		return review_nick;
	}
	public void setReview_nick(String review_nick) {
		this.review_nick = review_nick;
	}
	public String getReview_others02() {
		return review_others02;
	}
	public void setReview_others02(String review_others02) {
		this.review_others02 = review_others02;
	}
	public double getRev1count() {
		return rev1count;
	}
	public void setRev1count(double rev1count) {
		this.rev1count = rev1count;
	}
	public double getRev2count() {
		return rev2count;
	}
	public void setRev2count(double rev2count) {
		this.rev2count = rev2count;
	}
	public double getRev3count() {
		return rev3count;
	}
	public void setRev3count(double rev3count) {
		this.rev3count = rev3count;
	}
	public double getRev4count() {
		return rev4count;
	}
	public void setRev4count(double rev4count) {
		this.rev4count = rev4count;
	}
	public double getRev5count() {
		return rev5count;
	}
	public void setRev5count(double rev5count) {
		this.rev5count = rev5count;
	}


	@Override
	public String toString() {
		return "reviewDto [review_no=" + review_no + ", review_membernick=" + review_membernick + ", review_productno="
				+ review_productno + ", review_conts=" + review_conts + ", review_point=" + review_point
				+ ", review_regdate=" + review_regdate + ", review_fileno=" + review_fileno + ", review_originfile="
				+ review_originfile + ", review_storedfile=" + review_storedfile + ", review_fileregdate="
				+ review_fileregdate + ", review_filesize=" + review_filesize + ", review_nick=" + review_nick
				+ ", review_others02=" + review_others02 + ", rev1count=" + rev1count + ", rev2count=" + rev2count
				+ ", rev3count=" + rev3count + ", rev4count=" + rev4count + ", rev5count=" + rev5count + "]";
	}

	

}
