package com.spring;

import java.util.Properties;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.spring.entity")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Value("${spring.datasource.driver-class-name}") String driverClassName;
    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.username}") String username;
    @Value("${spring.datasource.password}") String password;

    
    @Autowired
    private Environment env;	
@Bean
public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
	LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
	lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
	lcemfb.setDataSource(getDataSource());
	lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
	lcemfb.setPackagesToScan("com.spring.entity");
	
	return lcemfb;
}
@Bean
public JpaVendorAdapter getJpaVendorAdapter() {
	JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	return adapter;
}
    @Bean
public DataSource getDataSource() {
    	DataSource dataSource = DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
    return dataSource;
}
@Bean
public PlatformTransactionManager txManager(){
	JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
			getEntityManagerFactoryBean().getObject());
	return jpaTransactionManager;
}
}
