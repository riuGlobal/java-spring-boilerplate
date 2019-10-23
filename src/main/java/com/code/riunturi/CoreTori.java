package com.code.riunturi;


import com.code.riunturi.config.GeneralConfigs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties

public class CoreTori {



    public static void main(String[] args) {

        SpringApplication.run(CoreTori.class,args);



    }



}
