package com.pcwk.ehr.notice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.notice.dao.NoticeDAO;
import com.pcwk.ehr.notice.domain.NoticeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/resources/mybatis-config.xml"})
public class NotioceDAOTEST {
	private final Logger log = LoggerFactory.getLogger(NotioceDAOTEST.class);
	@Autowired
	private NoticeDAO dao;
	
	/*자료 등록 테스트 */
//	@Test
//	public void testDoInsert() {
//		NoticeVO vo = new NoticeVO();
//		
//		vo.setBoard_cfc(1);
//		vo.setContents("dao Test Contents");
//		vo.setReg_dt("2021-09-12");
//		vo.setReg_num(111);
//	
//		vo.setSeq(202);
//		vo.setTitle("dao Test Title");
//		
//		try {
//			dao.doInsert(vo);
//		} catch (Exception e) {
//			log.debug("실패!");
//			e.printStackTrace();
//		}
//	}
	
	
	/*자료 목록 보기 테스트 */
//	@Test
//	public void testGetAll() {
//		
//		List<NoticeVO> list;
//		try {
//			list = dao.getAll();
//			for(Object a : list) {
//				log.info("" + a);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.debug("실패!");
//		}
//		
//
//	}
	
//	@Test
//	public void testDoUpdate() {
//		NoticeVO notice = new NoticeVO();
//		notice.setSeq(202);
//		notice.setTitle("수정된 제목입니다.");
//		notice.setContents("수정된 내용입니다.");
//		
//		try {
//			dao.doUpdate(notice);
//			log.info("성공하였습니다.");
//		} catch (Exception e) {
//			log.info("실패하였습니다.");
//			e.printStackTrace();
//		}
//	
//	}
	
	@Test
	public void testDoDelete() {
		try {
			dao.doDelete(202);
			log.info("성공하였습니다.");
		} catch (Exception e) {
			log.info("실패하였습니다.");
			e.printStackTrace();
		}
	}
}
