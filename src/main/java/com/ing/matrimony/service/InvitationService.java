package com.ing.matrimony.service;

import java.util.List;

import com.ing.matrimony.dto.ActionResponseDto;
import com.ing.matrimony.dto.ActionrequestDto;
import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.dto.ViewInvitationDto;

public interface InvitationService {

	public InvitationDto invite(InvitationRequestDto invitationDto);

	public List<ViewInvitationDto> viewSentInterest(Long senderId);

	public List<ViewInvitationDto> viewReceivedInterest(Long receiverId);

	public ActionResponseDto action(ActionrequestDto actionrequestDto);
}
