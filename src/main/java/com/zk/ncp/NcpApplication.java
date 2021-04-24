package com.zk.ncp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zk.ncp.mapper")
public class NcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcpApplication.class, args);
    }

}
