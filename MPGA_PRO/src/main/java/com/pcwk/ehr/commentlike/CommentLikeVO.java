package com.pcwk.ehr.commentlike;

public class CommentLikeVO {
	
	private int cLike;			//추천
	private int memberNum;		//회원번호
	private int seq;			//순번
	
	
	public CommentLikeVO() {}


	public CommentLikeVO(int cLike, int memberNum, int seq) {
		super();
		this.cLike = cLike;
		this.memberNum = memberNum;
		this.seq = seq;
	}


	public int getcLike() {
		return cLike;
	}


	public void setcLike(int cLike) {
		this.cLike = cLike;
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


	@Override
	public String toString() {
		return "CommentLikeVO [cLike=" + cLike + ", memberNum=" + memberNum + ", seq=" + seq + ", toString()="
				+ super.toString() + "]";
	}
	

	
}
