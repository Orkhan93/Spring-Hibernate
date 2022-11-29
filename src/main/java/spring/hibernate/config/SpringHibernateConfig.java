package spring.hibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "spring.hibernate")
@EnableTransactionManagement

public class SpringHibernateConfig {

    @Bean
    public DataSource dataSource(DatabaseConfig databaseConfig){

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName(databaseConfig.getDriverClassName());
        driverManagerDataSource.setUrl(databaseConfig.getUrl());
        driverManagerDataSource.setUsername(databaseConfig.getUsername());
        driverManagerDataSource.setPassword(databaseConfig.getPassword());

        return driverManagerDataSource;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("spring.hibernate");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());

        return localSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){

        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);

        return hibernateTransactionManager;
    }



    private Properties hibernateProperties(){

        Properties properties = new Properties();

        properties.setProperty(
                "hibernate.hbm2ddl.auto","none");
        properties.setProperty(
                "hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");

        return properties;

    }
}
