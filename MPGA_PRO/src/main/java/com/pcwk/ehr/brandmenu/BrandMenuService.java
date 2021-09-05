package com.pcwk.ehr.brandmenu;

import java.sql.SQLException;
import java.util.List;

public interface BrandMenuService {

	BrandMenuVO doSelectOne(BrandMenuVO inVO) throws ClassNotFoundException, SQLException;

	int doInsert(BrandMenuVO brandmenu) throws ClassNotFoundException, SQLException;

	int doDelete(BrandMenuVO brandmenu) throws SQLException;

	int doUpdate(BrandMenuVO brandmenu) throws SQLException;

	List<?> doRetrieve(BrandMenuVO brandmenu) throws SQLException;

}