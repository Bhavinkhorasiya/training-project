package com.ls.training.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ls.training.TrainingApplication;
import com.ls.training.dto.PageDTO;

@SpringBootTest
@ContextConfiguration(classes = { TrainingApplication.class })
public class PageServiceTest {
	
	@Autowired
	private PageService pageService;
	
	@Test
	void get() {
		PageDTO pageDTO = pageService.get(328L);
		System.out.println(pageDTO);
		assertNotNull(pageDTO);
	}
	
	@Test
	void delete() {
		PageDTO pageDTO = pageService.get(328L);
		pageDTO = pageService.delete(pageDTO);
		assertTrue(pageDTO.getId() > 0);
	}
	
	@Test
	void update() {
		PageDTO pageDTO = pageService.get(489L);
		pageDTO.setChapter("chapter 1");
		pageDTO.setContent("free lancing");
		pageDTO.setNumber(2010);
		pageDTO = pageService.update(pageDTO);
	}
	
	

}
