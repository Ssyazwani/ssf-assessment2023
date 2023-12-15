package vttp.ssf.assessment.eventmanagement.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService{

    private List<Event> events= new ArrayList<>();


public List<Event> readFile(String fileName) throws FileNotFoundException, IOException {

			fileName = "events.json"; // for Windows users
        
	
			try (InputStream is = new FileInputStream(fileName);
				 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
	
				StringBuilder resultStringBuilder = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					resultStringBuilder.append(line);
				}
	
				String data = resultStringBuilder.toString();
				System.out.println(data);
	
					JsonReader jsonReader = Json.createReader(new StringReader(data));
					JsonArray jsonArray = jsonReader.readArray();
	
	
					System.out.println("jsonArray size:" + jsonArray.size());
					System.out.println("jsonArray List:" + jsonArray);

                     

                    for (JsonValue jsonValue : jsonArray) {
                        events= new ArrayList<>();
                        if (jsonValue.getValueType() == JsonValue.ValueType.OBJECT) {
                            JsonObject jsonevent = (JsonObject) jsonValue;
                            Event event =(Event) parseEventObject(jsonevent);
                            events.add(event);

                            System.out.println(events);

                           
                        }
                    }

}


            return events;

}



public Event parseEventObject(JsonObject jsonevent) {
    Event event = new Event();
    event.setEventId(jsonevent.get("eventId").toString());
    event.setEventName(jsonevent.get("eventName").toString());
    event.setEventDate(jsonevent.get("eventDate").toString());
    event.getEventSize(jsonevent.get("eventSize").toString());
    event.setParticipants(jsonevent.get("participants").toString());

   
   

    return event;
}
    
   


    // JsonValue nameValue = employ.get("employeeName");
    // if (nameValue != null && nameValue.getValueType() == JsonValue.ValueType.STRING) {
    //     employee.setName(((JsonString) nameValue).getString());
    // }
	
	// JsonValue idValue = employ.get("employeeId");
    // if (idValue != null && idValue.getValueType() == JsonValue.ValueType.NUMBER) {
    // employee.setId(((JsonNumber) idValue).toString());

    // employee.setName(((JsonString) employ.get("employeeName")).getString());
    // employee.setId(((JsonNumber) employ.get("employeeId")).toString());
    
    
}
   




