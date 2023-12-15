package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Register;

@Controller
@RequestMapping()
public class RegistrationController {


    @GetMapping("eventregister")
    public String register(Model model, @Valid @ModelAttribute Register register){
        register = new Register(null, null, null, null, null, null);

        model.addAttribute("register",register);
        
        return "eventregister" ;
        
    }

    @PostMapping("eventregister")
    public String processRegistration(){

        return "success";
    }
    
    
}
