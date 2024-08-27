package org.springframework.ai.openai.samples.helloworld.config;

//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.springframework.ai.openai.samples.helloworld.review.infrastructure",
        entityManagerFactoryRef = "mysql2EntityManagerFactory",
        transactionManagerRef = "mysql2TransactionManager"
)
public class Mysql2Config {
    @Primary
    @Bean(name = "mysql2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql2")
    public DataSource mysql2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mysql2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysql2EntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
            @Qualifier("mysql2DataSource") DataSource mysql2DataSource
    ){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysql2DataSource);
        em.setPackagesToScan("org.springframework.ai.openai.samples.helloworld.review.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        em.setJpaPropertyMap(properties);
        return em;

//        return builder
//                .dataSource(mysql2DataSource)
//                .packages("org.springframework.ai.openai.samples.helloworld.keyword.entity")
//                .persistenceUnit("mysql2")
//                .properties(properties)
//                .build();
    }

    @Primary
    @Bean(name = "mysql2TransactionManager")
    public PlatformTransactionManager mysql2TransactionManager(
        @Qualifier("mysql2EntityManagerFactory") LocalContainerEntityManagerFactoryBean mysql2ManagerFactory
    ){
        return new JpaTransactionManager(mysql2ManagerFactory.getObject());
    }

}
