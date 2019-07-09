package com.hk.mechuri.dtos;

public class ingreDto {

	private String ingre_no;
	private String ingre_korname;
	private String ingre_engname;
	private String ingre_conts;
	private String ingre_danger;
	private int ingre_grade;
	private String ingre_skintype;
	private String ingre_20;
	private String ingre_20conts;
	private String ingre_allergy;
	private String ingre_others01;
	private String ingre_others02;
	
	
	//생성자
	public ingreDto() {
		super();
	}


	
	//Getter and Setter
	public String getIngre_no() {
		return ingre_no;
	}


	public void setIngre_no(String ingre_no) {
		this.ingre_no = ingre_no;
	}


	public String getIngre_korname() {
		return ingre_korname;
	}


	public void setIngre_korname(String ingre_korname) {
		this.ingre_korname = ingre_korname;
	}


	public String getIngre_engname() {
		return ingre_engname;
	}


	public void setIngre_engname(String ingre_engname) {
		this.ingre_engname = ingre_engname;
	}


	public String getIngre_conts() {
		return ingre_conts;
	}


	public void setIngre_conts(String ingre_conts) {
		this.ingre_conts = ingre_conts;
	}


	public String getIngre_danger() {
		return ingre_danger;
	}


	public void setIngre_danger(String ingre_danger) {
		this.ingre_danger = ingre_danger;
	}


	public int getIngre_grade() {
		return ingre_grade;
	}


	public void setIngre_grade(int ingre_grade) {
		this.ingre_grade = ingre_grade;
	}


	public String getIngre_skintype() {
		return ingre_skintype;
	}


	public void setIngre_skintype(String ingre_skintype) {
		this.ingre_skintype = ingre_skintype;
	}


	public String getIngre_20() {
		return ingre_20;
	}


	public void setIngre_20(String ingre_20) {
		this.ingre_20 = ingre_20;
	}


	public String getIngre_20conts() {
		return ingre_20conts;
	}


	public void setIngre_20conts(String ingre_20conts) {
		this.ingre_20conts = ingre_20conts;
	}


	public String getIngre_allergy() {
		return ingre_allergy;
	}


	public void setIngre_allergy(String ingre_allergy) {
		this.ingre_allergy = ingre_allergy;
	}


	public String getIngre_others01() {
		return ingre_others01;
	}


	public void setIngre_others01(String ingre_others01) {
		this.ingre_others01 = ingre_others01;
	}


	public String getIngre_others02() {
		return ingre_others02;
	}


	public void setIngre_others02(String ingre_others02) {
		this.ingre_others02 = ingre_others02;
	}


	
	@Override
	public String toString() {
		return "ingreDto [ingre_no=" + ingre_no + ", ingre_korname=" + ingre_korname + ", ingre_engname="
				+ ingre_engname + ", ingre_conts=" + ingre_conts + ", ingre_danger=" + ingre_danger + ", ingre_grade="
				+ ingre_grade + ", ingre_skintype=" + ingre_skintype + ", ingre_20=" + ingre_20 + ", ingre_20conts="
				+ ingre_20conts + ", ingre_allergy=" + ingre_allergy + ", ingre_others01=" + ingre_others01
				+ ", ingre_others02=" + ingre_others02 + "]";
	}
	
	
	
	
	
	
	
}
