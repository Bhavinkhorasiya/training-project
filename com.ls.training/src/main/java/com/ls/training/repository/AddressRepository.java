package com.ls.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ls.training.entity.Address;
@Repository
public interface AddressRepository extends AddressRepositoryCustom, JpaRepository<Address, Long> {


}	

