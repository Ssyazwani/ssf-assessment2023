package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String EVENTS_KEY = "events";

    private List<Event> events= new ArrayList<>();

    public Integer getNumberOfEvents(){
        return events.size();
    }

    public Event getEvent(Integer index){
        index = 0;
      return events.get(index-1);
    }

	public  List<Event> findAll() {
        System.out.println(events);
		for(Event event : events){
			System.out.println(event);
		}
        return events;
    }

    public String saveRecord(Event event) {
        event = new Event();

        String orderJson = convertOrderToJson(event);

        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.leftPush(EVENTS_KEY, orderJson);

        return orderJson;
    }

    public List<Event> getEvents() {
        
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        List<String> orderJsonList = listOps.range(EVENTS_KEY, 0, -1);
        
        return orderJsonList.stream()
                .map(this::convertJsonToOrder)
                .collect(Collectors.toList());
    }

    private String convertOrderToJson(Event event) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            // Handle exception
            return null;
        }
    }

    private Event convertJsonToOrder(String orderJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(orderJson, Event.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    
}

