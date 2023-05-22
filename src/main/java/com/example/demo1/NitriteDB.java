package com.example.demo1;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.event.ChangeInfo;
import org.dizitart.no2.event.ChangeListener;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.dizitart.no2.util.Iterables;
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
    public Boolean findUser(String username,String password, String role) {
        for (User u : userRepository.find()) {
            String uname= u.getUsername();
            String pw= u.getPassword();
            String r = u.getRole();
            if(uname.equals(username) && pw.equals(password) && r.equals(role)){
                return true;
            }
        }
        return false;
    }
}
