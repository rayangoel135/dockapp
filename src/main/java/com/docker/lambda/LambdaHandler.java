package com.docker.lambda;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.docker.controller.MicroServiceController;
import com.docker.entity.Request;
import com.docker.entity.Response;

public class LambdaHandler implements RequestHandler<Void, Response>{
	private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(LambdaHandler.class);
	@Autowired
	private MicroServiceController controller;
	@Override
	public Response handleRequest(Void input, Context context) {
		// TODO Auto-generated method stub
		LOGGER.info("Inside lambda");
		controller.testDockerService();
		return new Response("success");
	}

}
