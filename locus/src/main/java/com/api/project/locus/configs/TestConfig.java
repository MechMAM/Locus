package com.api.project.locus.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.project.locus.repositories.AccessibilityRepository;
import com.api.project.locus.repositories.DifferentialRepository;
import com.api.project.locus.repositories.PurposeRepository;
import com.api.project.locus.repositories.ServiceRepository;
import com.api.project.locus.repositories.SpaceTypeRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	AccessibilityRepository accessibilityRepository;
	@Autowired
	PurposeRepository purposeRepository;
	@Autowired
	DifferentialRepository differentialRepository;
	@Autowired
	SpaceTypeRepository spaceTypeRepository;
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		AccessibiliyModel acs1 = new Accessibility()
		
	}

}
