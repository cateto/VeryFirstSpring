package com.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.domain.Address;
import com.md.mapper.AddressMapper2;

@Service("AddressService2")
public class AddressServiceImpl2 implements AddressService {
	
	@Autowired
	private AddressMapper2 addressMapper2; // mapper 객체 주입
	
	@Override
	public List<Address> listS() {
		return addressMapper2.list();
	}

	@Override
	public void insertS(Address address) {
		addressMapper2.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		addressMapper2.delete(seq);
	}

}
