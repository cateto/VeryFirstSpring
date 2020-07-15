package com.md.sql;

public class BoardSQL {

	public static final String LIST = "select * from (select ROWNUM rnum, aa.* from (select * from BOARD order by SEQ desc) aa) where rnum>? and rnum<=?";
	public static final String TOTAL = "select count(*) from BOARD";
	public static final String CONTENT = "select * from BOARD where SEQ =?";
	public static final String DELETE = "delete from BOARD where SEQ=?";
	public static final String INPUT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
	public static final String UPDATE = "update BOARD set WRITER=?, EMAIL=?, SUBJECT=?, CONTENT=?, RDATE=SYSDATE where SEQ=?";
	
}
