package com.jiuzhou.server;

import com.jiuzhou.server.generator.ProvinceSalesGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.jiuzhou.server.mapper")
public class Application {

//    @Autowired
//    private ProvinceSalesGenerator provinceSalesGenerator;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

//    @PostConstruct
//    public void start(){
//        provinceSalesGenerator.generate();
//    }
}
