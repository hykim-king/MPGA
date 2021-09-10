package com.pcwk.ehr.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pcwk.ehr.notice.vo.NoticeVO;
@Mapper
public interface NoticeDAO {
	public void noticeInsert(NoticeVO noticeVO) throws Exception;
	public NoticeVO noticeRead(Integer seq) throws Exception;
	public void noticeUpdate(NoticeVO noticeVO) throws Exception;
	public void noticeDelete(Integer seq) throws Exception;
	public List<NoticeVO> noticeListAll() throws Exception;

}
