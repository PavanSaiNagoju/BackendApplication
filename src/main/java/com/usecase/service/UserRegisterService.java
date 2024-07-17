package com.usecase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.entity.UserRegistrationEntity;
import com.usecase.exception.RecordNotFoundException;

@Service
public interface UserRegisterService 
{
    
    public UserRegistrationEntity userRegister(UserRegistrationEntity userbasic) throws RecordNotFoundException;
 
    public List<UserRegistrationEntity> passwordReset(UserRegistrationEntity userbasic) throws RecordNotFoundException;
 
    public UserRegistrationEntity showUserRegistrationInformationByEmail(String email) throws RecordNotFoundException;
 
    public List<UserRegistrationEntity> getAllUsers() throws RecordNotFoundException;
}