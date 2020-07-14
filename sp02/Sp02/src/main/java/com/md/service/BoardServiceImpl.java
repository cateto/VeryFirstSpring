package com.md.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.md.dao.BoardDAO;
import com.md.domain.Board;
import com.md.vo.ListResult;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public ArrayList<Board> listS(int cp, int ps) {
		return boardDAO.list(cp, ps);
	}

	@Override
	public long totalS() {
		return boardDAO.total();
	}

	@Override
	public Board contentS(int seq) {
		return boardDAO.content(seq);
	}

	@Override
	public void delS(int seq) {
		boardDAO.del(seq);
	}

	@Override
	public boolean insertS(Board dto) {
		return boardDAO.insert(dto);
	}

	@Override
	public boolean updateS(Board dto) {
		return boardDAO.update(dto);
	}

	@Override
	public ListResult getListResultS(int cp, int ps) {
		long totalCount = totalS();
		long totalPageCount = totalCount/ps; 
		if(totalCount%ps != 0) totalPageCount++;

		return new ListResult(cp, totalCount, ps, listS(cp, ps), totalPageCount);
	}
	
}
