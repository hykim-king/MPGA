package com.pcwk.ehr.notice.domain;


public class NoticeVO {
	private Integer seq;
	private String title;
	private String contents;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private String reg_dt;
		
	private Integer reg_num;
	private Integer board_cfc;
	
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
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
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Integer getReg_num() {
		return reg_num;
	}
	public void setReg_num(Integer reg_num) {
		this.reg_num = reg_num;
	}
	public Integer getBoard_cfc() {
		return board_cfc;
	}
	public void setBoard_cfc(Integer board_cfc) {
		this.board_cfc = board_cfc;
	}
	@Override
	public String toString() {
		return "NoticeVO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", reg_dt=" + reg_dt
				+ ", reg_num=" + reg_num + ", board_cfc=" + board_cfc + "]";
	}
	public NoticeVO() {
		
	}
	
	public NoticeVO(Integer seq, String title, String contents, String reg_dt, Integer reg_num, Integer board_cfc) {
		
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.reg_dt = reg_dt;
		this.reg_num = reg_num;
		this.board_cfc = board_cfc;
	}
	
	
}
