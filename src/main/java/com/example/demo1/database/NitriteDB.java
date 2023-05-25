package com.example.demo1.database;

import com.example.demo1.entities.Event;
import com.example.demo1.entities.SportType;
import com.example.demo1.entities.User;
import com.example.demo1.exceptions.EventAlreadyExistException;
import com.example.demo1.exceptions.InsufficientSeatsException;
import com.example.demo1.exceptions.UserAlreadyExistsException;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NitriteDB {

    private Event selectedEvent;
    private User currentUser;
    private static NitriteDB instance;
    private Nitrite db;


    private ObjectRepository<User> userRepository;
    private ObjectRepository<Event> eventRepository;

    private NitriteDB() {
        db = Nitrite.builder()
                .compressed()
                .filePath("users.txt")
                .openOrCreate("user", "password");
        userRepository = db.getRepository(User.class);
        eventRepository = db.getRepository(Event.class);
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
            throw new UserAlreadyExistsException("ANOTHER USERNAME");
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

    public boolean findEvent(String eventName) {
        for (Event e : eventRepository.find()) {
            if (eventName.equals(e.getEventName())) {
                return true;
            }
        }
        return false;
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
        if(findEvent(eventName)) throw new EventAlreadyExistException("This event already exist!");
        Event event = new Event(eventName, sportType, eventDate, numberOfSeats, ticketPrice);
        eventRepository.insert(event);
        currentUser.addEvents(event);
        userRepository.update(currentUser);
    }

    public void updateEvent(Event event) throws InsufficientSeatsException {
        event.updateNumberOfSeats();
        eventRepository.update(event);
    }


    public void addEventToUser(User user,Event event){
        if(event.getNumberOfSeats()!=0) {
            user.addEvents(event);
            userRepository.update(user);
        }
    }
    public Event selectedEvent(Event event){
        if(event != null){
            selectedEvent=event;
        }
        return selectedEvent;
    }
    public void modifyEvent(Event event){
        eventRepository.remove(selectedEvent);
        eventRepository.insert(event);
        currentUser.getEvents().remove(selectedEvent);
        currentUser.addEvents(event);
        userRepository.update(currentUser);
    }
    public void closeDatabase() {
        db.close();
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
