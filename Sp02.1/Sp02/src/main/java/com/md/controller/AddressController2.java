package com.md.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.md.domain.Address;
import com.md.service.AddressService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/address2/*")

public class AddressController2 {
	
	@Resource(name="AddressService2")
	private AddressService service;

	@RequestMapping("/list.do")
	public ModelAndView list() {
		List<Address> list = service.listS();
		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("address/list");
//		mv.addObject("list", list);
//		생성자 하나 대신 처리하는 방법임.

		return new ModelAndView("address2/list", "list", list);
	}
	
	@GetMapping("/write.do")
	public String write() {
		
		return "address2/write";
	}
	
	@PostMapping("/write.do")
	public String write(Address address) {
		service.insertS(address);
		
		return "redirect:list.do";
	}
	
	@GetMapping("/del.do")
	public String delete(@RequestParam long seq, Object page, HttpServletRequest request, HttpSession session) {
		ServletContext application = session.getServletContext();
		log.info(page);
		log.info(request);
		log.info(session);
		log.info(application);
		service.deleteS(seq);
		return "redirect:list.do";
	}

	
}
