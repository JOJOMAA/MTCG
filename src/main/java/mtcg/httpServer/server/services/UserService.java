package mtcg.httpServer.server.services;

import app.model.User;
import com.google.gson.Gson;
import mtcg.httpServer.http.Method;
import mtcg.httpServer.server.Request;
import mtcg.httpServer.server.Response;
import mtcg.httpServer.server.Service;
import mtcg.httpServer.http.HttpStatus;
import mtcg.httpServer.http.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


////////////////////////////////////////////
//Kümmert sich um die Anfragen, an die User Daten
//in der handleRequest funktion, wird ein neuer User angelegt,
//falls der Username noch nicht existiert
////////////////////////////////////////////
public class UserService implements Service {
    private List<User> users = new ArrayList<>();

    public String getUserPassword(String username){
        for(User existingUser : users) {
            if(username == existingUser.getUsername()){
                return existingUser.getPassword();
            }
        }
        return null;
    }

    public List<User> getUsers(){
        return users;
    }


    @Override
    public Response handleRequest(Request request) {
        if (Method.POST.equals(request.getMethod())) {

            Gson gson = new Gson();
            User user = gson.fromJson(request.getBody(), User.class); //Daten werden aus JSON extrahiert

            for(User existingUser : users){
                if(existingUser.getUsername().equals(user.getUsername())){ // Es wird ueberprueft ob der Username bereits vergeben ist
                    return new Response(HttpStatus.BAD_REQUEST, ContentType.JSON, "Username already exists");
                }
            }

            users.add(user);

            String username = user.getUsername();//debug
            String password = user.getPassword();//debug
            System.out.println("Username: " + username);//debug
            System.out.println("Password: " + password);//debug

            String response = "User created";

            return new Response(HttpStatus.CREATED, ContentType.JSON, response);
       } else {
            return new Response(HttpStatus.BAD_REQUEST, ContentType.JSON, "Method Not Allowed");
        }
    }
}
