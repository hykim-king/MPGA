package com.pcwk.ehr.menuscore;

public class MenuScoreVO {
	
	private int memberNum;	    //회원번호
	private String menuNum;		//메뉴번호
	private int score;		    //별점
	private String scoreDt;		//별점 준 날짜
	
	public MenuScoreVO() {}
	
	public MenuScoreVO(int memberNum, String menuNum, int score, String scoreDt) {
		super();
		this.memberNum = memberNum;
		this.menuNum = menuNum;
		this.score = score;
		this.scoreDt = scoreDt;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getScoreDt() {
		return scoreDt;
	}

	public void setScoreDt(String scoreDt) {
		this.scoreDt = scoreDt;
	}

	@Override
	public String toString() {
		return "MenuGradeVO [memberNum=" + memberNum + ", menuNum=" + menuNum + ", score=" + score + ", scoreDt="
				+ scoreDt + ", toString()=" + super.toString() + "]";
	}


}
