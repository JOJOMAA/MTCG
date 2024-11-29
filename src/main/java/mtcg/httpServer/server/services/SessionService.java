// SessionService.java
package mtcg.httpServer.server.services;

import app.model.User;
import com.google.gson.Gson;
import mtcg.httpServer.http.Method;
import mtcg.httpServer.server.Request;
import mtcg.httpServer.server.Response;
import mtcg.httpServer.server.Service;
import mtcg.httpServer.http.HttpStatus;
import mtcg.httpServer.http.ContentType;

import java.util.UUID;

public class SessionService implements Service {
    private UserService userService;

    public SessionService(UserService userService) {
        this.userService = userService;
    }

    private String generateToken(String Username) {
        return Username + "-mtcgToken";  //Token wird zurück gegeben
    }

    @Override
    public Response handleRequest(Request request) {
        if (Method.POST.equals(request.getMethod())) {
            Gson gson = new Gson();
            User loginUser = gson.fromJson(request.getBody(), User.class);

            for (User user : userService.getUsers()) {
                if (user.getUsername().equals(loginUser.getUsername()) &&
                        user.getPassword().equals(loginUser.getPassword())) {
                    if(loginUser.getToken() == null) {
                        String token = generateToken(loginUser.getUsername());
                        loginUser.setToken(token);
                        return new Response(HttpStatus.OK, ContentType.JSON, "{\"token\":\"" + token + "\"}");
                    }else{
                        return new Response(HttpStatus.UNAUTHORIZED, ContentType.JSON, "User already logged In");
                    }
                }
            }
            return new Response(HttpStatus.UNAUTHORIZED, ContentType.JSON, "Invalid username or password");
        } else {
            return new Response(HttpStatus.BAD_REQUEST, ContentType.JSON, "Method Not Allowed");
        }
    }
}