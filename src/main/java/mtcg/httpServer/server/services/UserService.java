package mtcg.httpServer.server.services;

import mtcg.httpServer.http.Method;
import mtcg.httpServer.server.Request;
import mtcg.httpServer.server.Response;
import mtcg.httpServer.server.Service;
import mtcg.httpServer.http.HttpStatus;
import mtcg.httpServer.http.ContentType;

import java.io.IOException;

public class UserService implements Service {
    @Override
    public Response handleRequest(Request request) {
        if (Method.POST.equals(request.getMethod())) {
            String requestBody = request.getBody();


            System.out.println(requestBody);
            String response = "User created";
            return new Response(HttpStatus.CREATED, ContentType.JSON, response);
       } else {
            return new Response(HttpStatus.BAD_REQUEST, ContentType.JSON, "Method Not Allowed");
        }
    }
}
