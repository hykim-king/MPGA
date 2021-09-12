package com.pcwk.ehr.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcwk.ehr.notice.vo.NoticeVO;


public interface NoticeService {
	public void doInsert(NoticeVO noticeVO) throws Exception ;// throws Exception;
	  public NoticeVO doRead(Integer seq) throws Exception;// throws Exception;
	  public void doUpdate(NoticeVO noticeVO) throws Exception;// throws Exception;
	  public void doDelete(Integer seq) throws Exception;
	  public List<NoticeVO> getAll() throws Exception;
	  public List<NoticeVO> doSelect01() throws Exception;
	  public List<NoticeVO> doSelect02() throws Exception;
}
