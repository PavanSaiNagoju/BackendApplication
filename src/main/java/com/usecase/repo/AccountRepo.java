package com.usecase.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.entity.AccountEntity;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity,Integer> {
}
