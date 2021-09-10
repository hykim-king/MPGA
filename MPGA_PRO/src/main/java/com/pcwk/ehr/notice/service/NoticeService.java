package com.pcwk.ehr.notice.service;

import java.util.List;


import com.pcwk.ehr.notice.vo.NoticeVO;


public interface NoticeService {
	public void noticeInsert(NoticeVO noticeVO) throws Exception ;// throws Exception;
	  public NoticeVO noticeRead(Integer seq) throws Exception;// throws Exception;
	  public void noticeUpdate(NoticeVO noticeVO) throws Exception;// throws Exception;
	  public void noticeDelete(Integer seq) throws Exception;
	  public List<NoticeVO> noticeListAll() throws Exception;
}  
