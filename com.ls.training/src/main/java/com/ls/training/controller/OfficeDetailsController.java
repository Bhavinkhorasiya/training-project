package com.ls.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ls.training.dto.OfficeDetailsDTO;
import com.ls.training.service.OfficeDetailsService;

@RestController
@RequestMapping(path = "/office_details")
public class OfficeDetailsController {

	@Autowired
	private OfficeDetailsService officeDetailsService;

	@GetMapping("{id}")
	public OfficeDetailsDTO get(@PathVariable("id") Long id) {
		return officeDetailsService.get(id);
	}

	@PostMapping
	public OfficeDetailsDTO save(@RequestBody OfficeDetailsDTO officeDetailsDTO) {
		return officeDetailsService.save(officeDetailsDTO);
	}

	@PutMapping
	public OfficeDetailsDTO update(@RequestBody OfficeDetailsDTO officeDetailsDTO) {
		return officeDetailsService.update(officeDetailsDTO);

	}

	@DeleteMapping("{id}")
	public OfficeDetailsDTO delete(@PathVariable("id") long id) {
		return officeDetailsService.delete(id);
	}

}
