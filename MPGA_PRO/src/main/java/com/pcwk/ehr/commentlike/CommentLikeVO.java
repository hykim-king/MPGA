package com.pcwk.ehr.commentlike;

public class CommentLikeVO {
	

	private int memberNum;		//회원번호
	private int seq;			//순번
	private String cLike;		//추천
	private String cLikeDate;	//추천날짜
	
	public CommentLikeVO() {}
	
	public CommentLikeVO(int memberNum, int seq, String cLike, String cLikeDate) {
		super();
		this.memberNum = memberNum;
		this.seq = seq;
		this.cLike = cLike;
		this.cLikeDate = cLikeDate;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getcLike() {
		return cLike;
	}

	public void setcLike(String cLike) {
		this.cLike = cLike;
	}

	public String getcLikeDate() {
		return cLikeDate;
	}

	public void setcLikeDate(String cLikeDate) {
		this.cLikeDate = cLikeDate;
	}

	@Override
	public String toString() {
		return "CommentLikeVO [memberNum=" + memberNum + ", seq=" + seq + ", cLike=" + cLike + ", cLikeDate="
				+ cLikeDate + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
