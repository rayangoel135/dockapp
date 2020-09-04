package com.docker.lambda;

import java.util.Collections;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.docker.DockerServiceApplication;
import com.docker.entity.Request;
import com.docker.entity.Response;
@Component
public class LambdaAPIHandler implements RequestHandler<Void, com.docker.entity.Response> {

	@Override
	public Response handleRequest(Void input, Context context) {
		// TODO Auto-generated method stub
		//DockerServiceApplication.main(new String[] {});
		System.out.println("bucket name is " + System.getenv("Bucket_Name"));
		return new Response(200,Collections.singletonMap("test","success"),"We rock");
	}

}
