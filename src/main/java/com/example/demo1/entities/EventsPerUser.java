package com.example.demo1.entities;

public class EventsPerUser {
    public User currentUser;
    public Event event;

    public EventsPerUser() {
    }

    public EventsPerUser(User user, Event ev){
        currentUser=user;
        event=ev;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
