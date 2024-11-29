package app.model;

import java.util.List;



public class User {

    private String Username;
    private String Password;
    private String Token = null;
    private List<Card> Stack;
    private int coins;

    public User(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    public void setToken(String Token){
        this.Token = Token;
    }

    public String getToken(){
        return Token;
    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return Password;
    }
}
