package com.pcwk.ehr.brand;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BrandController {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	BrandServiceImpl brand;
	
	public BrandController () {
	}
	
	@RequestMapping(value = "brand/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(BrandVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=====================================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=====================================");

		BrandVO outVO = brand.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		model.addAttribute("vo", outVO);

		return "brand/brand_mng";
	}

	public String doInsert(BrandVO brand) throws ClassNotFoundException, SQLException {
		return "";
	}

	public String doDelete(BrandVO brand) throws SQLException {
		return "";
	}

	public String doUpdate(BrandVO brand) throws SQLException {
		return "";
	}
	
	public String doRetrieve(BrandVO brand) throws SQLException{
		return "";
	}	
}
