package com.br.var.solutions.infraestructure.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages ={"com.br.var.solutions.domain.repositories"})
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(DataSource());
        em.setPackagesToScan(new String[]{"com.br.var.solutions.domain.entities"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additinalProperties());

        return em;
    }
// O cara que vai conectar com o banco de dados está a baixo:
    @Bean
    public DataSource DataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }
//vai instaciar um objeto do JPA transactionManager injetado nossas novos configurações que estamos criando
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }
//Esse cara coloca as propriedades adicionais exemplo: qualquer plataforma, logar as informações,
// criar ou atualizar futuras tabelsa
    private Properties additinalProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",env.getProperty("spring.jpa.database-platform"));
        properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-spl"));
        properties.setProperty("hibernate.hbm2edd.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));

        return properties;
    }
}
