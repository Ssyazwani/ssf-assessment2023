package vttp.ssf.assessment.eventmanagement.controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping("/events")
public class EventController {

	@Autowired
	DatabaseService dbSvc;

	@Autowired
	RedisRepository Redisrepo;


    @GetMapping("/listing")
    public String displayEvents(Model model, @ModelAttribute Event event) throws FileNotFoundException, IOException{

	String fileName = "c://data/events.json";
	List<Event> events = dbSvc.readFile(fileName);
	
	System.out.println(events);
    model.addAttribute("eventList", events);

        return "listing";
    }

	@PostMapping("/register")
	public String toRegister(){

		return "/events/eventregister";

	}

    



}
