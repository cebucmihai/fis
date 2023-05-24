package com.example.demo1.entities;

import com.example.demo1.exceptions.InsufficientSeats;
import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Event {

    @Id
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

    public void updateNumberOfSeats() throws InsufficientSeats {
        if(numberOfSeats == 0) throw new InsufficientSeats();
        numberOfSeats--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return numberOfSeats == event.numberOfSeats && Double.compare(event.ticketPrice, ticketPrice) == 0 && Objects.equals(eventName, event.eventName) && sportType == event.sportType && Objects.equals(eventDate, event.eventDate) && Objects.equals(organizer, event.organizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, sportType, eventDate, numberOfSeats, ticketPrice, organizer);
    }
}
