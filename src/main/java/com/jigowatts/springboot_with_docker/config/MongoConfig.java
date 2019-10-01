package com.jigowatts.springboot_with_docker.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        // localhostではDockerで接続できないため定義を変更
        // TODO:定義を管理する
        ServerAddress addr = new ServerAddress("mongodb", 27017);
        return new MongoClient(addr);
    }
}