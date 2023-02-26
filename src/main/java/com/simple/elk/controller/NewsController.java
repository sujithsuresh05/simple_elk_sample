package com.simple.elk.controller;

import com.simple.elk.dto.NewsDto;
import com.simple.elk.serviceImpl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/news")
public class NewsController {

	private final NewsServiceImpl newsService;

	@Autowired
	public NewsController(NewsServiceImpl newsService) {
		this.newsService = newsService;
	}
	
	@PostMapping
	public void saveNews(@RequestBody NewsDto newsDto) {
		
	}


}
