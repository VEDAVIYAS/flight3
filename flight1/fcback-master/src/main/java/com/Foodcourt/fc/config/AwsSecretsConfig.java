package com.Foodcourt.fc.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Base64;
@Configuration
public class AwsSecretsConfig {
    // Use this code snippet in your app.
// If you need more information about configurations or implementing the sample code, visit the AWS docs:
// https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-samples.html#prerequisites

//    @Bean
//    public DataSource dataSource() {
//        //AwsSecretsDto awsSecretsDto = getSecret();
//        //System.out.println("jdbc:"+awsSecretsDto.getEngine()+"://"+awsSecretsDto.getHost()+":3306/"+awsSecretsDto.getDbInstanceIdentifier());
//        return DataSourceBuilder
//                .create()
//                //.driverClassName("com.mysql.cj.jdbc.driver")
//                .url("jdbc://veda.cvvq0uavgzap.eu-north-1.rds.amazonaws.com:3306/" + "veda")
//                .username("admin")
//                .password("password")
//                .build();
//    }


}