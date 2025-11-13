package io.spring.contract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"io.spring", "io.spring.contract"})
@Import({ContractTestConfiguration.class, ContractTestSecurityConfig.class})
public class ContractTestApp {
    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        System.setProperty("spring.profiles.active", "contract-test");
        System.setProperty("spring.main.allow-bean-definition-overriding", "true");
        System.out.println("Starting ContractTestApp with contract-test profile");
        SpringApplication.run(ContractTestApp.class, args);
    }
}
