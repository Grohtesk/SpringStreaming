/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.spring;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author ETY01
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages ="streaming")
@EnableJpaRepositories(basePackages = "streaming")
public class SpringConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return Persistence.createEntityManagerFactory("StreamingPU");
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager tm= new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory());
        return tm;
    }
}
