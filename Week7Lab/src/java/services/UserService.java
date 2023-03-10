/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.UserDB;
import java.util.ArrayList;
import models.*;

public class UserService {
    
    public User get(String email) throws Exception{
        UserDB userdb = new UserDB();
        User user  = userdb.get(email);
        return user;  
    }
    public ArrayList<User> getAll() throws Exception {
        UserDB userdb = new UserDB();
        ArrayList<User> users = userdb.getAll();
        return users;
    }
    public void insert(String email, String firstname, String lastname, String password, int roleID) throws Exception {
        Role role = new Role(roleID);
        User user = new User(email,firstname,lastname,password,role);
        UserDB userdb = new UserDB();
        userdb.insert(user);
    }
    public void update(String email, String firstname, String lastname, String password, int roleID) throws Exception {
        Role role = new Role(roleID);
        User user = new User(email,firstname,lastname,password,role);
        UserDB userdb = new UserDB();
        userdb.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userdb = new UserDB();
        userdb.delete(user);
    }
}