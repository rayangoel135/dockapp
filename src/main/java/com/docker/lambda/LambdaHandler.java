package com.docker.lambda;

import java.util.Collections;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.docker.DockerServiceApplication;
import com.docker.config.DockerConfig;
import com.docker.controller.MicroServiceController;
import com.docker.entity.Request;
import com.docker.entity.Response;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class LambdaHandler implements RequestHandler<Void, Response>{
	private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(LambdaHandler.class);

	public Response handleRequest(Void input, Context context) {
		// TODO Auto-generated method stub
	//	DockerServiceApplication.main(new String[] {});
		LOGGER.info("Inside lambda");
		LOGGER.info("Bucket Name : ",System.getenv());
		System.out.println(System.getenv());
		System.out.println(System.getenv().get("Bucket_Name"));
		AnnotationConfigApplicationContext cont = new AnnotationConfigApplicationContext(DockerConfig.class);		
  	    MicroServiceController controller = cont.getBean(MicroServiceController.class);
		
	//	LOGGER.info("Bucket Name : ",System.getProperty("Bucket_Name"));
//		LOGGER.info("Bucket Name : ",System.getProperty("Name"));
		

		controller.testDockerService();
		return new Response(200,Collections.singletonMap("test","success"),"We rock");
	}
	/*
	@Scheduled(fixedRate = 5000)
	private void func() {
		this.handleRequest(null, null);
	}
	*/
}
