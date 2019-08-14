package com.ing.matrimony.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.matrimony.dto.ActionResponseDto;
import com.ing.matrimony.dto.ActionrequestDto;
import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.dto.ViewInvitationDto;
import com.ing.matrimony.service.InvitationService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class InterestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InterestController.class);
	
	@Autowired
	private InvitationService invitationService;
	
	
	@PostMapping("/raiseInterest")
	public ResponseEntity<InvitationDto> invitation(@RequestBody InvitationRequestDto invitationRequest)
	{
		LOGGER.info("In Interest Controller");
		
		return new ResponseEntity<>(invitationService.invite(invitationRequest),HttpStatus.OK);
	}
	
	@GetMapping("/interestSent/{senderId}")
	public ResponseEntity<List<ViewInvitationDto>> viewSentInterest(@PathVariable("senderId") Long senderId){
		List<ViewInvitationDto> invitationsSent = invitationService.viewSentInterest(senderId);
		return new ResponseEntity<>(invitationsSent,HttpStatus.OK);
	}
	@GetMapping("/interestReceived/{receiverId}")
	public ResponseEntity<List<ViewInvitationDto>> viewReceivedInterest(@PathVariable("receiverId") Long receiverId){
		List<ViewInvitationDto> invitationsReceived = invitationService.viewReceivedInterest(receiverId);
		return new ResponseEntity<>(invitationsReceived,HttpStatus.OK);
	}
	
	@PutMapping("/action")
	public ResponseEntity<ActionResponseDto> action(@RequestBody ActionrequestDto actionrequestDto){
		ActionResponseDto actionResponseDto= invitationService.action(actionrequestDto);
		
		return new ResponseEntity<>(actionResponseDto,HttpStatus.OK);
	}
	
}
