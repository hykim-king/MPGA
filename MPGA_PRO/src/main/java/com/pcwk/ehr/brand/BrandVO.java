package com.pcwk.ehr.brand;

public class BrandVO {

	private String bCode;		//브랜드 번호
	private String bLogoImg;	//브랜드 로고
	private String bUrl;		//브랜드 사이트
	private String bItr;		//브랜드 소개
	private String bName;		//브랜드 이름
	private String modDt;		//수정날짜
	private int regNum;			//등록자
	
	public BrandVO() {}

	public BrandVO(String bCode, String bLogoImg, String bUrl, String bItr, String bName, String modDt, int regNum) {
		super();
		this.bCode = bCode;
		this.bLogoImg = bLogoImg;
		this.bUrl = bUrl;
		this.bItr = bItr;
		this.bName = bName;
		this.modDt = modDt;
		this.regNum = regNum;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public String getbLogoImg() {
		return bLogoImg;
	}

	public void setbLogoImg(String bLogoImg) {
		this.bLogoImg = bLogoImg;
	}

	public String getbUrl() {
		return bUrl;
	}

	public void setbUrl(String bUrl) {
		this.bUrl = bUrl;
	}

	public String getbItr() {
		return bItr;
	}

	public void setbItr(String bItr) {
		this.bItr = bItr;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	public int getRegNum() {
		return regNum;
	}

	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}

	@Override
	public String toString() {
		return "brandVO [bCode=" + bCode + ", bLogoImg=" + bLogoImg + ", bUrl=" + bUrl + ", bItr=" + bItr + ", bName="
				+ bName + ", modDt=" + modDt + ", regNum=" + regNum + ", toString()=" + super.toString() + "]";
	}
	
}
