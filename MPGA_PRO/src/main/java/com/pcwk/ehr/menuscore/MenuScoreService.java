package com.pcwk.ehr.menuscore;

public interface MenuScoreService {

	//별점 등록
	void menuScoreInsert(MenuScoreVO score) throws Exception;

	//별점 삭제
	void menuScoreDelete(MenuScoreVO score) throws Exception;

	//별점 변경
	void menuScoreUpdate(MenuScoreVO score) throws Exception;

	//별점 평균
	int menuScoreAvg(MenuScoreVO score) throws Exception;

	//별점의 부여한 사람의 수
	int menuScoreCount(MenuScoreVO score) throws Exception;

}