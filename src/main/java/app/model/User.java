package app.model;

import java.util.List;



public class User {

    private String Username;
    private String Password;
    private List<Card> Cards;
    private int coins;

    public User(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return Password;
    }
}
