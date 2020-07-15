package com.ls.training.repository;

import java.util.List;

import com.ls.training.entity.Address;

public interface AddressRepositoryCustom {
	public List<Address> getByState(String state);
	
}
