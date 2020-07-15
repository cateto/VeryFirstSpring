package com.md.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JdbcTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.info("#오라클 드라이버 로딩 성공");
		}catch(ClassNotFoundException cnfe) {
			log.info("#오라클 드라이버 로딩 실패");
		}
	}
	@Ignore
	@Test
	public void testConnectionJdbc() {
		String url = "jdbc:log4jdbc:oracle:thin:@localhost:1521:JAVA";
		try {
			Connection con = DriverManager.getConnection(url, "spring", "java");
			log.info("#con from jdbc: " + con);
		}catch(SQLException se) {
			log.info("testConnectionJdbc() exception : " + se); 
		}
	}

}
