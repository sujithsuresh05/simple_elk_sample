package com.simple.elk.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
	
	@NotBlank(message = "Id cannot be null")
	private String id;
	
	@NotBlank(message = "Need a valid news")
	private String news;
	
}
