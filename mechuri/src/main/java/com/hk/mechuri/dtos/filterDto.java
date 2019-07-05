package com.hk.mechuri.dtos;

public class filterDto {

	private String filter_age10;
	private String filter_age20;
	private String filter_age30;
	private String filter_age40;
	private String filter_age50;
	private String filter_genderF;
	private String filter_genderM;
	private String filter_catelname;
	private String filter_catesname;
	private String filter_price; 
		
	
	public filterDto() {super();	}

	public filterDto(String filter_age10, String filter_age20, String filter_age30, String filter_age40,
		String filter_age50, String filter_genderF, String filter_genderM, String filter_catelname,
		String filter_catesname, String filter_price) {
	super();
	this.filter_age10 = filter_age10;
	this.filter_age20 = filter_age20;
	this.filter_age30 = filter_age30;
	this.filter_age40 = filter_age40;
	this.filter_age50 = filter_age50;
	this.filter_genderF = filter_genderF;
	this.filter_genderM = filter_genderM;
	this.filter_catelname = filter_catelname;
	this.filter_catesname = filter_catesname;
	this.filter_price = filter_price;
}

	
	public String getFilter_age10() {
		return filter_age10;
	}
	public void setFilter_age10(String filter_age10) {
		this.filter_age10 = filter_age10;
	}
	public String getFilter_age20() {
		return filter_age20;
	}
	public void setFilter_age20(String filter_age20) {
		this.filter_age20 = filter_age20;
	}
	public String getFilter_age30() {
		return filter_age30;
	}
	public void setFilter_age30(String filter_age30) {
		this.filter_age30 = filter_age30;
	}
	public String getFilter_age40() {
		return filter_age40;
	}
	public void setFilter_age40(String filter_age40) {
		this.filter_age40 = filter_age40;
	}
	public String getFilter_age50() {
		return filter_age50;
	}
	public void setFilter_age50(String filter_age50) {
		this.filter_age50 = filter_age50;
	}
	public String getFilter_genderF() {
		return filter_genderF;
	}
	public void setFilter_genderF(String filter_genderF) {
		this.filter_genderF = filter_genderF;
	}
	public String getFilter_genderM() {
		return filter_genderM;
	}
	public void setFilter_genderM(String filter_genderM) {
		this.filter_genderM = filter_genderM;
	}
	public String getFilter_catelname() {
		return filter_catelname;
	}
	public void setFilter_catelname(String filter_catelname) {
		this.filter_catelname = filter_catelname;
	}
	public String getFilter_catesname() {
		return filter_catesname;
	}
	public void setFilter_catesname(String filter_catesname) {
		this.filter_catesname = filter_catesname;
	}
	public String getFilter_price() {
		return filter_price;
	}
	public void setFilter_price(String filter_price) {
		this.filter_price = filter_price;
	}


	@Override
	public String toString() {
		return "filterDto [filter_age10=" + filter_age10 + ", filter_age20=" + filter_age20 + ", filter_age30="
				+ filter_age30 + ", filter_age40=" + filter_age40 + ", filter_age50=" + filter_age50
				+ ", filter_genderF=" + filter_genderF + ", filter_genderM=" + filter_genderM + ", filter_catelname="
				+ filter_catelname + ", filter_catesname=" + filter_catesname + "]";
	}
		
	
}
