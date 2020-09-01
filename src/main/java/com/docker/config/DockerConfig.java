package com.docker.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.docker.controller.MicroServiceController;
import com.docker.lambda.LambdaHandler;

@Configuration
//@EnableWebSecurity
@ComponentScan(basePackages = {"com.docker.controller","com.docker","com.docker.lambda"})
public class DockerConfig {

//@Autowired
//MicroServiceController controller;

@Autowired
Environment env;


@Bean
//@Scheduled(fixedRate = 5000)
public String runScehduledTask() {
	
//	controller.testDockerService();
	return "test";
	
}

@Bean(name = "docker")
public Properties getProperties() {
	Properties prop = new Properties();
	prop.put("usrname", env.getProperty("usrname"));
	prop.put("pass", env.getProperty("pass"));
	return prop;	
}


}
