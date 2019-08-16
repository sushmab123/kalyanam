package com.ing.matrimony.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionrequestDto {
	private Long recieverId;
	private Long senderId;
	private String status;
}
