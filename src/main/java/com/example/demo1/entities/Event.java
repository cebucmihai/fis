package com.example.demo1.entities;

import java.util.Date;

public class Event {

    public String eventName;
    public SportType sportType;

    public String eventDate;
    public int numberOfSeats;
    public double ticketPrice;

    public User organizer;
    public Event(){};
    public Event(String eventName,
                 SportType sportType,
                 String eventDate,
                 int numberOfSeats,
                 double ticketPrice,
                 User organizer) {
        this.eventName = eventName;
        this.sportType = sportType;
        this.eventDate = eventDate;
        this.numberOfSeats = numberOfSeats;
        this.ticketPrice = ticketPrice;
        this.organizer = organizer;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

   public String getEventDate() {
       return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
}
