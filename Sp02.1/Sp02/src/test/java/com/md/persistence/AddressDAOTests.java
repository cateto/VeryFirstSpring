package com.md.persistence;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.md.dao.AddressDAO;
import com.md.domain.Address;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressDAOTests {
	//@Autowired
	//@Inject
	@Resource
	private AddressDAO addressDAO;
	
	@Ignore
	@Test
	public void testList() {
		List<Address> list = addressDAO.list();
		log.info("#testList() list : " + list); 
	}
	@Ignore
	@Test
	public void testInsert() {
		Address address = new Address(-1L, "이민서", "공덕역", null);
		addressDAO.insert(address);
		
		List<Address> list = addressDAO.list();
		log.info("#testList() list(1) :" + list); 
	}
	
	@Ignore
	@Test
	public void testDel() {
		addressDAO.delete(8);
		
		List<Address> list = addressDAO.list();
		log.info("#testList() list(2) :" + list); 
		
	}
}
