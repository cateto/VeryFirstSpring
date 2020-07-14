package com.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.md.dao.AddressDAO;
import com.md.domain.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;
	
	@Override
	public List<Address> listS() {
		return addressDAO.list();
	}

	@Override
	public void insertS(Address address) {
		addressDAO.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		addressDAO.delete(seq);
	}

}
