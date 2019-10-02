package com.jigowatts.springboot_with_docker.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.host}")
    private String host;
    
    @Value("${spring.data.mongodb.port}")
    private int port;
    
    @Value("${server.dbname}")
    private String dbname;

    @Override
    protected String getDatabaseName() {
        return dbname;
    }

    @Override
    public MongoClient mongoClient() {
        ServerAddress addr = new ServerAddress(host, port);
        return new MongoClient(addr);
    }
}