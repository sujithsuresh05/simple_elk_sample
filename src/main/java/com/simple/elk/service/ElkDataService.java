package com.simple.elk.service;

import org.springframework.stereotype.Service;

import com.simple.elk.dto.GeneralElkDataDto;

@Service
public class ElkDataService {

	
	public void checkinglombok() {
		GeneralElkDataDto gtd = new GeneralElkDataDto("lorem");
		gtd.getName();
	}
}
