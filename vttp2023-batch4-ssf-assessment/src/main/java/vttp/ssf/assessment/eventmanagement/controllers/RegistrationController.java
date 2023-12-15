package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Register;

@Controller
@RequestMapping()
public class RegistrationController {

    private List<Register> registerList = new ArrayList<>();


    @GetMapping("eventregister")
    public String register(Model model, @Valid @ModelAttribute Register register){
        register = new Register(null, null, null, null, null, null);
        model.addAttribute("register",register);
        
        return "eventregister" ;
        
    }

}

//     @PostMapping("eventregister")
//     public String processRegistration(){
      //  LocalDate currTime = LocalDate.now();
    // int age = Period.between(dateOfBirth, currTime).getYears();

    // if (age < 21) {
    //     FieldError err = new FieldError("register", "dateOfBirth", "Cannot be young or old");  
        //String agemessage:" User can only register for the event if they are 21 year old and above"
         //model.addAttribute("agemessage", agemessage);
    //     return "error";
    // } else if (numOftickets >3){
      //String ticketmessage:" User can only register for the event if they are 21 year old and above"
         //model.addAttribute("agemessage", agemessage);
    //     return "error";}

    //else 
    // register = new Register(null, null, null, null, null, null);

      //  registerList.add(register);
    //return success




    //}

//        

