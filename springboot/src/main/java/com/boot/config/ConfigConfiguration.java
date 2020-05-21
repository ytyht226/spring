package com.boot.config;

import com.boot.imports.ImportDemo;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanghuitao on 2020/3/28.
 */
@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class ConfigConfiguration {
    @Bean
    public ImportDemo importDemo(ServerProperties serverProperties, MyProperties myProperties) {
        ImportDemo importDemo = new ImportDemo();
//        System.out.println("importDemo: " + importDemo);
        return importDemo;
    }

}