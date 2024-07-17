package com.usecase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.entity.UserRegistrationEntity;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistrationEntity,String> {

}
