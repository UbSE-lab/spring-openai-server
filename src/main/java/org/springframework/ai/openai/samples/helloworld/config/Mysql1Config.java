package org.springframework.ai.openai.samples.helloworld.config;

//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;\
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
        basePackages = "org.springframework.ai.openai.samples.helloworld.keyword.infrastructure",
        entityManagerFactoryRef =  "mysql1EntityManagerFactory",
        transactionManagerRef = "mysql1TransactionManager"
)
public class Mysql1Config {
//    @Primary
    @Bean(name = "mysql1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql1")
    public DataSource mysql1DataSource(){
        return DataSourceBuilder.create().build();
    }

//    @Primary
    @Bean(name = "mysql1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysql1EntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
            @Qualifier("mysql1DataSource") DataSource mysql1DataSource
    ){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysql1DataSource);
        em.setPackagesToScan("org.springframework.ai.openai.samples.helloworld.keyword.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

//        return builder
//                .dataSource(mysql1DataSource)
//                .packages("org.springframework.ai.openai.samples.helloworld.review.entity")
//                .persistenceUnit("mysql1")
//                .properties(properties)
//                .build();
        em.setJpaPropertyMap(properties);
        return em;
    }

//    @Primary
    @Bean(name = "mysql1TransactionManager")
    public PlatformTransactionManager mysql1TransactionManager(
            @Qualifier("mysql1EntityManagerFactory") LocalContainerEntityManagerFactoryBean mysql1EntityManagerFactory
    ){
    return new JpaTransactionManager(mysql1EntityManagerFactory.getObject());
    }

}
