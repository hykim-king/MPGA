package com.pcwk.ehr.comment;

import java.sql.SQLException;

public class MenuCommentDaoImpl {

	final Logger LOG = Logger.
	
	public int doInsert(final CommentVO comment)throws SQLException {
	int flag = 0;
	
	StringBuilder sb=new StringBuilder(100);
	sb.append(" INSERT INTO menu_comment(seq,menu_num,member_num,contents,reg_dt) \n");
	sb.append(" VALUES (?,?,?,?,sysdate)						  				  \n");
	LOG.debug("=======================================");
	LOG.debug("sql=\n" + sb.toString());
	LOG.debug("param=" + comment.toString());
	LOG.debug("=======================================");
	
	Object[] args = { comment.getSeq(),
				   	  comment.getMenuNum(),
					  comment.getMemberNum(),
					  comment.getContents(),
					  comment.getRegDt()
					};
	LOG.debug("args=" + args);

	return flag;
	
	}
	
	public CommentVO doSelectOne(CommentVO inVO) {
		CommentVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		return outVO;
		
		
	}
	
}
