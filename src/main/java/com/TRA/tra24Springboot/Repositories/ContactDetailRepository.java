package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactDetailRepository extends JpaRepository<ContactDetails, Integer> {



    @Query("SELECT ce from Contacts ce WHERE ce.email =:em") //This is to get email from the DataBase
    ContactDetails getByEmail(@Param("em") String email);

    @Query("SELECT cf from Contacts cf WHERE cf.faxNumber =:fax") //This is to get faxNumber from the Database
    ContactDetails getByFaxNumber(@Param("fax") String faxNumber);

    @Query("SELECT cp from Contacts cp WHERE cp.phoneNumber =:pho") //This is to get PhoneNumber from the Database
    ContactDetails getByPhoneNumber(@Param("php") String phoneNumber);

    @Query("SELECT ca from Contacts ca WHERE ca.address =:add") //This is to get address from the Database
    ContactDetails getByAddress(@Param("add") String address);

    @Query("SELECT cpo from Contacts cpo WHERE cpo.postalCode =:pos") //This is to get PostalCode form the database
    ContactDetails getByPostalCode(@Param("pos") String postalCode);





}
