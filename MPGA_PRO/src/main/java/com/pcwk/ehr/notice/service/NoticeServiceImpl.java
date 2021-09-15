package com.pcwk.ehr.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.notice.dao.NoticeDAO;
import com.pcwk.ehr.notice.util.NoticePagingVO;
import com.pcwk.ehr.notice.vo.NoticeVO;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private final NoticeDAO noticeDAO;
	
	
	public NoticeServiceImpl(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Override
	public void doInsert(NoticeVO noticeVO) throws Exception {
		noticeDAO.doInsert(noticeVO);
	}
  
	@Override
	public NoticeVO doRead(Integer seq) throws Exception {
		
		return noticeDAO.doRead(seq);
	}

	@Override
	public void doUpdate(NoticeVO noticeVO) throws Exception {
		noticeDAO.doUpdate(noticeVO);

	}

	@Override
	public void doDelete(Integer seq) throws Exception {
		noticeDAO.doDelete(seq);

	}

	@Override
	public List<NoticeVO> getAll() throws Exception {
		
		return noticeDAO.getAll();
	}
	@Override
	public List<NoticeVO> doSelect01() throws Exception {
		return noticeDAO.doSelect01();
	}
	
	@Override
	public List<NoticeVO> doSelect02() throws Exception {
		return noticeDAO.doSelect02();
	}
	public int doCountFAQ() {
		return noticeDAO.doCountFAQ();
	}
	   
	// 페이징 처리 게시글 조회
	public List<NoticeVO> doSelectFAQ(NoticePagingVO vo) {
		return noticeDAO.doSelectFAQ(vo);
	}
}
