
package com.pcwk.ehr.menuscore;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.menuselect.MenuSelectVO;

public interface MenuScoreDao {
	public void menuScoreInsert(final MenuScoreVO score) throws Exception;
	public void menuScoreDelete(MenuScoreVO score) throws Exception;
	public void menuScoreUpdate(MenuScoreVO score) throws Exception;
	public int menuScoreAvg(MenuScoreVO score) throws Exception;
	public int menuScoreCount(MenuScoreVO score) throws Exception;

}
