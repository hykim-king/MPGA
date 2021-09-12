package com.pcwk.ehr;

public class SearchMineVO extends DTO {

	private int member_num;	  //회원번호
	private int pageSize;  	  //페이지 사이즈
	private int pageNum;      //페이지 번호
	
	public SearchMineVO() {}

	public SearchMineVO(int member_num, int pageSize, int pageNum) {
		super();
		this.member_num = member_num;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "SearchMineVO [member_num=" + member_num + ", pageSize=" + pageSize + ", pageNum=" + pageNum
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
