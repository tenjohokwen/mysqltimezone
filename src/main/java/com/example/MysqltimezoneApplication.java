package com.example;

import com.example.domain.AuditingDateTimeProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware", dateTimeProviderRef = AuditingDateTimeProvider.NAME)
public class MysqltimezoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqltimezoneApplication.class, args);
	}
}
