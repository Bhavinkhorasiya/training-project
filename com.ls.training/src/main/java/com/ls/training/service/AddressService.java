package com.ls.training.service;

import java.util.List;

import com.ls.training.dto.AddressDTO;

public interface AddressService {
	public AddressDTO get(Long id);
	public AddressDTO update(AddressDTO addressDTO);
	public List<AddressDTO> getByState(String state);
	public AddressDTO save(AddressDTO addressDTO);
	public AddressDTO delete(AddressDTO addressDTO);

}