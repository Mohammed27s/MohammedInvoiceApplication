package com.TRA.tra24Springboot.Services;


import com.TRA.tra24Springboot.DTO.ContactDetailDTO;
import com.TRA.tra24Springboot.Models.ContactDetails;
import com.TRA.tra24Springboot.Repositories.ContactDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ContactDetailService {

    @Autowired
    ContactDetailRepository contactDetailRepository;



    public ContactDetails saveContactDetails(ContactDetails contactDetails){

        contactDetails.setCreatedDate(new Date());
        contactDetails.setIsActive(Boolean.TRUE);
        contactDetails.setEmail("admin.com@Outlook.com");
        contactDetails.setPhoneNumber("+968 9656456563");
        contactDetails.setFaxNumber("A675553");
        contactDetails.setAddress("Muscat");
        contactDetails.setPostalCode("FG7673733");

        return contactDetailRepository.save(contactDetails);
    }

    public String deleteContactDetailsByPhoneNumber(String phoneNumber){

        ContactDetails contactDetailsFromDb = contactDetailRepository.getByPhoneNumber(phoneNumber);
        contactDetailsFromDb.setIsActive(Boolean.FALSE);
        contactDetailRepository.save(contactDetailsFromDb);


        return "Success";
    }


    public String deleteContactDetailsByEmail(String email){

        ContactDetails contactDetailsFromDb = contactDetailRepository.getByPhoneNumber(email);
        contactDetailsFromDb.setIsActive(Boolean.FALSE);
        contactDetailRepository.save(contactDetailsFromDb);

        return "Success";
    }


    public List<ContactDetailDTO> getContactDetails(){

        List<ContactDetails> contactDetail = contactDetailRepository.findAll();
        return ContactDetailDTO.convertToDTO(contactDetail);

    }





}
