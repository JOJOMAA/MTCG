package mtcg.httpServer.server.services;

import mtcg.httpServer.server.Request;
import mtcg.httpServer.server.Response;
import mtcg.httpServer.server.Service;
import mtcg.httpServer.http.HttpStatus;
import mtcg.httpServer.http.ContentType;

import java.io.IOException;
//Funktioniert nicht! Nur experimentell

public class UserService implements Service {
    @Override
    public Response handleRequest(Request request) {
        if ("POST".equals(request.getMethod())) {
            String requestBody = request.getBody();
            // Process the request body (e.g., parse JSON, save user data)
            String response = "User created";
            return new Response(HttpStatus.CREATED, ContentType.JSON, response);
        } else {
            return new Response(HttpStatus.BAD_REQUEST, ContentType.JSON, "Method Not Allowed");
        }
    }
}
