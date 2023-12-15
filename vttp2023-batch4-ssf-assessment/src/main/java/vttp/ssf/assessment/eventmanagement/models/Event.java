package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

public class Event{

     private String eventId;
     private String eventName;
	 private String eventSize;
	 private String eventDate; // Long and then convert the date
	 private String participants;

     
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventSize(String eventSize) {
        return eventSize;
    }

    public void setEventSize(String eventSize) {
        this.eventSize = eventSize;
    }


    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }


     @Override
     public String toString() {
         return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventSize=" + eventSize + ", eventDate=" + eventDate
                 + ", participants=" + participants + "]";
     }

    // public void setEventDate(String string) {
    // }
    // public void setEventId(String string) {
    // }
    // public void setParticipants(String string) {
    // }
}

