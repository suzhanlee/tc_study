package com.tc.spring.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MariaDBDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Profile("test")
@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = {"com.tc.spring.db"})
@EnableJpaRepositories(basePackages = {"com.tc.spring.domain"})
@RequiredArgsConstructor
public class TestEntityManagerConfig {

    private static final String[] PACKAGE_TO_SCAN = {"com.tc.spring"};
    private final DataSource dataSource;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        properties.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        properties.put(AvailableSettings.DEFAULT_BATCH_FETCH_SIZE, 500);
        properties.put(AvailableSettings.DIALECT, MariaDBDialect.class);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(PACKAGE_TO_SCAN);
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.setJpaPropertyMap(properties);
        return emf;
    }
}
