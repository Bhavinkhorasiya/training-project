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

import com.ls.training.dto.AuthorsDTO;
import com.ls.training.service.AuthorsService;

@RestController
@RequestMapping(path = "/authors")
public class AuthorsController {

	@Autowired
	private AuthorsService authorsService;

	@GetMapping("{id}")
	public AuthorsDTO get(@PathVariable("id") Long id) {
		return authorsService.get(id);
	}

	@PostMapping()
	public AuthorsDTO save(@RequestBody AuthorsDTO authorsDTO) {
		return authorsService.save(authorsDTO);
	}

	@PutMapping()
	public AuthorsDTO update(@RequestBody AuthorsDTO authorsDTO) {
		return authorsService.update(authorsDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public AuthorsDTO delete(@PathVariable("id") long id) {
		return authorsService.delete(id);
	}
}
