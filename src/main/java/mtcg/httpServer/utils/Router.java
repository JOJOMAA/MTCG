package mtcg.httpServer.utils;


import mtcg.httpServer.server.Service;

import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////
//Der Router wird in der Main file Instanziert
//In der HashMap serviceRegistry, wird ein String (die route, z.B.: "/users")
//mit einen service gespeichert
/////////////////////////////////////////////
public class Router {
    private Map<String, Service> serviceRegistry = new HashMap<>();

    public void addService(String route, Service service)
    {
        this.serviceRegistry.put(route, service);
    }

    public void removeService(String route)
    {
        this.serviceRegistry.remove(route);
    }

    public Service resolve(String route)
    {
        return this.serviceRegistry.get(route);
    }
}
