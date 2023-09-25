package com.example.Enrollment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MemberControllerTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    private MemberController memberController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        memberController = new MemberController(memberService);
    }

    @Test
    public void testEnrollMember_Successful() {
        // Mock the input data
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setFirstName("sandeep");
        memberDTO.setLastName("reddy");
        memberDTO.setEmail("sandeep.reddy@example.com");
        memberDTO.setBirthdate("02/11/1998");
        memberDTO.setphoneNumber(11223344);
        // Mock the repository save operation to return success
        when(memberRepository.save(any(Member.class))).thenReturn(new Member());

        // Perform the test
        String response = memberController.enrollMember(memberDTO, null);

        // Assert the response
        assertEquals(HttpStatus.CREATED, response.getBytes());
        assertEquals("Member enrollment successful", response.getBytes());
    }

    @Test
    public void testEnrollMember_InvalidInput() {
        // Mock the input data with missing fields (invalid input)
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setFirstName("sandeep");

        // Perform the test
        String response = memberController.enrollMember(memberDTO, null);

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, response.getBytes());
        assertEquals("Invalid input data", response.getBytes());
    }

    @Test
    public void testEnrollMember_Failure() {
        // Mock the input data
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setFirstName("sandeepvarala");
        memberDTO.setLastName("reddy");
        memberDTO.setEmail("sandeep.reddy@example.com");
        memberDTO.setBirthdate("02/11/1998");
        memberDTO.setphoneNumber(11223344);


        // Mock the repository save operation to throw an exception (failure scenario)
        when(memberRepository.save(any(Member.class))).thenThrow(new RuntimeException("Database error"));

        // Perform the test
        String response = memberController.enrollMember(memberDTO, null);

        // Assert the response
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getBytes());
        assertEquals("Failed to enroll member", response.getBytes());
    }
}

