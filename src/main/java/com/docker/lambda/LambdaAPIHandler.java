package com.docker.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.docker.entity.Request;
import com.docker.entity.Response;

public class LambdaAPIHandler implements RequestHandler<Request, com.docker.entity.Response> {

	@Override
	public Response handleRequest(Request input, Context context) {
		// TODO Auto-generated method stub
		return new Response("Success");
	}

}
