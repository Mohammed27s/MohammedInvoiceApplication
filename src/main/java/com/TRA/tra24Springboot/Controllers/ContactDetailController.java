package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.ContactDetailDTO;
import com.TRA.tra24Springboot.Models.ContactDetails;
import com.TRA.tra24Springboot.Services.ContactDetailService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/contact") //This is the main directory for Contact Details
public class ContactDetailController {

    @Autowired
    ContactDetailService contactDetailService;

    @PostMapping("/save") //This is to save all Contact Details information
    public ContactDetails saveContactDetail(@RequestBody ContactDetails contactDetails){
        try {
            return contactDetailService.saveContactDetails(contactDetails);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save contact details", e);
        }
    }

    @PostMapping("/removeEmail") //This is for deleting the whole Contact Details by using email
    public String deleteContactDetailByEmail(@RequestParam String em){
        try {
            contactDetailService.deleteContactDetailsByEmail(em);
            return "The contact detail has Deleted Successfully by email";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete contact details by email", e);
        }
    }

    @PostMapping("/removePhone") //This for deleting the whole Contact Details by using Phone Number
    public String deleteContactDetailsByPhoneNumber(@RequestParam String pho){
        try {
            contactDetailService.deleteContactDetailsByPhoneNumber(pho);
            return "The contact detail has deleted successfully by phone number";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete contact details by phone number", e);
        }
    }

    //Updated here

    @GetMapping("/get") //This for getting all stored Contact Details from the database
    public List<ContactDetailDTO> getContactDetails(){
        try {
            return contactDetailService.getContactDetails();
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to fetch contact details", e);
        }
    }


    //Need Updated API here

   // @PutMapping("/update")


}
