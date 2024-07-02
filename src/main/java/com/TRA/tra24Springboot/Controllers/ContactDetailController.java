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
@RequestMapping("/contact") //This is the main directory for Contact Details
public class ContactDetailController {

    @Autowired
    ContactDetailService contactDetailService;

    @PostMapping("save") //This is to save all Contact Details information
    public ContactDetails saveContactDetail(@RequestBody ContactDetails contactDetails){
        try {
            return contactDetailService.saveContactDetails(contactDetails);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save contact details", e);
        }
    }

    @PostMapping("delete") //This is for deleting the whole Contact Details by email
    public String deleteContactDetailByEmail(@RequestParam String em){
        try {
            contactDetailService.deleteContactDetailsByEmail(em);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete contact details by email", e);
        }
    }

    @PostMapping("deleteByPhoneNumber") //This for deleting the whole Contact Details by Phone Number
    public String deleteContactDetailsByPhoneNumber(@RequestParam String pho){
        try {
            contactDetailService.deleteContactDetailsByPhoneNumber(pho);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete contact details by phone number", e);
        }
    }

    //Updated here

    @GetMapping("stored") //This for getting all Contact Details that already been created
    public List<ContactDetailDTO> getContactDetails(){
        try {
            return contactDetailService.getContactDetails();
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get contact details", e);
        }
    }
}
