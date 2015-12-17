package com.claire.mobileprojectspae06.Model;

/**
 * Created by Claire on 14/12/2015.
 */
public class User {

    private String email;
    private String username;
    private String pswd;
    private String location;
    private boolean animal;

    public User(String email, String pswd, String username, String location, boolean animal) {
        this.email = email;
        this.pswd = pswd;
        this.username = username;
        this.location = location;
        this.animal = animal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pswd;
    }

    public void setPwd(String pwd) {
        this.pswd = pwd;
    }

    public String getUsername(String username) {return username;}

    public void setUsername() {
        this.username = username;
    }

    public String getLocation(){return location;}

    public void setLocation(String ville){this.location = location;}

    public boolean getAnimal (){return animal;}

    public void setAnimal(boolean animal){this.animal=animal;}
}