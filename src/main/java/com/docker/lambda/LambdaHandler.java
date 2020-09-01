package com.docker.lambda;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.docker.DockerServiceApplication;
import com.docker.config.DockerConfig;
import com.docker.controller.MicroServiceController;
import com.docker.entity.Request;
import com.docker.entity.Response;
import org.springframework.scheduling.annotation.Scheduled;

@Service
public class LambdaHandler implements RequestHandler<Void, Response>{
	private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(LambdaHandler.class);
	//@Autowired
//	private MicroServiceController controller;
	@Override
	public Response handleRequest(Void input, Context context) {
		// TODO Auto-generated method stub
		//DockerServiceApplication.main(new String[] {});
		AnnotationConfigApplicationContext cont = new AnnotationConfigApplicationContext(DockerConfig.class);		
		MicroServiceController controller = cont.getBean(MicroServiceController.class);
		LOGGER.info("Inside lambda");
		controller.testDockerService();
		return new Response("success");
	}
}
