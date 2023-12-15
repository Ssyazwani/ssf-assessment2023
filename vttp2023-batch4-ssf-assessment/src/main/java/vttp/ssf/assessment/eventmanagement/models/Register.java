package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Register {

    
    @Min(value= 5)
    @Max(value=25)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateofBirth;

    
    @Email(message = "Invalid Email Format")
    @Max(value=50)
    private String email;

    private Integer phoneNumber;

    private String gender;

    @Min(value=1)
    @Max(value=3)
    private Integer tickets;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateofBirth() {
        return dateofBirth;
    }
    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumbeer) {
        this.phoneNumber = phoneNumbeer;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getTickets() {
        return tickets;
    }
    public void setTickets(Integer tickers) {
        this.tickets = tickers;
    }

    public Register(String name, String dateofBirth,String email, Integer phoneNumber,String gender,Integer tickets){
        this.name = name;
        this.dateofBirth= dateofBirth;
        this.email= email;
        this.phoneNumber= phoneNumber;
        this.gender=gender;
        this.tickets=tickets;
    }
    
    
}
