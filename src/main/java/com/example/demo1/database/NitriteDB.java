package com.example.demo1.database;
import com.example.demo1.entities.User;
import com.example.demo1.exceptions.UserAlreadyExists;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.Optional;

public class NitriteDB {
    private Nitrite db = Nitrite.builder()
            .compressed()
            .filePath("users.txt")
            .openOrCreate("user", "password");
    private ObjectRepository<User> userRepository=db.getRepository(User.class);

    private boolean checkUsername(String username){
        for (User u : userRepository.find()){
            if(username.equals( u.getUsername())){
                return true;
            }
        }
        return false;
    }
    public void insertUser(String username,String password,String role){
        if(checkUsername(username)) throw new UserAlreadyExists("ANOTHER USERNAME");
        User user= new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userRepository.insert(user);
    }
    public void readUser(){
        for(User user:userRepository.find()){
            System.out.println(user);
        }
    }
    public Optional<User> findUser(String username, String password) {
        for (User u : userRepository.find()) {
            if(username.equals(u.getUsername()) && password.equals(u.getUsername())){
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
}
