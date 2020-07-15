package com.ls.training.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ls.training.entity.Address;
import com.ls.training.repository.AddressRepositoryCustom;

public class AddressRepositoryImpl implements AddressRepositoryCustom {

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Address> getByState(String state) {

		StringBuilder sbQuery = new StringBuilder("SELECT a FROM Address a ");
		sbQuery.append("WHERE UPPER(a.state) = UPPER(:state)  ");

		Query query = entityManager.createQuery(sbQuery.toString());

		query.setParameter("state", state);
		List<Address> addresses = query.getResultList();
		return addresses;
	}

}
