
package com.pcwk.ehr.menugrade;

import java.sql.SQLException;
import java.util.List;

public interface MenuGradeDao {
	List<MenuGradeVO> getAll(MenuGradeVO grade);
	int getAvg(MenuGradeVO grade) throws ClassNotFoundException, SQLException;
	public int getCount(MenuGradeVO grade) throws ClassNotFoundException, SQLException;
	void deleteAll() throws SQLException;
	int doInsert(final MenuGradeVO grade) throws ClassNotFoundException, SQLException;
	int doDelete(MenuGradeVO grade) throws SQLException;
	int doUpdate(MenuGradeVO grade) throws SQLException;
}
