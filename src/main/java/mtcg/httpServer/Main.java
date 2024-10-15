package mtcg.httpServer;

import mtcg.httpServer.server.Server;
import mtcg.httpServer.utils.Router;
import java.io.IOException;
import mtcg.httpServer.server.services.UserService;

public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        router.addService("/users", new UserService());


        Server server = new Server(10001, router);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}