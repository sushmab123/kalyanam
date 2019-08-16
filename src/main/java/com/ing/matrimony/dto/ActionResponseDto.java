package com.ing.matrimony.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActionResponseDto {
	private String message;
	private int statusCode;
}
