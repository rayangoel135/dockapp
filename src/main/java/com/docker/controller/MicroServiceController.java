package com.docker.controller;

import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.docker.util.S3Util;

@Component
@Controller
public class MicroServiceController {
public static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(MicroServiceController.class);

@Autowired
private Environment env;
//@Qualifier("docker")
//private Properties dockerProperties; 

//@Scheduled(fixedRate = 5000)
@RequestMapping(value="/dockertest",method = RequestMethod.GET)
public ResponseEntity<String> testDockerService() {
LOGGER.info("this is test Rayan Rayan");
Optional<Integer> num = Arrays.asList(1,2,3,4).stream().max((a,b)->  {
	if  (a.compareTo(b) > 0) return 1;
	if(a.compareTo(b) == 0) return 0;
	else return -1;
});
LOGGER.info("username is -",System.getenv("key"));
LOGGER.info("password is -",System.getenv("Bucket_Name"));
LOGGER.info(System.getenv());
LOGGER.info("this is great");

System.out.println(num.get());
System.out.println(env.getProperty("usrname"));
System.out.println(env.getProperty("pass"));

//uploadFileToS3();
return new ResponseEntity<String>("test",HttpStatus.OK);
}

private void uploadFileToS3() {
	//S3Util.uploadFile();
	
	
}

}
