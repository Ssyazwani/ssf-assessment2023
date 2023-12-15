package vttp.ssf.assessment.eventmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
			String fileName = "c://data/events.json";
			dbSvc.readFile(fileName);
			// redisrepo.saveRecord(null);

		}

	}

