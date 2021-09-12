package com.pcwk.ehr.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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

}
