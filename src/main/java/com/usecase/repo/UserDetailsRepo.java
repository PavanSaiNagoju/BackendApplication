package com.usecase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.entity.UserDetailsEntity;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity,Integer>  {

}
