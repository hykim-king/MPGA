package com.pcwk.ehr.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.notice.vo.NoticeVO;
import com.pcwk.ehr.notice.service.NoticeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/resources/mybatis-config.xml"})
public class NoticeServiceTest {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private NoticeService service;
	
	/*
	 * 등록 테스트
	 */
//	@Test
//	public void testInsert() {
//		NoticeVO vo = new NoticeVO();
//		vo.setBoard_cfc(1);
//		vo.setContents("dao Test Contents");
//		vo.setReg_dt("2021-09-12");
//		vo.setReg_num(111);
//	
//		vo.setSeq(203);
//		vo.setTitle("dao Test Title");
//		try {
//			service.doInsert(vo);
//		} catch (Exception e) {
//			
//			LOG.debug("실패!");
//		}
//	}
	
//	@Test
//	public void testGetAll() {
//		try {
//			service.getAll().forEach(notice -> LOG.info(""+notice));
//
//		} catch (Exception e) {
//			LOG.debug("실패!");
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testDoUpdate() {
		NoticeVO notice = new NoticeVO();
		notice.setSeq(202);
		notice.setTitle("수정된 서비스 입니다");
		notice.setContents("수정된 서비스 내용입니다.");
		
		try {
			service.doUpdate(notice);
			LOG.info("성공하였습니다.");
		} catch (Exception e) {
			LOG.info("실패하였씁니다");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDoDelete() {
		try {
			service.doDelete(202);
			LOG.info("성공하였습니다.");
		} catch (Exception e) {
			LOG.info("실패하였씁니다");
			e.printStackTrace();
		}
	}

}
