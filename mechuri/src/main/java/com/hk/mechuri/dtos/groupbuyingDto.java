package com.hk.mechuri.dtos;

import java.util.Date;

public class groupbuyingDto {
	private int groupbuying_no;
	private int groupbuying_pno;
	private int groupbuying_turn;
	private Date groupbuying_go;
	private Date groupbuying_end;
	private String groupbuying_price;
	private int groupbuying_count;
	private String groupbuying_tesorno;
	private String groupbuying_others01;
	private String groupbuying_others02;
	public groupbuyingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public groupbuyingDto(int groupbuying_no, int groupbuying_pno, int groupbuying_turn, Date groupbuying_go,
			Date groupbuying_end, String groupbuying_price, int groupbuying_count, String groupbuying_tesorno,
			String groupbuying_others01, String groupbuying_others02) {
		super();
		this.groupbuying_no = groupbuying_no;
		this.groupbuying_pno = groupbuying_pno;
		this.groupbuying_turn = groupbuying_turn;
		this.groupbuying_go = groupbuying_go;
		this.groupbuying_end = groupbuying_end;
		this.groupbuying_price = groupbuying_price;
		this.groupbuying_count = groupbuying_count;
		this.groupbuying_tesorno = groupbuying_tesorno;
		this.groupbuying_others01 = groupbuying_others01;
		this.groupbuying_others02 = groupbuying_others02;
	}
	public int getGroupbuying_no() {
		return groupbuying_no;
	}
	public void setGroupbuying_no(int groupbuying_no) {
		this.groupbuying_no = groupbuying_no;
	}
	public int getGroupbuying_pno() {
		return groupbuying_pno;
	}
	public void setGroupbuying_pno(int groupbuying_pno) {
		this.groupbuying_pno = groupbuying_pno;
	}
	public int getGroupbuying_turn() {
		return groupbuying_turn;
	}
	public void setGroupbuying_turn(int groupbuying_turn) {
		this.groupbuying_turn = groupbuying_turn;
	}
	public Date getGroupbuying_go() {
		return groupbuying_go;
	}
	public void setGroupbuying_go(Date groupbuying_go) {
		this.groupbuying_go = groupbuying_go;
	}
	public Date getGroupbuying_end() {
		return groupbuying_end;
	}
	public void setGroupbuying_end(Date groupbuying_end) {
		this.groupbuying_end = groupbuying_end;
	}
	public String getGroupbuying_price() {
		return groupbuying_price;
	}
	public void setGroupbuying_price(String groupbuying_price) {
		this.groupbuying_price = groupbuying_price;
	}
	public int getGroupbuying_count() {
		return groupbuying_count;
	}
	public void setGroupbuying_count(int groupbuying_count) {
		this.groupbuying_count = groupbuying_count;
	}
	public String getGroupbuying_tesorno() {
		return groupbuying_tesorno;
	}
	public void setGroupbuying_tesorno(String groupbuying_tesorno) {
		this.groupbuying_tesorno = groupbuying_tesorno;
	}
	public String getGroupbuying_others01() {
		return groupbuying_others01;
	}
	public void setGroupbuying_others01(String groupbuying_others01) {
		this.groupbuying_others01 = groupbuying_others01;
	}
	public String getGroupbuying_others02() {
		return groupbuying_others02;
	}
	public void setGroupbuying_others02(String groupbuying_others02) {
		this.groupbuying_others02 = groupbuying_others02;
	}
	@Override
	public String toString() {
		return "groupbuyingDto [groupbuying_no=" + groupbuying_no + ", groupbuying_pno=" + groupbuying_pno
				+ ", groupbuying_turn=" + groupbuying_turn + ", groupbuying_go=" + groupbuying_go + ", groupbuying_end="
				+ groupbuying_end + ", groupbuying_price=" + groupbuying_price + ", groupbuying_count="
				+ groupbuying_count + ", groupbuying_tesorno=" + groupbuying_tesorno + ", groupbuying_others01="
				+ groupbuying_others01 + ", groupbuying_others02=" + groupbuying_others02 + "]";
	}
	
	
	
}
