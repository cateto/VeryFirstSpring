package com.md.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.md.domain.Board;
import com.md.service.BoardService;
import com.md.vo.ListResult;

import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Log4j
@Controller
public class BoardController {
	
	@Resource(name="BoardService")
	private BoardService service;
	
	@GetMapping("/list.do")
	public ModelAndView list(@RequestParam int cp, @RequestParam int ps) {
		ListResult list = service.getListResultS(cp, ps);
		return new ModelAndView("board/BoardList", "listResult", list);
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public ModelAndView write(Board dto) {
		boolean flag = service.insertS(dto);
		return new ModelAndView("board/WriteOK","flag", flag);
	}

	@RequestMapping("/content.do")
	public ModelAndView content(@RequestParam int seq) {
		Board board = service.contentS(seq);
		return new ModelAndView("board/BoardContent", "board", board);
	}
	
	@RequestMapping("/del.do")
	public String del(@RequestParam int seq) {
		service.delS(seq);
		return "redirect:list.do?cp=1&ps=3";
	}
	
	@GetMapping("/update.do")
	public ModelAndView content2(@RequestParam int seq) {
		Board board = service.contentS(seq);
		return new ModelAndView("board/BoardContentUpd", "board", board);
	}
	@PostMapping("/update.do")
	public ModelAndView content2(Board dto) {
		boolean flag = service.updateS(dto);
		return new ModelAndView("board/BoardContentUpd_post", "flag", flag);
	}
}
