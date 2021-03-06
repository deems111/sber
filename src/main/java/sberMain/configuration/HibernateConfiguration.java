package sberMain.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.*;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(HibernateProperty.class)
public class HibernateConfiguration {

    private HibernateProperty hibernateProperty;

    @Autowired
    public HibernateConfiguration(HibernateProperty hibernateProperty) {
        this.hibernateProperty = hibernateProperty;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(hibernateProperty.getConnection().getDriverClass());
        dataSource.setUrl(hibernateProperty.getConnection().getUrl());
        dataSource.setUsername(hibernateProperty.getConnection().getUsername());
        dataSource.setPassword(hibernateProperty.getConnection().getPassword());
        return (DataSource) dataSource;
    }

    @Bean
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateProperty.getDialect());
        properties.put("hibernate.show_sql", hibernateProperty.getShowSql());
        properties.put("hibernate.default_schema", hibernateProperty.getDefaultSchema());
        properties.put("hibernate.enable_lazy_load_no_trans", hibernateProperty.getEnableLazyLoad());
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("trainingneuralnetwork.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
}
