package com.pcwk.ehr.cmn;

public class DTO {
	private int num;// 글 번호

	public DTO() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "DTO [num=" + num + "]";
	}	

}
