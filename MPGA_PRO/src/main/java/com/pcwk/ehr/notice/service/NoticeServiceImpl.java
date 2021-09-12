package com.pcwk.ehr.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.notice.dao.NoticeDAO;
import com.pcwk.ehr.notice.vo.NoticeVO;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private final NoticeDAO noticeDAO;
	   
	   
	public NoticeServiceImpl(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Override
	public void noticeInsert(NoticeVO noticeVO) throws Exception {
		noticeDAO.noticeInsert(noticeVO);
	}
  
	@Override
	public NoticeVO noticeRead(Integer seq) throws Exception {
		noticeDAO.noticeRead(seq);
		return null;
	}

	@Override
	public void noticeUpdate(NoticeVO noticeVO) throws Exception {
		noticeDAO.noticeUpdate(noticeVO);

	}

	@Override
	public void noticeDelete(Integer seq) throws Exception {
		noticeDAO.noticeDelete(seq);

	}

	@Override
	public List<NoticeVO> noticeListAll() throws Exception {
		
		return noticeDAO.noticeListAll();
	}

}
