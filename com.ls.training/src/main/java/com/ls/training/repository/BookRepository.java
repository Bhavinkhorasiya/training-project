package com.ls.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ls.training.entity.Book;
@Repository
public interface BookRepository extends BookRepositoryCustom,  JpaRepository<Book, Long> {

	

}
