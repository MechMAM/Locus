package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.UserModel;
import com.api.project.locus.repositories.UserRepository;
import com.api.project.locus.services.interfaces.UserServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepository;

	@Transactional
	public UserModel save(UserModel userModel) {
		return userRepository.save(userModel);
	}
	
	public String cleanCpf(String cpf) {
        if (cpf.length() > 11) {
            cpf = cpf.trim().replaceAll("\\D", "");
        }
        return cpf;
	}
	
	public Page<UserModel> findAll(Pageable pageable) {		
		return userRepository.findAll(pageable);
	}
	
	public Optional<UserModel> findById(Long id) {
		return userRepository.findById(id);
	}

	@Transactional
	public void delete(UserModel userModel) {
		userRepository.delete(userModel);;		
	}

	public void setDefaults(UserModel userModel) {
		userModel.setCpf(cleanCpf(userModel.getCpf()));
		userModel.setCreatedDate(LocalDateTime.now(ZoneId.of("UTC")));
		userModel.setStatus(true);
	}

	
	

}
