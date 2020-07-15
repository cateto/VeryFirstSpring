package com.md.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.domain.Board;
import com.md.mapper.BoardMapper1;
import com.md.vo.ListResult;

@Service("BoardService1")
public class BoardServiceImpl1 implements BoardService {
	
	@Autowired
	private BoardMapper1 boardMapper1;
	
	@Override
	public ArrayList<Board> listS(int cp, int ps) {
		HashMap<String, Object> range = new HashMap<String, Object>();
		int range1 = (cp-1)*ps;
		int range2 =  cp*ps;
		range.put("startRow", range1);
		range.put("endRow", range2);
		return boardMapper1.list(range);
	}

	@Override
	public long totalS() {
		return boardMapper1.total();
	}

	@Override
	public Board contentS(int seq) {
		return boardMapper1.content(seq);
	}

	@Override
	public void delS(int seq) {
		boardMapper1.del(seq);
	}

	@Override
	public boolean insertS(Board dto) {
		return boardMapper1.insert(dto);
	}

	@Override
	public boolean updateS(Board dto) {
		return boardMapper1.update(dto);
	}

	@Override
	public ListResult getListResultS(int cp, int ps) {
		ArrayList<Board> list = listS(cp, ps);
		long totalCount = totalS();
		long totalPageCount = totalCount/ps; 
		if(totalCount%ps != 0) totalPageCount++;

		return new ListResult(cp, totalCount, ps, list, totalPageCount);
	}
	
}
