package com.pcwk.ehr.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeEventController {
	@RequestMapping(value = "/noticeEventThrity.do" , method = RequestMethod.GET)
	public String noticeEventThrity() {
		return "/WEB-INF/views/notice/noticeEvent/noticeEventThrity";
	}
	
	@RequestMapping(value = "/noticeEventEat.do" , method = RequestMethod.GET)
	public String noticeEventEat() {
		return "/WEB-INF/views/notice/noticeEvent/noticeEventEat";
	}
	
	@RequestMapping(value = "/noticeEventGreat.do" , method = RequestMethod.GET)
	public String noticeEventGreat() {
		return "/WEB-INF/views/notice/noticeEvent/noticeEventGreat";
	}
	
	@RequestMapping(value = "/noticeEventNew.do" , method = RequestMethod.GET)
	public String noticeEventNew() {
		return "/WEB-INF/views/notice/noticeEvent/noticeEventNew";
	}
}
