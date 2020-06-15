//package com.example.huongdichvu2.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/trangtin");
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("postgres");
//        return dataSourceBuilder.build();
//    }
//}
