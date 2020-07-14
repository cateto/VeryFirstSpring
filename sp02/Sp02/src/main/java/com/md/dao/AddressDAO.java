package com.md.dao;

import java.util.List;

import com.md.domain.Address;

public interface AddressDAO {
	List<Address> list();
	
	void insert(Address address);
	void delete(long seq);
}
