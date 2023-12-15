package vttp.ssf.assessment.eventmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{


	
	@Autowired
	DatabaseService dbSvc;

	@Autowired
	RedisRepository redisrepo;
	
		public static void main(String[] args) {
			SpringApplication.run(EventmanagementApplication.class, args);
		}
	
		@Override
		public void run(String... args) throws Exception {
			String fileName = "C:/src/ssf-assessment2023/vttp2023-batch4-ssf-assessment/events.json";
			dbSvc.readFile(fileName);
			// dbSvc.saveRecord();

		}

	}

