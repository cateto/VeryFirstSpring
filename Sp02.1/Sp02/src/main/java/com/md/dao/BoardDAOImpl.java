package com.md.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.md.domain.Board;
import com.md.sql.BoardSQL;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public long total() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = BoardSQL.TOTAL;
		long total = 0;
		
		try{
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				total = rs.getInt(1);
			}
			return total;
		}catch(SQLException se){
			log.info("total() se: " + se);
			return -1;
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null)  con.close();
			}catch(SQLException se){}
		}
	}

	@Override
	public ArrayList<Board> list(int cp, int ps) {
		ArrayList<Board> list = new ArrayList<Board>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    String sql = BoardSQL.LIST;

	    try{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			int range = (cp-1)*ps;
			int range2 =  cp*ps;
			pstmt.setInt(1, range);
			pstmt.setInt(2, range2);
			rs = pstmt.executeQuery();
		
			while(rs.next()){
				int rownum = rs.getInt(1);
				int seq = rs.getInt(2);
				String writer = rs.getString(3);
				String email = rs.getString(4);
				String subject = rs.getString(5);
				String content = rs.getString(6);
				Date rdate = rs.getDate(7);
				
				list.add(new Board(seq, writer, email, subject, content, rdate));
			}
			return list;
		}catch(SQLException se){
			log.info("list() se: " + se);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)  con.close();
			}catch(SQLException se){}
		}
	}

	@Override
	public Board content(int seq) {
		String sql = BoardSQL.CONTENT;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board bd = null;
		
		try{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				bd = new Board(seq ,writer, email, subject, content, rdate);
			}
			return bd;
		}catch(SQLException se){
			log.info("content() se: " + se);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)  con.close();
			}catch(SQLException se){}
		}
	}

	@Override
	public void del(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.DELETE;
		
		try{
			con = dataSource.getConnection();	
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se){
			log.info("del() se: " + se);
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}

	}

	@Override
	public boolean insert(Board dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql= BoardSQL.INPUT;
	    
	    try{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			int i = pstmt.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			log.info("insert() se: " + se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}

	@Override
	public boolean update(Board dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql= BoardSQL.UPDATE;
		
		try{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getSeq());
			int i = pstmt.executeUpdate();
			
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			return false;
			
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}

}
