package com.pcwk.ehr.mypage;

import com.pcwk.ehr.cmn.DTO;

public class MyPageVO extends DTO {
	
	private String profileImg;
	private String nickName;
	private String rank;
	private String selectDate;
	private String cLike;
	
	public MyPageVO() {
		super();
	}

	public MyPageVO(String profileImg, String nickName, String rank, String selectDate, String cLike) {
		super();
		this.profileImg = profileImg;
		this.nickName = nickName;
		this.rank = rank;
		this.selectDate = selectDate;
		this.cLike = cLike;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	public String getcLike() {
		return cLike;
	}

	public void setcLike(String cLike) {
		this.cLike = cLike;
	}

	@Override
	public String toString() {
		return "MyPageVO [profileImg=" + profileImg + ", nickName=" + nickName + ", rank=" + rank + ", selectDate="
				+ selectDate + ", cLike=" + cLike + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
