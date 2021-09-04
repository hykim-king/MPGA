package com.mpga.ehr.comment;

public class MenuCommentVO {
	
	private int seq;			//순번
	private String menuNum;		//메뉴번호
	private int memberNum;		//회원번호
	private String contents;	//내용
	private String regDt;		//등록일
	
	public MenuCommentVO() {}

	public MenuCommentVO(int seq, String menuNum, int memberNum, String contents, String regDt) {
		super();
		this.seq = seq;
		this.menuNum = menuNum;
		this.memberNum = memberNum;
		this.contents = contents;
		this.regDt = regDt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "CommentVO [seq=" + seq + ", menuNum=" + menuNum + ", memberNum=" + memberNum + ", contents=" + contents
				+ ", regDt=" + regDt + ", toString()=" + super.toString() + "]";
	}
	
	
}
