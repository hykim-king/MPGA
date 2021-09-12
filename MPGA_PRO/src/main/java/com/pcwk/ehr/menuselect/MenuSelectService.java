package com.pcwk.ehr.menuselect;

import java.util.List;

public interface MenuSelectService {

	//찜 등록
	void menuSelectInsert(MenuSelectVO select) throws Exception;

	//찜 취소
	void menuSelectDelete(MenuSelectVO select) throws Exception;

	List<MenuSelectVO> menuSelectRead(MenuSelectVO select) throws Exception;

}