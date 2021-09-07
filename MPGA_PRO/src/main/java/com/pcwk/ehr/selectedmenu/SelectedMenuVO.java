package com.pcwk.ehr.selectedmenu;

public class SelectedMenuVO {
	
	public SelectedMenuVO() {
	}

	private int memberNum; // 회원번호
	private String menuNum; // 메뉴번호
	private String selectDt; // 찜한 날짜
	
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
	public String getRegDt() {
		return selectDt;
	}
	public void setSelectDt(String selectDt) {
		this.selectDt = selectDt;
	}
	@Override
	public String toString() {
		return "SelectedMenuVO [memberNum=" + memberNum + ", menuNum=" + menuNum + ", selectDt=" + selectDt + ", toString()="
				+ super.toString() + "]";
	}

	
}
