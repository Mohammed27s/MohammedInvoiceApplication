package com.TRA.tra24Springboot.DTO;


import com.TRA.tra24Springboot.Models.ContactDetails;
import lombok.Data;

@Data
public class ContactDetailDTO {

    String postalCode;
    String faxNumber;


    //This is for convert each variable above to DTO
    public static  ContactDetailDTO convertToDTO(ContactDetails contactDetails){

        ContactDetailDTO contactDetailDTO = new ContactDetailDTO();
        contactDetailDTO.setFaxNumber(contactDetails.getFaxNumber());
        contactDetailDTO.setPostalCode(contactDetailDTO.getPostalCode());


        return  contactDetailDTO;
    }




}
