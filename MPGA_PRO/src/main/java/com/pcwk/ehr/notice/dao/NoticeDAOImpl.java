package com.pcwk.ehr.notice.dao;

import java.util.List;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.notice.vo.NoticeVO;
@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
	private SqlSession session;
	static String namespace = "com.pcwk.ehr.notice";
	@Override
	public void noticeInsert(NoticeVO noticeVO) throws Exception {
		session.insert(namespace+".noticeInsert", noticeVO);

	}

	@Override
	public NoticeVO noticeRead(Integer seq) throws Exception {
		
		return session.selectOne(namespace+".noticeRead", seq);
	}

	@Override
	public void noticeUpdate(NoticeVO noticeVO)  throws Exception {
		session.update(namespace+".noticeUpdate", noticeVO);

	}

	@Override
	public void noticeDelete(Integer seq) throws Exception {
		session.delete(namespace+".noticeDelete", seq);

	}

	@Override
	public List<NoticeVO> noticeListAll() throws Exception {
		return session.selectList(namespace+".noticeListAll");
		
	}

}
