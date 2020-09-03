package com.docker.lambda;

import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.docker.DockerServiceApplication;
import com.docker.entity.Request;
import com.docker.entity.Response;

public class LambdaAPIHandler implements RequestHandler<Void, com.docker.entity.Response> {

	@Override
	public Response handleRequest(Void input, Context context) {
		// TODO Auto-generated method stub
		DockerServiceApplication.main(new String[] {});
		
		return new Response("BucketName" + System.getenv("Bucket_Name"));
	}

}
