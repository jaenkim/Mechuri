package com.hk.mechuri.dtos;

import java.io.Serializable;
import java.util.Date;

public class productDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int product_no;
	private String product_name;
	private String product_ml;
	private String product_price;
	private String product_conts;
	private int product_compno;
	private String product_brand;
	private String product_catelname;
	private String product_catesname;
	private String product_skintype;
	private String product_skinconts;
	private String product_age;
	private String product_gender;
	private String product_ingre;
	private String product_like;
	private String product_review;
	private double product_point;
	private int product_pointcount;
	private int product_rank;
	private int product_fileno;
	private String product_originfile;
	private String product_storedfile;
	private Date product_fileregdate;
	private int product_filesize;
	private String product_flag;
	private String product_djflag;
	private String product_filedelflag;
	private Date product_regdate;
	private Date product_replacedate;
	private String product_others01;
	private String product_others02;
	
	//생성자
	public productDto() {super();}

	public productDto(int product_no, String product_ingre) {
		super();
		 this.product_no = product_no;
		 this.product_ingre = product_ingre;
	}
	
	
	//생성자1 승희
	public productDto(String product_name, String product_ml, String product_price, String product_conts,
			String product_catelname, String product_catesname, String product_skintype, String product_age,
			String product_gender, String product_ingre) {
		this.product_name = product_name;
		this.product_ml = product_ml;
		this.product_price = product_price;
		this.product_conts = product_conts;
		this.product_catelname = product_catelname;
		this.product_catesname = product_catesname;
		this.product_skintype = product_skintype;
		this.product_age = product_age;
		this.product_gender = product_gender;
		this.product_ingre = product_ingre;
	}

	
	//생성자2 승희
	

		public productDto(int product_compno,String product_catelname, String product_catesname, String product_name, String product_ml,
				String product_price, String product_conts, String product_ingre, String product_skintype,
				String product_age, String product_gender, String product_originfile, String product_storedfile,
				int product_filesize) {
			this.product_compno = product_compno;
			this.product_catelname=product_catelname;
			this.product_catesname=product_catesname;
			this.product_name=product_name;
			this.product_ml=product_ml;
			this.product_price=product_price;
			this.product_conts=product_conts;
			this.product_ingre=product_ingre;
			this.product_skintype=product_skintype;
			this.product_age=product_age;
			this.product_gender=product_gender;
			this.product_originfile=product_originfile;
			this.product_storedfile=product_storedfile;
			this.product_filesize=product_filesize;
		}

		//생성자3 승희
	public productDto(int product_compno, String product_catelname, String product_catesname,
				String product_name, String product_ml, String product_price, String product_conts,
				String product_ingre, String product_skintype, String product_age, String product_gender) {
	
		this.product_name = product_name;
		this.product_ml = product_ml;
		this.product_price = product_price;
		this.product_conts = product_conts;
		this.product_compno = product_compno;
		this.product_catelname = product_catelname;
		this.product_catesname = product_catesname;
		this.product_skintype = product_skintype;
		this.product_age = product_age;
		this.product_gender = product_gender;
		this.product_ingre = product_ingre;
		
	}

	//Getter and Setter
	public int getProduct_no() {	return product_no; }
	public void setProduct_no(int product_no) {	this.product_no = product_no;	}

	public String getProduct_name() {	return product_name;	}
	public void setProduct_name(String product_name) {	this.product_name = product_name;	}

	public String getProduct_ml() {	return product_ml;}
	public void setProduct_ml(String product_ml) {	this.product_ml = product_ml;	}

	public String getProduct_price() {	return product_price;	}
	public void setProduct_price(String product_price) {	this.product_price = product_price;	}

	public String getProduct_conts() {	return product_conts;}
	public void setProduct_conts(String product_conts) {	this.product_conts = product_conts;	}

	public int getProduct_compno() {	return product_compno;}
	public void setProduct_compno(int product_compno) {	this.product_compno = product_compno;}

	public String getProduct_brand() {	return product_brand;}
	public void setProduct_brand(String product_brand) {this.product_brand = product_brand;	}

	public String getProduct_catelname() {return product_catelname;}
	public void setProduct_catelname(String product_catelname) {this.product_catelname = product_catelname;}

	public String getProduct_catesname() {	return product_catesname;}
	public void setProduct_catesname(String product_catesname) {	this.product_catesname = product_catesname;	}

	public String getProduct_skintype() {	return product_skintype;	}
	public void setProduct_skintype(String product_skintype) {	this.product_skintype = product_skintype;	}

	public String getProduct_skinconts() {	return product_skinconts;	}
	public void setProduct_skinconts(String product_skinconts) {	this.product_skinconts = product_skinconts;	}

	public String getProduct_age() {	return product_age;	}
	public void setProduct_age(String product_age) {	this.product_age = product_age;	}

	public String getProduct_gender() {	return product_gender;	}
	public void setProduct_gender(String product_gender) {	this.product_gender = product_gender;}

	public String getProduct_ingre() {	return product_ingre;}
	public void setProduct_ingre(String product_ingre) {	this.product_ingre = product_ingre;	}

	public String getProduct_like() {return product_like;	}
	public void setProduct_like(String product_like) {	this.product_like = product_like;}

	public String getProduct_review() {return product_review;	}
	public void setProduct_review(String product_review) {	this.product_review = product_review;}

	public double getProduct_point() {	return product_point;	}
	public void setProduct_point(double product_point) {		this.product_point = product_point;	}

	public int getProduct_fileno() {	return product_fileno;	}
	public void setProduct_fileno(int product_fileno) {	this.product_fileno = product_fileno;}

	public String getProduct_originfile() {	return product_originfile;}
	public void setProduct_originfile(String product_originfile) {this.product_originfile = product_originfile;}

	public String getProduct_storedfile() {return product_storedfile;}
	public void setProduct_storedfile(String product_storedfile) { this.product_storedfile = product_storedfile;	}

	public Date getProduct_fileregdate() {	return product_fileregdate;	}
	public void setProduct_fileregdate(Date product_fileregdate) {	this.product_fileregdate = product_fileregdate; }

	public int getProduct_filesize() {	return product_filesize;	}
	public void setProduct_filesize(int product_filesize) { this.product_filesize = product_filesize; }

	public String getProduct_flag() {	return product_flag;	}
	public void setProduct_flag(String product_flag) {	this.product_flag = product_flag;}
	
	public String getProduct_djflag() {	return product_djflag;}
	public void setProduct_djflag(String product_djflag) {this.product_djflag = product_djflag;	}

	public String getProduct_filedelflag() {	return product_filedelflag;	}
	public void setProduct_filedelflag(String product_filedelflag) {	this.product_filedelflag = product_filedelflag;	}

	public Date getProduct_regdate() {	return product_regdate;	}
	public void setProduct_regdate(Date product_regdate) {	this.product_regdate = product_regdate;	}

	public Date getProduct_replacedate() {	return product_replacedate;	}
	public void setProduct_replacedate(Date product_replacedate) {	this.product_replacedate = product_replacedate;	}

	public String getProduct_others01() {return product_others01;	}
	public void setProduct_others01(String product_others01) {this.product_others01 = product_others01;}

	public String getProduct_others02() {return product_others02;	}
	public void setProduct_others02(String product_others02) {this.product_others02 = product_others02;}

	public int getProduct_pointcount() {return product_pointcount;}
	public void setProduct_pointcount(int product_pointcount) {	this.product_pointcount = product_pointcount;}

	public int getProduct_rank() {return product_rank;}
	public void setProduct_rank(int product_rank) {this.product_rank = product_rank;}



	@Override
	public String toString() {
		return "productDto [product_no=" + product_no + ", product_name=" + product_name + ", product_ml=" + product_ml
				+ ", product_price=" + product_price + ", product_conts=" + product_conts + ", product_compno="
				+ product_compno + ", product_brand=" + product_brand + ", product_catelname=" + product_catelname
				+ ", product_catesname=" + product_catesname + ", product_skintype=" + product_skintype
				+ ", product_skinconts=" + product_skinconts + ", product_age=" + product_age + ", product_gender="
				+ product_gender + ", product_ingre=" + product_ingre + ", product_like=" + product_like
				+ ", product_review=" + product_review + ", product_point=" + product_point + ", product_pointcount="
				+ product_pointcount + ", product_rank=" + product_rank + ", product_fileno=" + product_fileno
				+ ", product_originfile=" + product_originfile + ", product_storedfile=" + product_storedfile
				+ ", product_fileregdate=" + product_fileregdate + ", product_filesize=" + product_filesize
				+ ", product_flag=" + product_flag + ", product_djflag=" + product_djflag + ", product_filedelflag="
				+ product_filedelflag + ", product_regdate=" + product_regdate + ", product_replacedate="
				+ product_replacedate + ", product_others01=" + product_others01 + ", product_others02="
				+ product_others02 + "]";
	}

	

}
