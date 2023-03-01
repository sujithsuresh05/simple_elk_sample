package com.simple.elk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.elk.dto.NewsDto;
import com.simple.elk.serviceImpl.NewsServiceImpl;

import io.micrometer.common.lang.Nullable;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/news")
public class NewsController {

	private final NewsServiceImpl newsService;

	@Autowired
	public NewsController(NewsServiceImpl newsService) {
		this.newsService = newsService;
	}
	
	@PostMapping(value = "/", produces  = "application/json")
	public void saveNews(@Validated @RequestBody NewsDto newsDto) {
		newsService.save(newsDto);
	}
	
	@GetMapping(value = {"/", "/{id}" }, produces = "application/json")
	public ResponseEntity<List<NewsDto>> getNews(@PathVariable(required = false) Optional<String> id, @Nullable Pageable pageable) {
		List<NewsDto> news = newsService.findAll(id, pageable);
		return ResponseEntity.ok(news);
	}


}
