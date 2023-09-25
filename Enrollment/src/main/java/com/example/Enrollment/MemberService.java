package com.example.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean enrollMember(MemberDTO memberDTO) {
        // Validate the input data
    	
        // Create a new Member object from the MemberDTO
        Member newMember = new Member();
        newMember.setFirstName(memberDTO.getFirstName());
        newMember.setLastName(memberDTO.getLastName());
        newMember.setEmail(memberDTO.getEmail());
        newMember.setBirthdate(memberDTO.getBirthdate());
        newMember.setphoneNumber(memberDTO.getphoneNumber());


        // Save the new member to the database using the MemberRepository
        try {
            memberRepository.save(newMember);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
