package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pcwk.ehr.SearchVO;

public class BrandServiceImpl {
	
	final Logger LOG = LoggerFactory.getLogger(BrandServiceImpl.class);
	
	@Autowired
	private BrandDaoImpl brandDao;
	
	public BrandServiceImpl() {}
	
	
	public List<?> doRetrieve(SearchVO searchVO) throws SQLException{
		return brandDao.doRetrieve(searchVO);
		}
	
	public BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException{
		return brandDao.doSelectOne(inVO);
		}
	
	public int doUpdate(BrandVO brand) throws SQLException{
		return brandDao.doUpdate(brand);
		}
	
	public int doDelete(BrandVO brand) throws SQLException{
		return brandDao.doDelete(brand);
		}
	
	public int doInsert(BrandVO brand) throws ClassNotFoundException, SQLException{
		return brandDao.doInsert(brand);
		}

	}
