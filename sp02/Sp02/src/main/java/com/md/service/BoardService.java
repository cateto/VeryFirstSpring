package com.md.service;

import java.util.ArrayList;

import com.md.domain.Board;
import com.md.vo.ListResult;

public interface BoardService {

	public ArrayList<Board> listS(int cp, int ps);
	public long totalS();
	public Board contentS(int seq);
	public void delS(int seq);
	public boolean insertS(Board dto);
	public boolean updateS(Board dto);
	public ListResult getListResultS(int cp, int ps);
}
