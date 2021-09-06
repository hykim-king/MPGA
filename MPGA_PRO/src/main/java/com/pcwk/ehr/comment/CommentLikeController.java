package com.pcwk.ehr.comment;

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
	CommentLikeServiceImpl brand;
	
	public CommentLikeController () {
	}
	
	@RequestMapping(value = "CommentLike/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(CommentLikeVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=====================================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=====================================");

		CommentLikeVO outVO = CommentLikeVO.doSelectOne(inVO);
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
