package com.simple.elk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.elastic.clients.elasticsearch.core.search.ResponseBody;

@RestController("/elkmsgs")
public class ElkDataController {
	
	@PostMapping
	public void saveMessages() {
		
	}


}
