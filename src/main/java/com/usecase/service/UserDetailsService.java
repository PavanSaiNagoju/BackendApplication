package com.usecase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.entity.UserDetailsEntity;
import com.usecase.exception.RecordNotFoundException;

@Service
public interface UserDetailsService 
{
    public List<UserDetailsEntity> addUserDetails(UserDetailsEntity useradvanced, String email) throws RecordNotFoundException;
    public UserDetailsEntity showUserDetailsInformationByUserId(int userId) throws RecordNotFoundException;
    public List<UserDetailsEntity> editUserDetails(UserDetailsEntity user) throws RecordNotFoundException;
    public List<UserDetailsEntity> showAllUserDetails() throws RecordNotFoundException; 
    
}
