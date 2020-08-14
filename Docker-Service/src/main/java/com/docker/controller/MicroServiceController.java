package com.docker.controller;

import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
public class MicroServiceController {
public static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MicroServiceController.class);

@Autowired
@Qualifier("docker")
private Properties dockerProperties; 

//@Scheduled(fixedRate = 5000)
@RequestMapping(value="/dockertest",method = RequestMethod.GET)
public ResponseEntity<String> testDockerService() {
LOGGER.info("this is test Rayan Rayan");
Optional<Integer> num = Arrays.asList(1,2,3,4).stream().max((a,b)->  {
	if  (a.compareTo(b) > 0) return 1;
	if(a.compareTo(b) == 0) return 0;
	else return -1;
});
System.out.println(num.get());
System.out.println(dockerProperties.getProperty("usrname"));
System.out.println(dockerProperties.getProperty("pass"));


return new ResponseEntity<String>("test",HttpStatus.OK);
}



}
