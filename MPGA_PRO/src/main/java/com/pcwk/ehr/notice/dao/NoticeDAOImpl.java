package com.pcwk.ehr.notice.dao;

import java.util.List;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.notice.util.NoticePagingVO;
import com.pcwk.ehr.notice.vo.NoticeVO;
@Repository
public class NoticeDAOImpl implements NoticeDAO {
  
	@Autowired
	private SqlSession session;
	static String namespace = "com.pcwk.ehr.notice";
	@Override
	public void doInsert(NoticeVO noticeVO) throws Exception {
		session.insert(namespace+".doInsert", noticeVO);

	}

	@Override
	public NoticeVO doRead(Integer seq) throws Exception {
		
		return session.selectOne(namespace+".doRead", seq);
	}

	@Override
	public void doUpdate(NoticeVO noticeVO)  throws Exception {
		session.update(namespace+".doUpdate", noticeVO);

	}

	@Override
	public void doDelete(Integer seq) throws Exception {
		session.delete(namespace+".doDelete", seq);

	}

	@Override
	public List<NoticeVO> getAll() throws Exception {
		return session.selectList(namespace+".getAll");
		
	}
	@Override
	public List<NoticeVO> doSelect01() throws Exception {
		return session.selectList(namespace+".doSelect01");
	}
	
	@Override
	public List<NoticeVO> doSelect02() throws Exception {
		return session.selectList(namespace+".doSelect02");
	}
	
	public int doCountFAQ() {
	
		return session.selectOne(namespace+".doCountFAQ");
	}
	
	public List<NoticeVO> doSelectFAQ(NoticePagingVO vo) {
		return session.selectList(namespace+".doSelectFAQ", vo);
	}
	
}
