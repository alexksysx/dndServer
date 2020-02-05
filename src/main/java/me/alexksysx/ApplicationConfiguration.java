//package me.alexksysx;
//
//import com.mchange.v2.c3p0.DriverManagerDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//@Configuration
//@EnableWebMvc
//@EnableJpaRepositories(basePackages = "me.alexksysx.repo")
//@EnableTransactionManagement
//@Import(DataInitialization.class)
//@ComponentScan(basePackages = "me.alexksysx")
//public class ApplicationConfiguration {
//
//    @Bean
//    public String profile() {
//        try (InputStream input = ApplicationConfiguration.class.getClassLoader().getResourceAsStream("db.properties")) {
//            Properties prop = new Properties();
//            if (input == null) {
//                throw new IOException("Unable to find db.properties");
//            }
//            prop.load(input);
//            return prop.getProperty("profile.database");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return "null";
//        return "test";
//    }
//
//    @Bean(destroyMethod = "")
//    public DataSource dataSource() {
//        switch (profile()) {
//            case ("postgres"):
//                JndiDataSourceLookup lookup = new JndiDataSourceLookup();
//                lookup.setResourceRef(true);
//                DataSource dataSource;
//                try {
//                    dataSource = lookup.getDataSource("dndServer");
//                } catch (DataSourceLookupFailureException e) {
//                    System.out.println("Cannot establish database connection");
//                    throw e;
//                }
//                return dataSource;
//            case ("h2"):
//                return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
//
//            case ("test"):
//                DriverManagerDataSource ds = new DriverManagerDataSource();
//                ds.setJdbcUrl("jdbc:postgresql://alexksysx.me:5432/dndServer");
//                ds.setDriverClass("org.postgresql.Driver");
//                ds.setUser("alexksysx");
//                ds.setPassword("password");
//                return ds;
//            default:
//                return null;
//        }
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(Database.POSTGRESQL);
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(getClass().getPackage().getName());
//        factory.setDataSource(dataSource());
//        return factory;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return txManager;
//    }
//}