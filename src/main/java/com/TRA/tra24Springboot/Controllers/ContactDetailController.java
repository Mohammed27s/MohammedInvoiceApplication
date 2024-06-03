package com.TRA.tra24Springboot.Controllers;


import com.TRA.tra24Springboot.DTO.ContactDetailDTO;
import com.TRA.tra24Springboot.Models.ContactDetails;
import com.TRA.tra24Springboot.Services.ContactDetailService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Data
@RestController
@RequestMapping("/Contact") //This is the main directory for Contact Details
public class ContactDetailController {

    @Autowired
    ContactDetailService contactDetailService;


    @PostMapping("save") //This is to save all Contact Details information
    public ContactDetails saveContactDetail(@RequestBody ContactDetails contactDetails){


        return contactDetailService.saveContactDetails(contactDetails);
    }

    @PostMapping("delete") //This is for deleting the whole Contact Details by email
    public String deleteContactDetailByEmail(@RequestParam String em){
        contactDetailService.deleteContactDetailsByEmail(em);

        return  "Success";
    }

    @PostMapping("deleteByPhoneNumber") //This for deleting the whole Contact Details by Phone Number
    public String deleteContactDetailsByPhoneNumber(@RequestParam String pho){
        contactDetailService.deleteContactDetailsByPhoneNumber(pho);

        return  "Success";

    }

    @GetMapping("getAll") //This for getting all Contact Details that all ready been created
    public List<ContactDetailDTO> getContactDetails(){

        return  contactDetailService.getContactDetails();
    }







}
