package com.pcwk.ehr.menuselect;

import java.sql.SQLException;
import java.util.List;

public interface MenuSelectDao {


	public void menuSelectInsert(MenuSelectVO select) throws Exception;

	public void menuSelectDelete(MenuSelectVO select) throws Exception;

    public List<MenuSelectVO> menuSelectRead(MenuSelectVO select) throws Exception;

}