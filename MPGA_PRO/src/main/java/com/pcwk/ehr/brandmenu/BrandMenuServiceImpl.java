package com.pcwk.ehr.brandmenu;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BrandMenuServiceImpl implements BrandMenuService {

	@Autowired
	BrandMenuDao dBrandMenuDao;

	public BrandMenuServiceImpl() {
	}

	@Override
	public BrandMenuVO doSelectOne(BrandMenuVO inVO) throws ClassNotFoundException, SQLException {
		return dBrandMenuDao.doSelectOne(inVO);
	}

	@Override
	public int doInsert(BrandMenuVO brandmenu) throws ClassNotFoundException, SQLException {
		return dBrandMenuDao.doInsert(brandmenu);
	}

	@Override
	public int doDelete(BrandMenuVO brandmenu) throws SQLException {
		return dBrandMenuDao.doUpdate(brandmenu);
	}

	@Override
	public int doUpdate(BrandMenuVO brandmenu) throws SQLException {
		return dBrandMenuDao.doUpdate(brandmenu);
	}

	@Override
	public List<?> doRetrieve(BrandMenuVO brandmenu) throws SQLException {
		return dBrandMenuDao.doRetrieve(brandmenu);
	}

}
