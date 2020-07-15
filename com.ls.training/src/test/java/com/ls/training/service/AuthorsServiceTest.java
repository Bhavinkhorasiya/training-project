package com.ls.training.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ls.training.TrainingApplication;
import com.ls.training.dto.AuthorsDTO;
import com.ls.training.dto.BookDTO;
import com.ls.training.entity.Book;

@SpringBootTest
@ContextConfiguration(classes = { TrainingApplication.class })
public class AuthorsServiceTest {

	@Autowired
	private AuthorsService authorsService;

	@Test
	void save() {

		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor("Ministry of fisheries");
		bookDTO.setIsbn("2010");
		bookDTO.setTitle("Handbook on Fisheries Statistics - 2018");

		BookDTO bookDTO2 = new BookDTO();
		bookDTO2.setAuthor("Vikram Sampath");
		bookDTO2.setIsbn("2011");
		bookDTO2.setTitle("Savarkar: Echoes from a forgotten past, 1883-1924");

		BookDTO bookDTO3 = new BookDTO();
		bookDTO3.setAuthor("MIndian Diaspora Club");
		bookDTO3.setIsbn("2012");
		bookDTO3.setTitle("Glorious Diaspora-Pride of India");

		List<BookDTO> listBookDTO = new ArrayList<BookDTO>();
		listBookDTO.add(bookDTO);
		listBookDTO.add(bookDTO2);
		listBookDTO.add(bookDTO3);

		AuthorsDTO authorsDTO = new AuthorsDTO();
		authorsDTO.setAuthor("Amit Shah");
		authorsDTO.setBookDTO(listBookDTO);

		System.out.println(authorsDTO);

		authorsDTO = authorsService.save(authorsDTO);
		assertTrue(authorsDTO.getAid() > 0);
	}

	@Test
	void get() {
		AuthorsDTO authorsDTO = authorsService.get(427L);
		System.out.println(authorsDTO);
		assertNotNull(authorsDTO);
	}

	@Test
	void update() {
		AuthorsDTO authorsDTO = authorsService.get(425L);
		authorsDTO.setAuthor("PM Narendra Modi");

		List<Book> listbook = new ArrayList<Book>();
		Book book = new Book();
		List<BookDTO> listBookDTO = authorsDTO.getBookDTO();
		for (int i = 0; i < authorsDTO.getBookDTO().size(); i++) {
			BookDTO bookDTO = listBookDTO.get(i);
			bookDTO.setTitle("Mind-Master");
			bookDTO.setAuthor("Viswanathan Anand and Susan Ninan");
			bookDTO.setIsbn("2012");
			BeanUtils.copyProperties(bookDTO, book);
			listbook.add(book);
		}
		
		authorsDTO.setBookDTO(listBookDTO);
		authorsDTO = authorsService.update(authorsDTO);
		assertTrue(authorsDTO.getAid() > 0);

	}
	
	@Test
	void delete() {
		AuthorsDTO authorsDTO = authorsService.get(432L);
		authorsDTO = authorsService.delete(authorsDTO);
		System.out.println(authorsDTO);
		assertTrue(authorsDTO.getAid() > 0);
	}
	
}