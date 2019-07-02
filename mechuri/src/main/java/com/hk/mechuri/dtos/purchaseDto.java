package com.hk.mechuri.dtos;

import java.util.Date;

public class purchaseDto {
	private int purch_seq;
	private String purch_userid;
	private int purch_no;
	private int purch_count;
	private Date purch_date;
	private String purch_receiver;
	private String purch_phone;
	private String purch_post;
	private String purch_addr1;
	private String purch_addr2;
	private String purch_msg;
	private String purch_payment;
	private int purch_price;
	public purchaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public purchaseDto(int purch_seq, String purch_userid, int purch_no, int purch_count, Date purch_date,
			String purch_receiver, String purch_phone, String purch_post, String purch_addr1, String purch_addr2,
			String purch_msg, String purch_payment, int purch_price) {
		super();
		this.purch_seq = purch_seq;
		this.purch_userid = purch_userid;
		this.purch_no = purch_no;
		this.purch_count = purch_count;
		this.purch_date = purch_date;
		this.purch_receiver = purch_receiver;
		this.purch_phone = purch_phone;
		this.purch_post = purch_post;
		this.purch_addr1 = purch_addr1;
		this.purch_addr2 = purch_addr2;
		this.purch_msg = purch_msg;
		this.purch_payment = purch_payment;
		this.purch_price = purch_price;
	}
	public int getPurch_seq() {
		return purch_seq;
	}
	public void setPurch_seq(int purch_seq) {
		this.purch_seq = purch_seq;
	}
	public String getPurch_userid() {
		return purch_userid;
	}
	public void setPurch_userid(String purch_userid) {
		this.purch_userid = purch_userid;
	}
	public int getPurch_no() {
		return purch_no;
	}
	public void setPurch_no(int purch_no) {
		this.purch_no = purch_no;
	}
	public int getPurch_count() {
		return purch_count;
	}
	public void setPurch_count(int purch_count) {
		this.purch_count = purch_count;
	}
	public Date getPurch_date() {
		return purch_date;
	}
	public void setPurch_date(Date purch_date) {
		this.purch_date = purch_date;
	}
	public String getPurch_receiver() {
		return purch_receiver;
	}
	public void setPurch_receiver(String purch_receiver) {
		this.purch_receiver = purch_receiver;
	}
	public String getPurch_phone() {
		return purch_phone;
	}
	public void setPurch_phone(String purch_phone) {
		this.purch_phone = purch_phone;
	}
	public String getPurch_post() {
		return purch_post;
	}
	public void setPurch_post(String purch_post) {
		this.purch_post = purch_post;
	}
	public String getPurch_addr1() {
		return purch_addr1;
	}
	public void setPurch_addr1(String purch_addr1) {
		this.purch_addr1 = purch_addr1;
	}
	public String getPurch_addr2() {
		return purch_addr2;
	}
	public void setPurch_addr2(String purch_addr2) {
		this.purch_addr2 = purch_addr2;
	}
	public String getPurch_msg() {
		return purch_msg;
	}
	public void setPurch_msg(String purch_msg) {
		this.purch_msg = purch_msg;
	}
	public String getPurch_payment() {
		return purch_payment;
	}
	public void setPurch_payment(String purch_payment) {
		this.purch_payment = purch_payment;
	}
	public int getPurch_price() {
		return purch_price;
	}
	public void setPurch_price(int purch_price) {
		this.purch_price = purch_price;
	}
	@Override
	public String toString() {
		return "PurchaseDto [purch_seq=" + purch_seq + ", purch_userid=" + purch_userid + ", purch_no=" + purch_no
				+ ", purch_count=" + purch_count + ", purch_date=" + purch_date + ", purch_receiver=" + purch_receiver
				+ ", purch_phone=" + purch_phone + ", purch_post=" + purch_post + ", purch_addr1=" + purch_addr1
				+ ", purch_addr2=" + purch_addr2 + ", purch_msg=" + purch_msg + ", purch_payment=" + purch_payment
				+ ", purch_price=" + purch_price + "]";
	}
	
}
