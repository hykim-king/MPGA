package com.pcwk.ehr.commentlike;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class CommentLikeController {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	CommentLikeService service;
	     
	public CommentLikeController () {
	}
	
	@RequestMapping(value = "CommentLike/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(CommentLikeVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=====================================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=====================================");

		CommentLikeVO outVO = service.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		model.addAttribute("vo", outVO);

		return "CommentLike/CommentLike_mng";
	}

	public String doInsert(CommentLikeVO comment) throws ClassNotFoundException, SQLException {
		return "";
	}

	public String doDelete(CommentLikeVO comment) throws SQLException {
		return "";
	}

	public String doUpdate(CommentLikeVO comment) throws SQLException {
		return "";
	}
	
}
