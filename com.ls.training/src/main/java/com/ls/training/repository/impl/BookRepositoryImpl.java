package com.ls.training.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ls.training.entity.Book;
import com.ls.training.repository.BookRepositoryCustom;

public class BookRepositoryImpl implements BookRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getByTitle(String title) {

		StringBuilder sbquery = new StringBuilder();
		sbquery.append("SELECT a from Book a");
		sbquery.append(" WHERE a.title = :title");

		Query query = entityManager.createQuery(sbquery.toString());// create query for get data
		query.setParameter("title", title);// set parameter
		List<Book> books = query.getResultList(); // store result set in object of book entity list
		return books;

	}

}
