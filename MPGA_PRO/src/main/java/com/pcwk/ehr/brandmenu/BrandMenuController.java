package com.pcwk.ehr.brandmenu;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BrandMenuController {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	BrandMenuServiceImpl brandmenu;
	
	public BrandMenuController () {
	}
	
	@RequestMapping(value = "brandmenu/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(BrandMenuVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=====================================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=====================================");

		BrandMenuVO outVO = brandmenu.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		model.addAttribute("vo", outVO);

		return "brand/brand_mng";
	}

	public String doInsert(BrandMenuVO brandmenu) throws ClassNotFoundException, SQLException {
		return "";
	}

	public String doDelete(BrandMenuVO brandmenu) throws SQLException {
		return "";
	}

	public String doUpdate(BrandMenuVO brandmenu) throws SQLException {
		return "";
	}
	
	public String doRetrieve(BrandMenuVO brandmenu) throws SQLException{
		return "";
	}	
}
