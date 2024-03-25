package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.AccessTypeModel;
import com.api.project.locus.models.UserModel;
import com.api.project.locus.models.enums.AccessTypeEnum;
import com.api.project.locus.repositories.AccessTypeRepository;
import com.api.project.locus.repositories.UserRepository;
import com.api.project.locus.services.interfaces.UserServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccessTypeRepository accessTypeRepository;

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
		userModel.setCreatedDate(LocalDateTime.now(ZoneId.of("UTC")));
		userModel.setStatus(true);
	}
	
	public void setRoles(UserModel user, Set<String> strRoles) {
		Set<AccessTypeModel> roles = new HashSet<>();

		if (strRoles == null) {
			AccessTypeModel userRole = accessTypeRepository.findByNomeFuncao(AccessTypeEnum.USUARIO)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					AccessTypeModel adminRole = accessTypeRepository.findByNomeFuncao(AccessTypeEnum.ADMINISTRADOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					AccessTypeModel modRole = accessTypeRepository.findByNomeFuncao(AccessTypeEnum.MODERADOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					AccessTypeModel userRole = accessTypeRepository.findByNomeFuncao(AccessTypeEnum.USUARIO)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setAcessos(roles);
	}

}
