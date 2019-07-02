package com.hk.mechuri.dtos;

import java.util.Date;

public class eventDto {

	private int event_no;
	private String event_brandname;
	private Date event_start;
	private Date event_end;
	private String event_apprflag;
	private String event_title;
	private String event_conts;
	private String event_othes01;
	private String event_others02;
	
	
	
	public eventDto() {	super();	}


	public eventDto(int event_no, String event_brandname, Date event_start, Date event_end, String event_apprflag,
			String event_title, String event_conts, String event_othes01, String event_others02) {
		super();
		this.event_no = event_no;
		this.event_brandname = event_brandname;
		this.event_start = event_start;
		this.event_end = event_end;
		this.event_apprflag = event_apprflag;
		this.event_title = event_title;
		this.event_conts = event_conts;
		this.event_othes01 = event_othes01;
		this.event_others02 = event_others02;
	}


	public int getEvent_no() {
		return event_no;
	}


	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}


	public String getEvent_brandname() {
		return event_brandname;
	}


	public void setEvent_brandname(String event_brandname) {
		this.event_brandname = event_brandname;
	}


	public Date getEvent_start() {
		return event_start;
	}


	public void setEvent_start(Date event_start) {
		this.event_start = event_start;
	}


	public Date getEvent_end() {
		return event_end;
	}


	public void setEvent_end(Date event_end) {
		this.event_end = event_end;
	}


	public String getEvent_apprflag() {
		return event_apprflag;
	}


	public void setEvent_apprflag(String event_apprflag) {
		this.event_apprflag = event_apprflag;
	}


	public String getEvent_title() {
		return event_title;
	}


	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}


	public String getEvent_conts() {
		return event_conts;
	}


	public void setEvent_conts(String event_conts) {
		this.event_conts = event_conts;
	}


	public String getEvent_othes01() {
		return event_othes01;
	}


	public void setEvent_othes01(String event_othes01) {
		this.event_othes01 = event_othes01;
	}


	public String getEvent_others02() {
		return event_others02;
	}


	public void setEvent_others02(String event_others02) {
		this.event_others02 = event_others02;
	}


	@Override
	public String toString() {
		return "eventDto [event_no=" + event_no + ", event_brandname=" + event_brandname + ", event_start="
				+ event_start + ", event_end=" + event_end + ", event_apprflag=" + event_apprflag + ", event_title="
				+ event_title + ", event_conts=" + event_conts + ", event_othes01=" + event_othes01
				+ ", event_others02=" + event_others02 + "]";
	}
	
	
}
