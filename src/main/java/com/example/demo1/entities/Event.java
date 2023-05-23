package com.example.demo1.entities;

import java.time.LocalDateTime;

public class Event {

    private SportType sportType;
    private LocalDateTime eventDate;
    private int numberOfSeats;
    private double ticketPrice;
    private User organizer;

    public Event(SportType sportType, LocalDateTime eventDate, int numberOfSeats, double ticketPrice, User organizer) {
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

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
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

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
}
