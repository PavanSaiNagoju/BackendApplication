package com.usecase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.entity.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,String> {

}


