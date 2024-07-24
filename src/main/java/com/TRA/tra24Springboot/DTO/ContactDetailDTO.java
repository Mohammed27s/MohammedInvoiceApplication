package com.TRA.tra24Springboot.DTO;


import com.TRA.tra24Springboot.Models.ContactDetails;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


//This is for convert ContactDetail data to DTO
@Data
public class ContactDetailDTO {

    String postalCode;
    String faxNumber;
    String phoneNumber;


    //This is for convert each variable above to DTO
    public static  ContactDetailDTO convertToDTO(ContactDetails contactDetails){

        ContactDetailDTO contactDetailDTO = new ContactDetailDTO();
        contactDetailDTO.setFaxNumber(contactDetails.getFaxNumber());
        contactDetailDTO.setPostalCode(contactDetails.getPostalCode());
        contactDetailDTO.setPhoneNumber(contactDetails.getPhoneNumber());

        return  contactDetailDTO;
    }

    //This is for converting the whole exiting data to DTO

    public static List<ContactDetailDTO> convertToDTO(List<ContactDetails> contactDetailsList){

        List<ContactDetailDTO> contactDetailDTOS = new ArrayList<>(); //This is for saving all DTOs values

        for(ContactDetails contactDetailsObjectFromDatabase: contactDetailsList){

            ContactDetailDTO dto = convertToDTO(contactDetailsObjectFromDatabase);
            contactDetailDTOS.add(dto);

        }


        return  contactDetailDTOS;
    }


}
