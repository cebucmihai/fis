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

    public void insertUser(String username,String password,String role){
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
    public boolean findUser(String username,String password) {
        for (User user : userRepository.find()) {
            String uname= user.getUsername();
            String pw= user.getPassword();
            if(uname.equals(username) && pw.equals(password)){
                return true;
            }
        }
        return false;
    }
}
