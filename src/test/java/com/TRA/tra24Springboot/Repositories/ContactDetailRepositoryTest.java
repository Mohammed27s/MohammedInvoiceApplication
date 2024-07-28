package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.ContactDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ContactDetailRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContactDetailRepository contactDetailRepository;

    private ContactDetails testContact;

    @BeforeEach
    public void setUp() {
        // Initialize and persist test data using the builder
        testContact = ContactDetails.builder()
                .email("test@example.com")
                .faxNumber("123456")
                .phoneNumber("9876543210")
                .address("123 Test St")
                .postalCode("12345")
                .build();

        entityManager.persist(testContact);
        entityManager.flush();
    }

    @Test
    public void whenFindByEmail_thenReturnContactDetails() {
        // when
        ContactDetails found = contactDetailRepository.getByEmail(testContact.getEmail());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo(testContact.getEmail());
    }

    @Test
    public void whenFindByFaxNumber_thenReturnContactDetails() {
        // when
        ContactDetails found = contactDetailRepository.getByFaxNumber(testContact.getFaxNumber());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getFaxNumber()).isEqualTo(testContact.getFaxNumber());
    }

    @Test
    public void whenFindByPhoneNumber_thenReturnContactDetails() {
        // when
        ContactDetails found = contactDetailRepository.getByPhoneNumber(testContact.getPhoneNumber());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getPhoneNumber()).isEqualTo(testContact.getPhoneNumber());
    }

    @Test
    public void whenFindByAddress_thenReturnContactDetails() {
        // when
        ContactDetails found = contactDetailRepository.getByAddress(testContact.getAddress());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getAddress()).isEqualTo(testContact.getAddress());
    }

    @Test
    public void whenFindByPostalCode_thenReturnContactDetails() {
        // when
        ContactDetails found = contactDetailRepository.getByPostalCode(testContact.getPostalCode());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getPostalCode()).isEqualTo(testContact.getPostalCode());
    }

    @Test
    public void whenFindByEmail_notExist_thenReturnNull() {
        // when
        ContactDetails found = contactDetailRepository.getByEmail("nonexistent@example.com");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByFaxNumber_notExist_thenReturnNull() {
        // when
        ContactDetails found = contactDetailRepository.getByFaxNumber("000000");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByPhoneNumber_notExist_thenReturnNull() {
        // when
        ContactDetails found = contactDetailRepository.getByPhoneNumber("0000000000");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByAddress_notExist_thenReturnNull() {
        // when
        ContactDetails found = contactDetailRepository.getByAddress("Nonexistent Address");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByPostalCode_notExist_thenReturnNull() {
        // when
        ContactDetails found = contactDetailRepository.getByPostalCode("00000");

        // then
        assertThat(found).isNull();
    }
}
