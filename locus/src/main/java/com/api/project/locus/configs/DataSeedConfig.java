package com.api.project.locus.configs;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.project.locus.models.AccessTypeModel;
import com.api.project.locus.models.AccessibilityModel;
import com.api.project.locus.models.DifferentialModel;
import com.api.project.locus.models.PurposeModel;
import com.api.project.locus.models.ServiceModel;
import com.api.project.locus.models.enums.AccessTypeEnum;
import com.api.project.locus.repositories.AccessTypeRepository;
import com.api.project.locus.repositories.AccessibilityRepository;
import com.api.project.locus.repositories.DifferentialRepository;
import com.api.project.locus.repositories.PurposeRepository;
import com.api.project.locus.repositories.ServiceRepository;
import com.api.project.locus.repositories.SpaceTypeRepository;

@Configuration
@Profile("dev")
public class DataSeedConfig implements CommandLineRunner {
	
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
	@Autowired
	AccessTypeRepository accessTypeRepository;

	@Override
	public void run(String... args) throws Exception {
		initAccessType();
		initAccessibility();
		initDifferential();
		initPurpose();
		initSpaceServices();
	}

	private void initSpaceServices() {
		List<ServiceModel> services = serviceRepository.findAll();
		if(services.isEmpty()) {
			ServiceModel service1 = new ServiceModel(
					"Recursos de vídeo", 
					"Serviço de filmagem e transmissão em vídeo", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			ServiceModel service2 = new ServiceModel(
					"Recursos de tradução simultânea", 
					"Serviço de tradução para palestras em inglês e espanhol", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			ServiceModel service3 = new ServiceModel(
					"Recursos de iluminação", 
					"Equipamentos de iluminação de palco para apresentações", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			ServiceModel service4 = new ServiceModel(
					"Recursos de áudio", 
					"Caixas de som, microfone, mesa de som.", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			ServiceModel service5 = new ServiceModel(
					"Coffe Break", 
					"Suprimento de doces e salgados de acordo com a capacidade do espaço.", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			ServiceModel service6 = new ServiceModel(
					"Equipe de Palco", 
					"Staff para montagem de equipamentos, ajuste da infraestrutura do local.", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			serviceRepository.saveAll(Arrays.asList(service1,service2,service3,service4,service5,service6));
		}
	}

	private void initPurpose() {
		List<PurposeModel> purposes = purposeRepository.findAll();
		if(purposes.isEmpty()) {
			PurposeModel purpose1 = new PurposeModel(
					"Colações de grau", 
					"Local para muitas pessoas e com recursos de audiovisuais", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			PurposeModel purpose2 = new PurposeModel(
					"Eventos empresariais", 
					"Local adequado para apresentações empresariais", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			PurposeModel purpose3 = new PurposeModel(
					"Recitais", 
					"Local com boa acústica e equipamentos para apresentações", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			PurposeModel purpose4 = new PurposeModel(
					"Convenções", 
					"Local com boa área para mostra e circulação de pessoas", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			PurposeModel purpose5 = new PurposeModel(
					"Peças Teatrais", 
					"Local com equipamentos de palco e boa acústica para apresentações", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			PurposeModel purpose6 = new PurposeModel(
					"Seminários", 
					"Local com bons projetores e recursos audiovisuais", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			PurposeModel purpose7 = new PurposeModel(
					"Palestras", 
					"Local semelhante a um auditório", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			purposeRepository.saveAll(Arrays.asList(purpose1,purpose2,purpose3,purpose4,purpose5,purpose6,purpose7));
		}
	}

	private void initDifferential() {
		List<DifferentialModel> differentials = differentialRepository.findAll();
		if(differentials.isEmpty()) {
			DifferentialModel differential1 = new DifferentialModel(
					"Banheiro Família", 
					"Banheiro adequado para família com crianças", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			DifferentialModel differential2 = new DifferentialModel(
					"Espaço Kids", 
					"Espaço com brinquedos para crianças", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			DifferentialModel differential3 = new DifferentialModel(
					"Fraldário", 
					"Espaço para troca e higienização de bebês", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			differentialRepository.saveAll(Arrays.asList(differential1,differential2,differential3));
		}
		
	}

	private void initAccessibility() {
		List<AccessibilityModel> accessibilities = accessibilityRepository.findAll();
		if(accessibilities.isEmpty()) {
			AccessibilityModel accessibility1 = new AccessibilityModel(
					"estacionamento_pcd", 
					"Vagas de estacionamento para PCD", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			AccessibilityModel accessibility2 = new AccessibilityModel(
					"banheiros", 
					"Banheiros Acessíveis", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			AccessibilityModel accessibility3 = new AccessibilityModel(
					"acesso_palco", 
					"Acesso ao palco sem degraus", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			AccessibilityModel accessibility4 = new AccessibilityModel(
					"portas_largas", 
					"Portas com mais de 81cm", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			AccessibilityModel accessibility5 = new AccessibilityModel(
					"entrada", 
					"Entrada sem degraus", 
					LocalDateTime.now(ZoneId.of("UTC")), 
					LocalDateTime.now(ZoneId.of("UTC")), 
					true);
			accessibilityRepository.saveAll(Arrays.asList(accessibility1,accessibility2,accessibility3,accessibility4,accessibility5));
		}
	}

	private void initAccessType() {
		List<AccessTypeModel> accessTypes = accessTypeRepository.findAll();
		if(accessTypes.isEmpty()) {
			AccessTypeModel accT1 = new AccessTypeModel();
			accT1.setNomeFuncao(AccessTypeEnum.ADMINISTRADOR);
			accT1.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
			accT1.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
			accT1.setStatus(true);
			accessTypeRepository.save(accT1);
			AccessTypeModel accT2 = new AccessTypeModel();
			accT2.setNomeFuncao(AccessTypeEnum.MODERADOR);
			accT2.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
			accT2.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
			accT2.setStatus(true);
			accessTypeRepository.save(accT2);
			AccessTypeModel accT3 = new AccessTypeModel();
			accT3.setNomeFuncao(AccessTypeEnum.USUARIO);
			accT3.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
			accT3.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
			accT3.setStatus(true);
			accessTypeRepository.save(accT3);
		}
		
	}

}
