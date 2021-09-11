package com.pcwk.ehr.brandmenu;

public class BrandMenuVO {
	
	private String menuNum;			//메뉴번호 
	private String bCode;			//브랜드 번호
	private String menuName;		//메뉴명 
	private String menuInfo;			//메뉴 정보 
	private String menuImg;			//메뉴 사진 
	private String menuRegDate;			//메뉴 등록 날짜 
	private String modDt;			//수정날짜
	private int    regNum;			//등록자
	
	public BrandMenuVO() {}

	public BrandMenuVO(String menuNum, String bCode, String menuName, String menuInfo, String menuImg,
			String menuRegDate, String modDt, int regNum) {
		super();
		this.menuNum = menuNum;
		this.bCode = bCode;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.menuImg = menuImg;
		this.menuRegDate = menuRegDate;
		this.modDt = modDt;
		this.regNum = regNum;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String getMenuRegDate() {
		return menuRegDate;
	}

	public void setMenuRegDate(String menuRegDate) {
		this.menuRegDate = menuRegDate;
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
		return "BrandMenuVO [menuNum=" + menuNum + ", bCode=" + bCode + ", menuName=" + menuName + ", menuInfo="
				+ menuInfo + ", menuImg=" + menuImg + ", menuRegDate=" + menuRegDate + ", modDt=" + modDt + ", regNum="
				+ regNum + ", toString()=" + super.toString() + "]";
	}



}

