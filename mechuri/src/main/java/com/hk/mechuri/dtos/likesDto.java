package com.hk.mechuri.dtos;

public class likesDto {
	private int likes_no;
	private String likes_id;
	private int likes_productno;
	private int likes_others01;
	private int likes_others02;
	
	public likesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public likesDto(int likes_no, String likes_id, int likes_productno, int likes_others01, int likes_others02) {
		super();
		this.likes_no = likes_no;
		this.likes_id = likes_id;
		this.likes_productno = likes_productno;
		this.likes_others01 = likes_others01;
		this.likes_others02 = likes_others02;
	}

	public int getLikes_no() {
		return likes_no;
	}

	public void setLikes_no(int likes_no) {
		this.likes_no = likes_no;
	}

	public String getLikes_id() {
		return likes_id;
	}

	public void setLikes_id(String likes_id) {
		this.likes_id = likes_id;
	}

	public int getLikes_productno() {
		return likes_productno;
	}

	public void setLikes_productno(int likes_productno) {
		this.likes_productno = likes_productno;
	}

	public int getLikes_others01() {
		return likes_others01;
	}

	public void setLikes_others01(int likes_others01) {
		this.likes_others01 = likes_others01;
	}

	public int getLikes_others02() {
		return likes_others02;
	}

	public void setLikes_others02(int likes_others02) {
		this.likes_others02 = likes_others02;
	}

	@Override
	public String toString() {
		return "LikesDto [likes_no=" + likes_no + ", likes_id=" + likes_id + ", likes_productno=" + likes_productno
				+ ", likes_others01=" + likes_others01 + ", likes_others02=" + likes_others02 + "]";
	}
	
}
