package com.pcwk.ehr.member.domain;

import com.pcwk.ehr.DTO;
import com.pcwk.ehr.Level;

public class UserVO extends DTO {

	private String uId; // 사용자 ID
	private String name; // 사용자 이름
	private String passwd;// 비밀번호

	// 2021/08/25 추가컬럼
	// BASIC(1),SILVER(2),GOLD(3)
	private Level level;
	// u_level,
	private int login;// 로그인 회수

	private int recommend;// 추천

	// 2021/08/30 추가컬럼
	private String email;// 이메일
	private String regDt;// 등록일

	// default 생성자
	public UserVO() {
	}


	public UserVO(String uId, String name, String passwd, Level level, int login, int recommend, String email,
			String regDt) {
		super();
		this.uId = uId;
		this.name = name;
		this.passwd = passwd;
		this.level = level;
		this.login = login;
		this.recommend = recommend;
		this.email = email;
		this.regDt = regDt;
	}

	public String getuId() {
		return uId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	@Override
	public String toString() {
		return "UserVO [uId=" + uId + ", name=" + name + ", passwd=" + passwd + ", level=" + level + ", login=" + login
				+ ", recommend=" + recommend + ", email=" + email + ", regDt=" + regDt + ", toString()="
				+ super.toString() + "]";
	}

	public void upgradeLevel() {
		Level nextLevel = this.level.nextLevel();
		if (null == nextLevel) {
			throw new IllegalArgumentException(this.level + "은 업그레이드가 불가능 합니다.");
		} else {
			this.level = nextLevel;
		}

	}

}
