package com.pcwk.ehr.menuselect;

import java.sql.SQLException;
import java.util.List;

public interface MenuSelectDao {


	int menuSelectInsert(MenuSelectVO select) throws Exception;

	int menuSelectDelete(MenuSelectVO select) throws Exception;

    List<MenuSelectVO> menuSelectRead(MenuSelectVO select) throws Exception;

}