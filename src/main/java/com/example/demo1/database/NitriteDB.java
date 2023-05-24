package com.example.demo1.database;

import com.example.demo1.entities.Event;
import com.example.demo1.entities.EventsPerUser;
import com.example.demo1.entities.SportType;
import com.example.demo1.entities.User;
import com.example.demo1.exceptions.UserAlreadyExists;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class NitriteDB {

    private User currentUser;
    private static NitriteDB instance;
    private Nitrite db;


    private ObjectRepository<User> userRepository;
    private ObjectRepository<Event> eventRepository;
    private ObjectRepository<EventsPerUser> eventsPerUserRepository;

    private NitriteDB() {
        db = Nitrite.builder()
                .compressed()
                .filePath("users.txt")
                .openOrCreate("user", "password");
        userRepository = db.getRepository(User.class);
        eventRepository = db.getRepository(Event.class);
        eventsPerUserRepository=db.getRepository(EventsPerUser.class);
    }

    public static NitriteDB getInstance() {
        if (instance == null) {
            synchronized (NitriteDB.class) {
                if (instance == null) {
                    instance = new NitriteDB();
                }
            }
        }
        return instance;
    }

    private boolean checkUsername(String username) {
        for (User u : userRepository.find()) {
            if (username.equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void insertUser(String username, String password, String role) {
        if (checkUsername(username))
            throw new UserAlreadyExists("ANOTHER USERNAME");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userRepository.insert(user);
    }

    public void readUser() {
        for (User user : userRepository.find()) {
            System.out.println(user);
        }
    }

    public Optional<User> findUser(String username, String password) {
        for (User u : userRepository.find()) {
            if (username.equals(u.getUsername()) && password.equals(u.getUsername())) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findUser(String username) {
        for (User u : userRepository.find()) {
            if (username.equals(u.getUsername())) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public List<Event> readEvents() {
        List<Event> events = new ArrayList<>();
        for(Event e : eventRepository.find()) {
            events.add(e);
        }
        return events;
    }

    public void insertEvent(String eventName,
                            SportType sportType,
                            String eventDate,
                            int numberOfSeats,
                            double ticketPrice) {
        eventRepository.insert(new Event(eventName, sportType, eventDate, numberOfSeats, ticketPrice, getCurrentUser()));
    }

    public void addEventToUser(User user, Event event) {
        eventsPerUserRepository.insert(new EventsPerUser(user,event));
    }
    public List<EventsPerUser> getEventPerUser(){
        List<EventsPerUser> events = new ArrayList<>();
        for(EventsPerUser u : eventsPerUserRepository.find()){
            events.add(u);
        }
        return events;
    }
    public void closeDatabase() {
        db.close();
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
