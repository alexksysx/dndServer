package me.alexksysx;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "me.alexksysx.repo")
@EnableTransactionManagement
@ComponentScan(basePackages = "me.alexksysx")
public class ApplicationConfiguration {

    /*private String url;
    private String driverClass;
    private String username;
    private String password;*/

   /* ApplicationConfiguration() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "application.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = appProps.getProperty("datasource.url");
        driverClass = appProps.getProperty("datasource.driver");
        username = appProps.getProperty("datasource.username");
        password = appProps.getProperty("datasource.password");
    }*/

    @Bean(destroyMethod = "")
    public DataSource dataSource() {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        lookup.setResourceRef(true);
        DataSource dataSource;
        try {
            dataSource = lookup.getDataSource("dndServer");
        } catch (DataSourceLookupFailureException e) {
            System.out.println("Cannot establish database connection");
            throw e;
        }
        return dataSource;
        /*DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName(driverClass);
        driver.setUrl(url);
        driver.setUsername(username);
        driver.setPassword(password);
        return driver;*/
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(getClass().getPackage().getName());

        factory.setDataSource(dataSource());


        return factory;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return txManager;
    }
}