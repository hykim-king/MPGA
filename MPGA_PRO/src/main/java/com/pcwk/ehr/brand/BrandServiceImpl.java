package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pcwk.ehr.selectedmenu.SelectedMenuVO;

public class BrandServiceImpl {

	@Autowired
	BrandDao dBrandDao;
	
	public BrandServiceImpl() {
	}

	public int doInsert(final SelectedMenuVO select) throws ClassNotFoundException, SQLException {
		return dBrandDao.doInsert(select);
	}
	
	public BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException {
		return dBrandDao.doSelectOne(inVO);
	}

	
	public int doInsert(BrandVO brand) throws ClassNotFoundException, SQLException {
		return dBrandDao.doInsert(brand);
	}

	
	public int doDelete(BrandVO brand) throws SQLException {
		return dBrandDao.doDelete(brand);
	}

	
	public int doUpdate(BrandVO brand) throws SQLException {
		return dBrandDao.doUpdate(brand);
	}

	
	public List<?> doRetrieve(BrandVO brand) throws SQLException {
		return dBrandDao.doRetrieve(brand);
	}

}
