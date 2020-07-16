package com.ls.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ls.training.dto.PageDTO;
import com.ls.training.service.PageService;

@RestController
@RequestMapping(path = "/page")
public class PageController {
	@Autowired
	private PageService pageService;

	@GetMapping("/{id}")
	public PageDTO get(@PathVariable("id") long id) {
		return pageService.get(id);
	}

	@PutMapping
	public PageDTO update(@RequestBody PageDTO pageDTO) {
		return pageService.update(pageDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public PageDTO delete(@PathVariable("id") long id) {
		return pageService.delete(id);
	}
}
