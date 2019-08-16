package com.ing.matrimony.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.matrimony.dto.ActionResponseDto;
import com.ing.matrimony.dto.ActionrequestDto;
import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.dto.ViewInvitationDto;
import com.ing.matrimony.entity.Invitation;
import com.ing.matrimony.repository.InvitationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class InvitationServiceImplTest {

	@Mock
	InvitationRepository invitationRepository;

	@InjectMocks
	InvitationServiceImpl invitationServiceImpl;

	@Test
	public void testInvite() {

		Invitation invitation = new Invitation();

		invitation.setReceiverId(1L);
		invitation.setSenderId(2L);
		invitation.setInvitationStatus("PENDING");
		InvitationRequestDto InvitationRequestDto = new InvitationRequestDto();
		InvitationRequestDto.setRecieverId(1L);
		InvitationRequestDto.setSenderId(2L);
		when(invitationRepository.save(Mockito.any())).thenReturn(invitation);
		InvitationDto InvitationDto = invitationServiceImpl.invite(InvitationRequestDto);

		assertEquals("invitation send", InvitationDto.getMessage());
	}

	@Test
	public void viewSentInterestTest() {
		Invitation invitation = new Invitation();

		invitation.setReceiverId(1L);
		invitation.setSenderId(2L);
		invitation.setInvitationStatus("PENDING");
		InvitationRequestDto InvitationRequestDto = new InvitationRequestDto();
		InvitationRequestDto.setRecieverId(1L);
		InvitationRequestDto.setSenderId(2L);
		List<Invitation> senderList = new ArrayList<>();
		senderList.add(invitation);
		ViewInvitationDto viewInvitationDto = new ViewInvitationDto();
		viewInvitationDto.setInvitationStatus("PENDING");
		viewInvitationDto.setReceiverId(1L);
		viewInvitationDto.setSenderId(2L);

		List<ViewInvitationDto> viewInvitationList = new ArrayList<>();

		viewInvitationList.add(viewInvitationDto);

		when(invitationRepository.findBySenderId(Mockito.anyLong())).thenReturn(senderList);
		List<ViewInvitationDto> viewInvitationListactual = invitationServiceImpl.viewSentInterest(1L);
		assertEquals(1, viewInvitationListactual.size());

	}
	
	@Test
	public void viewRecievedInterestTest() {
	
		Invitation invitation = new Invitation();

		invitation.setReceiverId(1L);
		invitation.setSenderId(2L);
		invitation.setInvitationStatus("PENDING");
		InvitationRequestDto InvitationRequestDto = new InvitationRequestDto();
		InvitationRequestDto.setRecieverId(1L);
		InvitationRequestDto.setSenderId(2L);
		List<Invitation> recieverList = new ArrayList<>();
		recieverList.add(invitation);
		ViewInvitationDto viewInvitationDto = new ViewInvitationDto();
		viewInvitationDto.setInvitationStatus("PENDING");
		viewInvitationDto.setReceiverId(1L);
		viewInvitationDto.setSenderId(2L);

		List<ViewInvitationDto> viewInvitationList = new ArrayList<>();

		viewInvitationList.add(viewInvitationDto);

		when(invitationRepository.findByReceiverId(Mockito.anyLong())).thenReturn(recieverList);
		List<ViewInvitationDto> viewInvitationListactual = invitationServiceImpl.viewReceivedInterest(1L);
		assertEquals(1, viewInvitationListactual.size());

		
		
	}
	
	
	@Test
	public void actionTest()
	{
		Invitation invitation = new Invitation();

		invitation.setReceiverId(1L);
		invitation.setSenderId(2L);
		invitation.setInvitationStatus("PENDING");
		Optional<Invitation> optionalInvitation=Optional.of(invitation);
		
		ActionrequestDto actionrequestDto=new ActionrequestDto();
		actionrequestDto.setInvitationId(1L);
		actionrequestDto.setStatus("ACCEPTED");
	    when(invitationRepository.findById(Mockito.anyLong())).thenReturn(optionalInvitation);
	    
	    ActionResponseDto actionResponseDto=  invitationServiceImpl.action(actionrequestDto);
	    assertEquals("Your status updated successFully", actionResponseDto.getMessage());
	}
	
}
