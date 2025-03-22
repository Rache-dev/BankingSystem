package bankingSystem;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> users;

    public UserManager(){
        users = new HashMap<>();
    }

    //Register user
    public boolean registerUser(String username, String email, String password){
        if(users.containsKey(username)){
            System.out.println("Username already exists. Please use another name");
            return false;
        } else {
            User newUser = new User(username,email,password);
            users.put(username, newUser);
            System.out.println(username + " registered successfully.");
            return true;
        }
    }

    // authenticate user
    public User authenticateUser(String username, String password){
        User user = users.get(username);
        if(user != null && user.getPassword().equals(password)){
            System.out.println("Successfully authenticated");
            return user;
        } else {
            System.out.println("Authentication failed");
            return null;
        }
    }

    //update user details
    public boolean updateUser(String username, String password, String email){
        if(!users.containsKey(username)){
            System.out.println("User not found.");
            return false;
        } else {
            User user = users.get(username);
            user.setEmail(email);
            user.setHashedPassword(password);
            System.out.println("User details updated." + user);
            return true;
        }
    }
    public boolean deleteUser(String username){
        if (!users.containsKey(username)){
            System.out.println("User not found.");
            return false;
        } else {
            User user = users.get(username);
            users.remove(username, user);
            System.out.println("User deleted successfully");
            return true;
        }
    }

    //Display user details
    public void displayUsers(){
        System.out.println("Registered user: ");
        for (User user : users.values()){
            System.out.println(user);
        }
    }
}
