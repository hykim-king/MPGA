package com.pcwk.ehr.brandmenu;

public class BrandMenuVO {
	
	private String mNum; 			//메뉴번호 
	private String bCode;			//브랜드 번호
	private String mName;			//메뉴명 
	private String mInfo;			//메뉴 정보 
	private String mImg;			//메뉴 사진 
	private String mRegdt;			//메뉴 등록 날짜 
	private String modDt;			//수정날짜
	private int    regNum;			//등록자
	
	public BrandMenuVO() {}


	public BrandMenuVO(String mNum, String bCode, String mName, String mInfo, String mImg, String mRegdt, String modDt,
			int regNum) {
		super();
		this.mNum = mNum;
		this.bCode = bCode;
		this.mName = mName;
		this.mInfo = mInfo;
		this.mImg = mImg;
		this.mRegdt = mRegdt;
		this.modDt = modDt;
		this.regNum = regNum;
	}


	public String getmNum() {
		return mNum;
	}


	public void setmNum(String mNum) {
		this.mNum = mNum;
	}


	public String getbCode() {
		return bCode;
	}


	public void setbCode(String bCode) {
		this.bCode = bCode;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getmInfo() {
		return mInfo;
	}


	public void setmInfo(String mInfo) {
		this.mInfo = mInfo;
	}


	public String getmImg() {
		return mImg;
	}


	public void setmImg(String mImg) {
		this.mImg = mImg;
	}


	public String getmRegdt() {
		return mRegdt;
	}


	public void setmRegdt(String mRegdt) {
		this.mRegdt = mRegdt;
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
		return "BrandMenuVO [mNum=" + mNum + ", bCode=" + bCode + ", mName=" + mName + ", mInfo=" + mInfo + ", mImg="
				+ mImg + ", mRegdt=" + mRegdt + ", modDt=" + modDt + ", regNum=" + regNum + ", toString()="
				+ super.toString() + "]";
	}
}

