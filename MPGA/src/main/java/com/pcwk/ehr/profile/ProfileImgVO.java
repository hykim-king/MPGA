package com.pcwk.ehr.profile;

public class ProfileImgVO {

	private int seq;			//프로필 순번
	private String proImgPath;	//프로필이미지경로
	private String modDt;		//수정날짜
	private int regNum;			//등록자
	
	public ProfileImgVO() {}

	public ProfileImgVO(int seq, String proImgPath, String modDt, int regNum) {
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
