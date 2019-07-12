package com.hk.mechuri.dtos;

import java.util.Date;

public class replyDto {
	private int reply_no;
	private int reply_communo;
	private Date reply_regdate;
	private String reply_nick;
	private String reply_conts;
	private int reply_refer;
	private int reply_step;
	private int reply_depth;
	private String reply_new;
	private String reply_others02;
	
	public replyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public replyDto(int reply_no, int reply_communo, Date reply_regdate, String reply_nick, String reply_conts,
			int reply_refer, int reply_step, int reply_depth, String reply_new, String reply_others02) {
		super();
		this.reply_no = reply_no;
		this.reply_communo = reply_communo;
		this.reply_regdate = reply_regdate;
		this.reply_nick = reply_nick;
		this.reply_conts = reply_conts;
		this.reply_refer = reply_refer;
		this.reply_step = reply_step;
		this.reply_depth = reply_depth;
		this.reply_new = reply_new;
		this.reply_others02 = reply_others02;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public int getReply_communo() {
		return reply_communo;
	}

	public void setReply_communo(int reply_communo) {
		this.reply_communo = reply_communo;
	}

	public Date getReply_regdate() {
		return reply_regdate;
	}

	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}

	public String getReply_nick() {
		return reply_nick;
	}

	public void setReply_nick(String reply_nick) {
		this.reply_nick = reply_nick;
	}

	public String getReply_conts() {
		return reply_conts;
	}

	public void setReply_conts(String reply_conts) {
		this.reply_conts = reply_conts;
	}

	public int getReply_refer() {
		return reply_refer;
	}

	public void setReply_refer(int reply_refer) {
		this.reply_refer = reply_refer;
	}

	public int getReply_step() {
		return reply_step;
	}

	public void setReply_step(int reply_step) {
		this.reply_step = reply_step;
	}

	public int getReply_depth() {
		return reply_depth;
	}

	public void setReply_depth(int reply_depth) {
		this.reply_depth = reply_depth;
	}

	public String getReply_new() {
		return reply_new;
	}

	public void setReply_new(String reply_new) {
		this.reply_new = reply_new;
	}

	public String getReply_others02() {
		return reply_others02;
	}

	public void setReply_others02(String reply_others02) {
		this.reply_others02 = reply_others02;
	}
	
	


	@Override
	public String toString() {
		return "ReplyDto [reply_no=" + reply_no + ", reply_communo=" + reply_communo + ", reply_regdate="
				+ reply_regdate + ", reply_nick=" + reply_nick + ", reply_conts=" + reply_conts + ", reply_refer="
				+ reply_refer + ", reply_step=" + reply_step + ", reply_depth=" + reply_depth + ", reply_new="
				+ reply_new + ", reply_others02=" + reply_others02 + "]";
	}
	
}
