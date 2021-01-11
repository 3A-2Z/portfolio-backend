package com.portfolio.portfolio.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import com.zaxxer.hikari.HikariDataSource;   
/*
* Connects to postgres database with routing information in application.yml
*/
@Configuration
public class PostgresDatasource {  
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
    
}
