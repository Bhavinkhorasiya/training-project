package com.ls.training.repository;

import java.util.List;

import com.ls.training.entity.Users;

public interface UserRepositoryCustom {
	public List<Users> getByEmail(String email);
}
