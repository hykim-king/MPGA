package com.mpga.java;

import java.util.Date;

public class Notice {
	private int seq, reg_num, board_cfc;
	private String title, contents;
	private Date reg_dt;
	
	public Notice() {
		
	}
	
	@Override
	public String toString() {
		return "Notice [seq=" + seq + ", reg_num=" + reg_num + ", board_cfc=" + board_cfc + ", title=" + title
				+ ", contents=" + contents + ", reg_dt=" + reg_dt + "]";
	}

	public Notice(int seq, int reg_num, int board_cfc, String title, String contents, Date reg_dt) {
		super();
		this.seq = seq;
		this.reg_num = reg_num;
		this.board_cfc = board_cfc;
		this.title = title;
		this.contents = contents;
		this.reg_dt = reg_dt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getReg_num() {
		return reg_num;
	}
	public void setReg_num(int reg_num) {
		this.reg_num = reg_num;
	}
	public int getBoard_cfc() {
		return board_cfc;
	}
	public void setBoard_cfc(int board_cfc) {
		this.board_cfc = board_cfc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
}
