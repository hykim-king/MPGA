package com.pcwk.ehr.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pcwk.ehr.notice.util.NoticePagingVO;
import com.pcwk.ehr.notice.vo.NoticeVO;
@Mapper
public interface NoticeDAO {
	public void doInsert(NoticeVO noticeVO) throws Exception;
	public NoticeVO doRead(Integer seq) throws Exception;
	public void doUpdate(NoticeVO noticeVO) throws Exception;
	public void doDelete(Integer seq) throws Exception;
	public List<NoticeVO> getAll() throws Exception;
	public List<NoticeVO> doSelect01() throws Exception;
	public List<NoticeVO> doSelect02() throws Exception;
	// 게시물 총 갯수
	public int doCountFAQ();
   
	// 페이징 처리 게시글 조회
	public List<NoticeVO> doSelectFAQ(NoticePagingVO vo);
}
