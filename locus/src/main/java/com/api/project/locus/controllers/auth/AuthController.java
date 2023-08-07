package com.api.project.locus.controllers.auth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.locus.dtos.auth.RequestLogin;
import com.api.project.locus.dtos.auth.RequestSignup;
import com.api.project.locus.dtos.auth.ResponseJwt;
import com.api.project.locus.dtos.auth.ResponseMessage;
import com.api.project.locus.models.UserModel;
import com.api.project.locus.repositories.AccessTypeRepository;
import com.api.project.locus.repositories.UserRepository;
import com.api.project.locus.security.jwt.JwtUtils;
import com.api.project.locus.security.services.UserDetailsImpl;
import com.api.project.locus.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccessTypeRepository accessTypeRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserService userService;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody RequestLogin loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new ResponseJwt(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RequestSignup signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Email is already in use!"));
		}

		// Create new user's account
		UserModel user = new UserModel(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));
		userService.setRoles(user, signUpRequest.getRole());
		userService.setDefaults(user);
		userRepository.save(user);

		return ResponseEntity.ok(new ResponseMessage("User registered successfully!"));
	}
}
