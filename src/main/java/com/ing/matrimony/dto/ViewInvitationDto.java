package com.ing.matrimony.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ViewInvitationDto {
	private Long senderId;
	private Long receiverId;
	private String invitationStatus;
}
