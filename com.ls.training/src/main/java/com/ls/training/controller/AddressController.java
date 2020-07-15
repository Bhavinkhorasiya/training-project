package com.ls.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ls.training.dto.AddressDTO;
import com.ls.training.service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/{id}")
	public AddressDTO get(@PathVariable("id") Long id) {
		return addressService.get(id);
	}

	@PostMapping()
	public AddressDTO save(@RequestBody AddressDTO addressDTO) {
		return addressService.save(addressDTO);
	}

	@PutMapping()
	public AddressDTO update(@RequestBody AddressDTO addressDTO) {
		return addressService.update(addressDTO);
	}

	@GetMapping("/state/{state}")
	public List<AddressDTO> getByState(@PathVariable("state") String state) {
		return addressService.getByState(state);
	}

	@DeleteMapping("{id}")
	public AddressDTO delete(@PathVariable("id") AddressDTO id) {
		return addressService.delete(id);
	}

}