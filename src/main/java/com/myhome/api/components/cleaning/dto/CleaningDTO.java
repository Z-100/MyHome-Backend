package com.myhome.api.components.cleaning.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CleaningDTO {

	private Long id;

	private Date cleaning_time;
}
