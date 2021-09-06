package com.pcwk.ehr.profile;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProfileImgController {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	ProfileImgService service;

	public ProfileImgController() {
	}

	@RequestMapping(value = "profileImg/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(ProfileImgVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=====================================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=====================================");

		ProfileImgVO outVO = service.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		model.addAttribute("vo", outVO);

		return "profileImg/profileImg_mng";
	}

	public String doInsert(final ProfileImgVO img) throws ClassNotFoundException, SQLException {
		return "";
	}

	public String doDelete(ProfileImgVO img) throws SQLException {
		return "";
	}

	public String doUpdate(ProfileImgVO img) throws SQLException {
		return "";
	}

	public String doRetrieve(ProfileImgVO img) throws SQLException {
		return "";
	}
}
