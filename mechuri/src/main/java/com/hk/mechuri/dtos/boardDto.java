package com.hk.mechuri.dtos;

import java.util.Date;

public class boardDto {
	
	private int board_no;
	private String board_nick;
	private String board_title;
	private String board_conts;
	private Date board_regdate;
	private int board_count;
	private int board_fileno;
	private String board_originfile;
	private String board_storedfile;
	private Date board_fileregdate;
	private int board_filesize;
	private String board_filedelflag;
	private String board_refer;
	private String board_step;
	private String board_pnum;
	private String board_new;
	
	
	
	
	
	
//	디폴트생성자는 꼭 있어야함
//	메서드 오버로딩시 같은 이름으로 쓸 수 있는 대신에 아규먼트가 들어간거 그러면 오버로딩은 이름을 아낄 수 있음
//	이게 서브스트링에도 적용됨
//	생성자도 오버로딩 할 수 있음
//	보통 클래스를 만들면 
//	클래스를 만들면  a라는 생성자가 생략되있음
//	우리가 객체를 생성할 ㄸ
//	자식을 생성하면 부모의 클래스 객체도 생성됨	


	public boardDto() { super();	} //얘는 디폴트생성자, 오버로딩 할 때 꼭 필요 , 슈퍼는 부모생성자 this는 자기자신, from superclass
	
	
	
	

	//using field
	public boardDto(int board_no, String board_nick, String board_title, String board_conts, Date board_regdate,
			int board_count, int board_fileno, String board_originfile, String board_storedfile, Date board_fileregdate,
			int board_filesize, String board_filedelflag, String board_refer, String board_step, String board_pnum) {
		super();
		this.board_no = board_no;
		this.board_nick = board_nick;
		this.board_title = board_title;
		this.board_conts = board_conts;
		this.board_regdate = board_regdate;
		this.board_count = board_count;
		this.board_fileno = board_fileno;
		this.board_originfile = board_originfile;
		this.board_storedfile = board_storedfile;
		this.board_fileregdate = board_fileregdate;
		this.board_filesize = board_filesize;
		this.board_filedelflag = board_filedelflag;
		this.board_refer = board_refer;
		this.board_step = board_step;
		this.board_pnum = board_pnum;
		
	
	}


	public boardDto(String board_nick,String board_title, String board_conts, String board_originfile, String board_storedfile, int board_filesize) {
		super();
		this.board_nick = board_nick;
		this.board_title = board_title;
		this.board_conts = board_conts;
		this.board_originfile = board_originfile;
		this.board_storedfile = board_storedfile;
		this.board_filesize = board_filesize;
	}

	public boardDto(String nick,String title, String content) {
		super();
		this.board_nick = nick;
		this.board_title = title;
		this.board_conts = content;
	}



	public boardDto(int isS, int board_no, String writernick, String titlename, String content,
			String board_storedfile) {
		super();
		this.board_no = board_no;
	}





	public boardDto(int board_no, String board_nick, String board_title, String board_conts, String board_storedfile,
			String board_originfile, int board_filesize) {
		super();
		this.board_no = board_no;
		this.board_nick = board_nick;
		this.board_title = board_title;
		this.board_conts = board_conts;
		this.board_originfile = board_originfile;
		this.board_storedfile = board_storedfile;
		this.board_filesize = board_filesize;
	}





	public int getBoard_no() {
		return board_no;
	}


	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}


	public String getBoard_nick() {
		return board_nick;
	}


	public void setBoard_nick(String board_nick) {
		this.board_nick = board_nick;
	}


	public String getBoard_title() {
		return board_title;
	}


	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}


	public String getBoard_conts() {
		return board_conts;
	}


	public void setBoard_conts(String board_conts) {
		this.board_conts = board_conts;
	}


	public Date getBoard_regdate() {
		return board_regdate;
	}


	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}


	public int getBoard_count() {
		return board_count;
	}


	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}


	public int getBoard_fileno() {
		return board_fileno;
	}


	public void setBoard_fileno(int board_fileno) {
		this.board_fileno = board_fileno;
	}


	public String getBoard_originfile() {
		return board_originfile;
	}


	public void setBoard_originfile(String board_originfile) {
		this.board_originfile = board_originfile;
	}


	public String getBoard_storedfile() {
		return board_storedfile;
	}


	public void setBoard_storedfile(String board_storedfile) {
		this.board_storedfile = board_storedfile;
	}


	public Date getBoard_fileregdate() {
		return board_fileregdate;
	}


	public void setBoard_fileregdate(Date board_fileregdate) {
		this.board_fileregdate = board_fileregdate;
	}


	public int getBoard_filesize() {
		return board_filesize;
	}


	public void setBoard_filesize(int board_filesize) {
		this.board_filesize = board_filesize;
	}


	public String getBoard_filedelflag() {
		return board_filedelflag;
	}


	public void setBoard_filedelflag(String board_filedelflag) {
		this.board_filedelflag = board_filedelflag;
	}
	
	

	

	public String getBoard_new() {
		return board_new;
	}





	public void setBoard_new(String board_new) {
		this.board_new = board_new;
	}





	public String board_refer() {
		return board_refer;
	}


	public void board_refer(String board_refer) {
		this.board_refer = board_refer;
	}


	public String board_step() {
		return board_step;
	}


	public void board_step(String board_step) {
		this.board_step = board_step;
	}
	
	
	public String board_pnum() {
		return board_pnum;
	}


	public void board_pnum(String board_pnum) {
		this.board_pnum = board_pnum;
	}
	


	@Override
	public String toString() {
		return "boardDto [board_no=" + board_no + ", board_nick=" + board_nick + ", board_title=" + board_title
				+ ", board_conts=" + board_conts + ", board_regdate=" + board_regdate + ", board_count=" + board_count
				+ ", board_fileno=" + board_fileno + ", board_originfile="
				+ board_originfile + ", board_storedfile=" + board_storedfile + ", board_fileregdate="
				+ board_fileregdate + ", board_filesize=" + board_filesize + ", board_filedelflag=" + board_filedelflag
				+ ", board_refer=" + board_refer + ", board_step=" + board_step + ", board_pnum=" + board_pnum + "]";
	}
	
}






