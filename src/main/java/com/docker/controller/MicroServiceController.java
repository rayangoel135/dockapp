package com.docker.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
System.out.println(System.getenv());
System.out.println(System.getenv().get("Bucket_Name"));
LOGGER.info("BucketName - {}",System.getenv().get("Bucket_Name"));
LOGGER.info("env bucketname - {}",env.getProperty("Bucket_Name"));

try {
File f	= File.createTempFile("temp",".txt");
f.deleteOnExit();
BufferedWriter writer = Files.newBufferedWriter(Paths.get(f.getAbsolutePath()));
writer.write("test lambda function hurray");
writer.close();
BufferedReader reader = Files.newBufferedReader(Paths.get(f.getAbsolutePath()));
reader.lines().forEach(line -> LOGGER.info("Line contents are {}",line));
reader.close();
System.out.println("file absolute path is" +  f.getAbsolutePath());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
LOGGER.info("this is great");
System.out.println(num.get());
//System.out.println(env.getProperty("usrname"));
//System.out.println(env.getProperty("pass"));

//uploadFileToS3();
return new ResponseEntity<String>("test",HttpStatus.OK);
}

private void uploadFileToS3() {
	//S3Util.uploadFile();
	
	
}

}
