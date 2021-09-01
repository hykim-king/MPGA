package com.pcwk.ehr.profile;

public class ProfileImg {

	private int seq;
	private String proImgPath;
	private String modDt;
	private int regNum;
	
	public ProfileImg() {}

	public ProfileImg(int seq, String proImgPath, String modDt, int regNum) {
		super();
		this.seq = seq;
		this.proImgPath = proImgPath;
		this.modDt = modDt;
		this.regNum = regNum;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getProImgPath() {
		return proImgPath;
	}

	public void setProImgPath(String proImgPath) {
		this.proImgPath = proImgPath;
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
		return "ProfileImg [seq=" + seq + ", proImgPath=" + proImgPath + ", modDt=" + modDt + ", regNum=" + regNum
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
