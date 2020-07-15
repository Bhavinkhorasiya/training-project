package com.ls.training.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.ls.training.entity.Users;
import com.ls.training.repository.UserRepositoryCustom;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;


	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getByEmail(String email) {
		StringBuilder sbquery = new StringBuilder();
		sbquery.append("SELECT a from users a");
		sbquery.append("WHERE a.email = :email");
		
		Query query = entityManager.createQuery(sbquery.toString());
		query.setParameter("first_name", email);
		
		List<Users> userses = query.getResultList();  // store resultset in list of users entity whichever i get from qeury
		return userses;
	}

}
