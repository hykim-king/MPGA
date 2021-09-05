package com.pcwk.ehr.comment;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MenuCommentController {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	MenuCommentService service;

	public MenuCommentController() {
	}

	@RequestMapping(value = "profileImg/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(MenuCommentVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=====================================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=====================================");

		MenuCommentVO outVO = service.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		model.addAttribute("vo", outVO);

		return "profileImg/profile_mng";
	}

	public String doInsert(final MenuCommentVO comment) throws ClassNotFoundException, SQLException {
		return "";
	}

	public String doDelete(MenuCommentVO comment) throws SQLException {
		return "";
	}

	public String doUpdate(MenuCommentVO comment) throws SQLException {
		return "";
	}

	public String doRetrieve(MenuCommentVO comment) throws SQLException {
		return "";
	}
}
