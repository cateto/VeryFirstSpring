package com.md.dao;

import java.util.ArrayList;

import com.md.domain.Board;

public interface BoardDAO {

	long total();
	ArrayList<Board> list(int cp, int ps);
	Board content(int seq);
	void del(int seq);
	boolean insert(Board dto);
	boolean update(Board dto);
}
