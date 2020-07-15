package com.ls.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ls.training.entity.Users;

@Repository
public interface UsersRepository extends UserRepositoryCustom, JpaRepository<Users, Long> {

}
