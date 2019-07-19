package com.hk.mechuri.dtos;

public class filterDto {

	private String age10;
	private String age20;
	private String age30;
	private String age40;
	private String age50;
	private String female;
	private String male;
	private String catelname;
	private String catesname;
	private String price; 
		
	
	public filterDto() {super();	}

	public filterDto(String age10, String age20, String age30, String age40, String age50, String female, String male,
			String catelname, String catesname) {
		super();
		this.age10 = age10;
		this.age20 = age20;
		this.age30 = age30;
		this.age40 = age40;
		this.age50 = age50;
		this.female = female;
		this.male = male;
		this.catelname = catelname;
		this.catesname = catesname;
	}




	public String getAge10() {
		return age10;
	}
	public void setAge10(String age10) {
		this.age10 = age10;
	}
	public String getAge20() {
		return age20;
	}
	public void setAge20(String age20) {
		this.age20 = age20;
	}
	public String getAge30() {
		return age30;
	}
	public void setAge30(String age30) {
		this.age30 = age30;
	}
	public String getAge40() {
		return age40;
	}
	public void setAge40(String age40) {
		this.age40 = age40;
	}
	public String getAge50() {
		return age50;
	}
	public void setAge50(String age50) {
		this.age50 = age50;
	}
	public String getFemale() {
		return female;
	}
	public void setFemale(String female) {
		this.female = female;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public String getCatelname() {
		return catelname;
	}
	public void setCatelname(String catelname) {
		this.catelname = catelname;
	}
	public String getCatesname() {
		return catesname;
	}
	public void setCatesname(String catesname) {
		this.catesname = catesname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "filterDto [age10=" + age10 + ", age20=" + age20 + ", age30=" + age30 + ", age40=" + age40 + ", age50="
				+ age50 + ", female=" + female + ", male=" + male + ", catelname=" + catelname + ", catesname="
				+ catesname + ", price=" + price + "]";
	}

	
	
}
