package com.pcwk.ehr.notice.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pcwk.ehr.notice.dao.NoticeDAO;
import com.pcwk.ehr.notice.service.NoticeService;
import com.pcwk.ehr.notice.util.NoticePagingVO;
import com.pcwk.ehr.notice.vo.NoticeVO;
@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeService;
	
	
//
//	//공지사항 FAQ / 새소식
//	@RequestMapping(value = "/noticeGetAll.do", method = RequestMethod.GET)
//	public String noticeGetAll(Model model) throws Exception {
//		model.addAttribute("doSelect01", noticeService.doSelect01());
//		model.addAttribute("doSelect02", noticeService.doSelect02());
//		return "/WEB-INF/views/notice/noticeGetAll";
//	}
	
	//공지사항 FAQ(paging) / 새소식
	@RequestMapping(value = "/noticeGetAll.do", method = RequestMethod.GET)
	public String noticeGetAll(NoticePagingVO vo, Model model
						, @RequestParam(value="nowPage", required=false)String nowPage
						, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {
		
		int total = noticeService.doCountFAQ();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		
		vo = new NoticePagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", noticeService.doSelectFAQ(vo));

		model.addAttribute("doSelect02", noticeService.doSelect02());
		
		return "/WEB-INF/views/notice/noticeGetAll";
	}
	

	//공지사항 게시판 관리페이지
	@RequestMapping(value = "/noticeListManage.do", method = RequestMethod.GET)
	public String noticeListManage(Model model) throws Exception {
		model.addAttribute("getAll",noticeService.getAll());
		return "/WEB-INF/views/notice/noticeListManage";
	}
	
	//게시글 작성
	@RequestMapping(value = "/noticeDoInsert.do", method = RequestMethod.GET) // GET방식으로 불러오기
	  public String noticeDoInsertGET(NoticeVO noticeVO, Model model) throws Exception {	   
		return "/WEB-INF/views/notice/noticeDoInsert";
	}
	
	//게시글 작성 후 제출
	@RequestMapping(value = "/noticeDoInsert.do", method = RequestMethod.POST) // POST방식으로 내용 전송
	  public String noticeDoInsert(NoticeVO noticeVO, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용 	   
		noticeService.doInsert(noticeVO); // 글작성 서비스 호출	    	    
	    return "redirect:/noticeListManage.do"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	//게시글 조회
	@RequestMapping(value = "/noticeDoRead.do", method = {RequestMethod.GET})
		public String noticeDoRead(@RequestParam("seq") Integer seq, Model model) throws Exception{
		logger.info("noticeRead....");
		
		model.addAttribute("doRead", noticeService.doRead(seq));

		return "/WEB-INF/views/notice/noticeDoRead";
	} 
	
 
	//게시글 삭제
	@RequestMapping(value = "/noticeDoDelete.do", method = RequestMethod.GET) 
	  public String noticeDoDelete(NoticeVO noticeVO) throws Exception {  	   
		noticeService.doDelete(noticeVO.getSeq()); 	    	    
	    return "redirect:/noticeListManage.do"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	
	//게시글 수정
	@RequestMapping(value = "/noticeDoUpdate.do", method = RequestMethod.GET)
	public String noticeUpdateGet(@RequestParam("seq") Integer seq, Model model) throws Exception{
		model.addAttribute("doRead", noticeService.doRead(seq));
		return "/WEB-INF/views/notice/noticeDoUpdate";
	}
	
	@RequestMapping(value = "/noticeDoUpdate.do", method = RequestMethod.POST)
	public String noticeUpdateGet(NoticeVO noticeVO, RedirectAttributes rttr) throws Exception{
		noticeService.doUpdate(noticeVO);
		return "redirect:/noticeListManage.do";
	}
  

}
	