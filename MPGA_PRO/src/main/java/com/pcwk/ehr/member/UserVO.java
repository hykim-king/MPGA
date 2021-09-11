package com.pcwk.ehr.member;

import com.pcwk.ehr.Rank;
import com.pcwk.ehr.cmn.DTO;

import java.util.logging.Level;



public class UserVO extends DTO {
	
	private int memberNum;
	private int seq;
	private String id;
	private String nickName;
	private String phoneNum;
	private String email;
	private String pw;
	private String birthday;
	private String sex;
	private String modDt;
	private int regNum;
	private Rank rank;
	
	public UserVO() {}

	public UserVO(int memberNum, int seq, String id, String nickName, String phoneNum, String email, String pw,
			String birthday, String sex, String modDt, int regNum, Rank rank) {
		super();
		this.memberNum = memberNum;
		this.seq = seq;
		this.id = id;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.pw = pw;
		this.birthday = birthday;
		this.sex = sex;
		this.modDt = modDt;
		this.regNum = regNum;
		this.rank = rank;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "UserVO [memberNum=" + memberNum + ", seq=" + seq + ", id=" + id + ", nickName=" + nickName
				+ ", phoneNum=" + phoneNum + ", email=" + email + ", pw=" + pw + ", birthday=" + birthday + ", sex="
				+ sex + ", modDt=" + modDt + ", regNum=" + regNum + ", rank=" + rank + ", toString()="
				+ super.toString() + "]";
	}

	
	public void upgradeLevel() {
		Rank nextRank = this.rank.nextRank();
		if (null == nextRank) {
			throw new IllegalArgumentException(this.rank + "은 업그레이드가 불가능 합니다.");
		} else {
			this.rank = nextRank;
		}

	}
	
	

}
