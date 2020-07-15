package com.ls.training.repository;
import java.util.List;

import com.ls.training.entity.Book;

public interface BookRepositoryCustom {
	public List<Book> getByTitle(String title);
}
