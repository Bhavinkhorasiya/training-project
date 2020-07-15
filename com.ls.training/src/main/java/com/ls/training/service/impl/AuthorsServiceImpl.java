package com.ls.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ls.training.dto.AuthorsDTO;
import com.ls.training.dto.BookDTO;
import com.ls.training.entity.Authors;
import com.ls.training.entity.Book;
import com.ls.training.repository.AuthorsRepository;
import com.ls.training.service.AuthorsService;

@Service
@Component
@Transactional
public class AuthorsServiceImpl implements AuthorsService {
	@Autowired
	private AuthorsRepository authorsRepository;

	@Override
	public AuthorsDTO save(AuthorsDTO authorsDTO) {
		Authors authors = new Authors();
		BeanUtils.copyProperties(authorsDTO, authors);

		List<BookDTO> bookDTOs = authorsDTO.getBookDTO();
		List<Book> listbook = new ArrayList<Book>();

		for (int i = 0; i < authorsDTO.getBookDTO().size(); i++) {
			Book book = new Book();
			BookDTO bookDTO = bookDTOs.get(i);
			BeanUtils.copyProperties(bookDTO, book);
			listbook.add(book);
		}
		authors.setBooks(listbook);
		authors = authorsRepository.save(authors);
		BeanUtils.copyProperties(authors, authorsDTO);
		return authorsDTO;

	}

	@Override
	public AuthorsDTO get(long id) {
		Authors authors = authorsRepository.getOne(id);
		AuthorsDTO authorsDTO = new AuthorsDTO();
		BeanUtils.copyProperties(authors, authorsDTO);
		
		List<Book> listBook = authors.getBooks();
		List<BookDTO> listBookDTO  = new ArrayList<BookDTO>();
		
		for (int i = 0; i < authors.getBooks().size(); i++) {
			BookDTO bookDTO = new BookDTO();
			Book book = listBook.get(i);
			BeanUtils.copyProperties(book, bookDTO);
			listBookDTO.add(bookDTO);
		}
		authorsDTO.setBookDTO(listBookDTO);
		return authorsDTO;
	}

	@Override
	public AuthorsDTO update(AuthorsDTO authorsDTO) {
		Authors authors = authorsRepository.getOne(authorsDTO.getAid());
		BeanUtils.copyProperties(authorsDTO, authors);
		List<Book> listBook = new ArrayList<Book>();
		
		List<BookDTO> listBookDTO = authorsDTO.getBookDTO();
		for (int i = 0; i < authorsDTO.getBookDTO().size(); i++) {
			Book book = new Book();
			BookDTO bookDTO = listBookDTO.get(i);
			BeanUtils.copyProperties(bookDTO, book);
			listBook.add(book);
			
		}
		authors.setBooks(listBook);
		authors = authorsRepository.save(authors);
		BeanUtils.copyProperties(authors, authorsDTO);
		return authorsDTO;
		
	}


	@Override
	public AuthorsDTO delete(AuthorsDTO authorsDTO) {
		Authors authors = authorsRepository.getOne(authorsDTO.getAid());
		authorsRepository.delete(authors);
		BeanUtils.copyProperties(authors, authorsDTO);
		return authorsDTO;
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				

}