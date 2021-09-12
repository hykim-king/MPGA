package com.pcwk.ehr.notice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pcwk.ehr.notice.vo.NoticeVO;
import com.pcwk.ehr.notice.service.NoticeService;
@Controller
public class NoticeController {
	
	
	@Autowired
	private NoticeService noticeService;
	
//	@RequestMapping("home")
//	public String home(Model model)throws Exception {
//		return "/home";
//	}
	@RequestMapping(value = "/noticeListAll.do", method = RequestMethod.GET)
	public String noticeListAll(Model model) throws Exception {
		model.addAttribute("noticeListAll",noticeService.noticeListAll());
		return "/WEB-INF/views/notice/noticeListAll";
	}
	
	@RequestMapping(value = "/noticeListManage.do", method = RequestMethod.GET)
	public String noticeListManage(Model model) throws Exception {
		model.addAttribute("noticeListAll",noticeService.noticeListAll());
		return "/WEB-INF/views/notice/noticeListManage";
	}
	
	
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.GET) // GET방식으로 불러오기
	  public String noticeWriteGET(NoticeVO noticeVO, Model model) throws Exception {	   
		return "/WEB-INF/views/notice/noticeWrite";
	}
	
	
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.POST) // POST방식으로 내용 전송
	  public String noticeWritePOST(NoticeVO noticeVO, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용 	   
		noticeService.noticeInsert(noticeVO); // 글작성 서비스 호출	    	    
	    return "redirect:/noticeListManage.do"; // 작성이 완료된 후, 목록페이지로 리턴
	}

	@RequestMapping(value = "/noticeFAQRead.do", method = RequestMethod.GET)
		public String noticeRead(NoticeVO noticeVO, Model model) throws Exception{
		model.addAttribute("noticeFAQRead", noticeService.noticeRead(noticeVO.getSeq()));
		
		return "/WEB-INF/views/notice/noticeFAQView";
	}
	
	@RequestMapping(value = "/noticeDelete.do", method = RequestMethod.GET) 
	  public String noticeDelete(NoticeVO noticeVO) throws Exception {  	   
		noticeService.noticeDelete(noticeVO.getSeq()); 	    	    
	    return "redirect:/noticeListManage.do"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	//@RequestParam("seq")Integer seq, RedirectAttributes rttrm
}
	