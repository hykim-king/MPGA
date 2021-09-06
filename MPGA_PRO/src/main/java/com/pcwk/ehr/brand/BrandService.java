package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

public interface BrandService {

	BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException;

	int doInsert(BrandVO brand) throws ClassNotFoundException, SQLException;

	int doDelete(BrandVO brand) throws SQLException;

	int doUpdate(BrandVO brand) throws SQLException;

	List<?> doRetrieve(BrandVO brand) throws SQLException;

}