package com.ls.training.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ls.training.dto.BookDTO;
@Service
@Component
public interface BookService {
	public BookDTO save(BookDTO bookDTO);
	public BookDTO get(long bid);
	public BookDTO update(BookDTO bookDTO);
	public List<BookDTO> getByTitle(String title);
	public BookDTO delete(BookDTO bookDTO);

}
