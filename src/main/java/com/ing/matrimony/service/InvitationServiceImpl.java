package com.ing.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.entity.Invitation;
import com.ing.matrimony.repository.InvitationRepository;

@Service
public class InvitationServiceImpl implements InvitationService {

	@Autowired
	private InvitationRepository invitationRepository;
	
	@Override
	public InvitationDto invite(InvitationRequestDto invitationDto) {

		InvitationDto invitationResDto=new InvitationDto();
		
		Invitation invitation=new Invitation();
		invitation.setSenderID(invitationDto.getSenderId());
		invitation.setReceiverId(invitationDto.getRecieverId());
		invitation.setInvitationStatus("PENDING");
		invitationResDto.setMessage("invitation send");
		invitationResDto.setStatusCode(200);
		
		invitationRepository.save(invitation);
		
		return invitationResDto;
	}

}
