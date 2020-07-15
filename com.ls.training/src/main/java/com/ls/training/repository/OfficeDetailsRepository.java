package com.ls.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ls.training.entity.OfficeDetails;

@Repository
public interface OfficeDetailsRepository extends JpaRepository<OfficeDetails, Long>{

}
