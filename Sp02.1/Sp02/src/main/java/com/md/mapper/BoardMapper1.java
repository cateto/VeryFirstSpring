package com.md.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.md.domain.Board;

public interface BoardMapper1 {
	long total();
	ArrayList<Board> list(HashMap<String, Object> range);
	Board content(int seq);
	void del(int seq);
	boolean insert(Board dto);
	boolean update(Board dto);
}
