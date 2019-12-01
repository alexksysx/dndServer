package me.alexksysx.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "me.alexksysx.repo")
@EnableTransactionManagement
@ComponentScan(basePackages = "me.alexksysx")
public class ApplicationConfiguration  {


    @Autowired
    private BeanFactory beanFactory;

    @Profile("dev")
    @Bean(destroyMethod = "")
    public DataSource devDataSource() throws NamingException {
        System.out.println("dev datasource is active");

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql:/private.alexksysx.me:5432/dndServer");
        ds.setUsername("dndtest");
        ds.setPassword("dndtest");
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }


//    @Profile("!dev")
//    @Bean(destroyMethod = "")
//    public DataSource dataSource() throws NamingException {
//        System.out.println("prod datasource is active");
//
//
//        Context initCtx = new InitialContext();
//        Context envCtx = (Context) initCtx.lookup("java:comp/env");
//        return (DataSource)
//                envCtx.lookup("dndServer");
//
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(getClass().getPackage().getName());
        factory.setDataSource(devDataSource());

        return factory;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws NamingException {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }


}