package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

public interface BrandService {

	public BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException;

	public int doInsert(BrandVO brand) throws ClassNotFoundException, SQLException;

	public int doDelete(BrandVO brand) throws SQLException;

	public int doUpdate(BrandVO brand) throws SQLException;

	public List<?> doRetrieve(BrandVO brand) throws SQLException;

}