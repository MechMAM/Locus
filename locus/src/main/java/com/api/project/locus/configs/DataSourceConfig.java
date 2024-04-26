package com.api.project.locus.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Value("${locus.app..datasource.url}")
	private String databaseUrl;
	
	@Value("${locus.app..datasource.password}")
	private String databasePassword;
	
	@Value("${locus.app..datasource.username}")
	private String databaseUsername;
	
	@Value("${locus.app..datasource.driver}")
	private String databaseDriver;	
	
    @Bean
    DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(databaseDriver)
                .url(databaseUrl)
                .username(databaseUsername)
                .password(databasePassword)
                .build();
    }
}
