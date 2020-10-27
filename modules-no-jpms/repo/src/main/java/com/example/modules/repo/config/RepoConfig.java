package com.example.modules.repo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.modules.repo.repositories")
@EntityScan(basePackages = "com.example.modules.repo.entities")
public class RepoConfig {

}
