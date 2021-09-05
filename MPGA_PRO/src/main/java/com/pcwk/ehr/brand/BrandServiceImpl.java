package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDao dBrandDao;

	public BrandServiceImpl() {
	}

	@Override
	public BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException {
		return dBrandDao.doSelectOne(inVO);
	}

	@Override
	public int doInsert(BrandVO brand) throws ClassNotFoundException, SQLException {
		return dBrandDao.doInsert(brand);
	}

	@Override
	public int doDelete(BrandVO brand) throws SQLException {
		return dBrandDao.doDelete(brand);
	}

	@Override
	public int doUpdate(BrandVO brand) throws SQLException {
		return dBrandDao.doUpdate(brand);
	}

	@Override
	public List<?> doRetrieve(BrandVO brand) throws SQLException {
		return dBrandDao.doRetrieve(brand);
	}

}
