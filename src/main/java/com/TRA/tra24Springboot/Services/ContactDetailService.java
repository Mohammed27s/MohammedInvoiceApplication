package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.ContactDetailDTO;
import com.TRA.tra24Springboot.Models.ContactDetails;
import com.TRA.tra24Springboot.Repositories.ContactDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ContactDetailService {

    @Autowired
    ContactDetailRepository contactDetailRepository; //This is for saving all information in data

    public ContactDetails saveContactDetails(ContactDetails contactDetails){
        try {
            contactDetails.setCreatedDate(new Date());
            contactDetails.setIsActive(Boolean.TRUE);
            contactDetails.setEmail("admin.com@Outlook.com");
            contactDetails.setPhoneNumber("+968 966373523");
            contactDetails.setFaxNumber("A675553");
            contactDetails.setAddress("Muscat");
            contactDetails.setPostalCode("FG7673733");

            return contactDetailRepository.save(contactDetails);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save contact details", e);
        }
    }

    public String deleteContactDetailsByPhoneNumber(String phoneNumber){ //This is for deleting by Phone Number
        try {
            ContactDetails contactDetailsFromDb = contactDetailRepository.getByPhoneNumber(phoneNumber);
            if(contactDetailsFromDb != null) {
                contactDetailsFromDb.setIsActive(Boolean.FALSE);
                contactDetailRepository.save(contactDetailsFromDb);
                return "Success";
            } else {

                return "Contact Details not found for phone number"+ phoneNumber;
            }
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete contact details by phone number", e);
        }
    }

    public String deleteContactDetailsByEmail(String email){ //This is for deleting by email
        try {
            ContactDetails contactDetailsFromDb = contactDetailRepository.getByPhoneNumber(email);
            if(contactDetailsFromDb != null) {
                contactDetailsFromDb.setIsActive(Boolean.FALSE);
                contactDetailRepository.save(contactDetailsFromDb);
                return "Success";
            } else {
                return "Contact details not found for email: "+ email;
            }
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete contact details by email", e);
        }
    }

    public List<ContactDetailDTO> getContactDetails(){ //This is for fetching all Contact Details from the DataBase
        try {
            List<ContactDetails> contactDetail = contactDetailRepository.findAll();
            return ContactDetailDTO.convertToDTO(contactDetail);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get contact details", e);
        }
    }
}
