package com.api.project.locus.services.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.project.locus.models.UserModel;

public interface UserServiceInterface {
	
	UserModel save(UserModel userModel);
	String cleanCpf(String cpf);
//	List<UserModel> findAll();
	Page<UserModel> findAll(Pageable pageable);
	void delete(UserModel userModel);
	Optional<UserModel> findById(Long id);
	

}
