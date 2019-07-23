package com.hk.mechuri.dtos;

import java.util.Date;

public class tempinfoDto {

	private int tempinfo_no;
	private String tempinfo_name;
	private String tempinfo_ml;
	private String tempinfo_price;
	private String tempinfo_conts;
	private String tempinfo_skintype;
	private String tempinfo_age;
	private String tempinfo_gender;
	private String tempinfo_ingre;
	private String tempinfo_originfile;
	private String tempinfo_storedfile;
	private Date tempinfo_fileregdate;
	private int tempinfo_filesize;
	private String tempinfo_others01;
	private String tempinfo_others02;
	
	//생성자
		public tempinfoDto() {
			super();
		}

		//생성자2 승희
		public tempinfoDto(int tempinfo_no, String tempinfo_name, String tempinfo_ml, String tempinfo_price, String tempinfo_conts,
				String tempinfo_ingre, String tempinfo_skintype, String tempinfo_age, String tempinfo_gender, String tempinfo_storedfile,String tempinfo_originfile, int tempinfo_filesize) {
			
			this.tempinfo_no = tempinfo_no;
			this.tempinfo_name = tempinfo_name;
			this.tempinfo_ml = tempinfo_ml;
			this.tempinfo_price = tempinfo_price;
			this.tempinfo_conts = tempinfo_conts;
			this.tempinfo_skintype = tempinfo_skintype;
			this.tempinfo_age = tempinfo_age;
			this.tempinfo_gender = tempinfo_gender;
			this.tempinfo_ingre = tempinfo_ingre;
			this.tempinfo_originfile = tempinfo_originfile;
			this.tempinfo_storedfile = tempinfo_storedfile;
			this.tempinfo_filesize = tempinfo_filesize;
		}
	//Getter and Setter
	public int getTempinfo_no() {
		return tempinfo_no;
	}

	public void setTempinfo_no(int tempinfo_no) {
		this.tempinfo_no = tempinfo_no;
	}

	public String getTempinfo_name() {
		return tempinfo_name;
	}

	public void setTempinfo_name(String tempinfo_name) {
		this.tempinfo_name = tempinfo_name;
	}

	public String getTempinfo_ml() {
		return tempinfo_ml;
	}

	public void setTempinfo_ml(String tempinfo_ml) {
		this.tempinfo_ml = tempinfo_ml;
	}

	public String getTempinfo_price() {
		return tempinfo_price;
	}

	public void setTempinfo_price(String tempinfo_price) {
		this.tempinfo_price = tempinfo_price;
	}

	public String getTempinfo_conts() {
		return tempinfo_conts;
	}

	public void setTempinfo_conts(String tempinfo_conts) {
		this.tempinfo_conts = tempinfo_conts;
	}

	public String getTempinfo_skintype() {
		return tempinfo_skintype;
	}

	public void setTempinfo_skintype(String tempinfo_skintype) {
		this.tempinfo_skintype = tempinfo_skintype;
	}

	public String getTempinfo_age() {
		return tempinfo_age;
	}

	public void setTempinfo_age(String tempinfo_age) {
		this.tempinfo_age = tempinfo_age;
	}

	public String getTempinfo_gender() {
		return tempinfo_gender;
	}

	public void setTempinfo_gender(String tempinfo_gender) {
		this.tempinfo_gender = tempinfo_gender;
	}

	public String getTempinfo_ingre() {
		return tempinfo_ingre;
	}

	public void setTempinfo_ingre(String tempinfo_ingre) {
		this.tempinfo_ingre = tempinfo_ingre;
	}

	public String getTempinfo_originfile() {
		return tempinfo_originfile;
	}

	public void setTempinfo_originfile(String tempinfo_originfile) {
		this.tempinfo_originfile = tempinfo_originfile;
	}

	public String getTempinfo_storedfile() {
		return tempinfo_storedfile;
	}

	public void setTempinfo_storedfile(String tempinfo_storedfile) {
		this.tempinfo_storedfile = tempinfo_storedfile;
	}

	public Date getTempinfo_fileregdate() {
		return tempinfo_fileregdate;
	}

	public void setTempinfo_fileregdate(Date tempinfo_fileregdate) {
		this.tempinfo_fileregdate = tempinfo_fileregdate;
	}

	public int getTempinfo_filesize() {
		return tempinfo_filesize;
	}

	public void setTempinfo_filesize(int tempinfo_filesize) {
		this.tempinfo_filesize = tempinfo_filesize;
	}

	public String getTempinfo_others01() {
		return tempinfo_others01;
	}

	public void setTempinfo_others01(String tempinfo_others01) {
		this.tempinfo_others01 = tempinfo_others01;
	}

	public String getTempinfo_others02() {
		return tempinfo_others02;
	}

	public void setTempinfo_others02(String tempinfo_others02) {
		this.tempinfo_others02 = tempinfo_others02;
	}


	
	@Override
	public String toString() {
		return "tempinfoDto [tempinfo_no=" + tempinfo_no + ", tempinfo_name=" + tempinfo_name + ", tempinfo_ml="
				+ tempinfo_ml + ", tempinfo_price=" + tempinfo_price + ", tempinfo_conts=" + tempinfo_conts
				+ ", tempinfo_skintype=" + tempinfo_skintype + ", tempinfo_age=" + tempinfo_age + ", tempinfo_gender="
				+ tempinfo_gender + ", tempinfo_ingre=" + tempinfo_ingre + ", tempinfo_originfile="
				+ tempinfo_originfile + ", tempinfo_storedfile=" + tempinfo_storedfile + ", tempinfo_fileregdate="
				+ tempinfo_fileregdate + ", tempinfo_filesize=" + tempinfo_filesize + ", tempinfo_others01="
				+ tempinfo_others01 + ", tempinfo_others02=" + tempinfo_others02 + "]";
	}
	
	
	
	
	
	
	
}
