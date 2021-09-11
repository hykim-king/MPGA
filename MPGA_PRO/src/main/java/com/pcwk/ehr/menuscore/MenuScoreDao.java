
package com.pcwk.ehr.menuscore;

import java.sql.SQLException;
import java.util.List;

public interface MenuScoreDao {
	List<MenuScoreVO> getAll(MenuScoreVO grade);
	int getAvg(MenuScoreVO grade) throws ClassNotFoundException, SQLException;
	public int getCount(MenuScoreVO grade) throws ClassNotFoundException, SQLException;
	void deleteAll() throws SQLException;
	int doInsert(final MenuScoreVO grade) throws ClassNotFoundException, SQLException;
	int doDelete(MenuScoreVO grade) throws SQLException;
	int doUpdate(MenuScoreVO grade) throws SQLException;
}
