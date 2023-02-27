package com.simple.elk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.simple.elk.dto.NewsDto;

public interface NewsService {

    void save(final NewsDto newsDto);

    NewsDto findById(final String id);
    
	List<NewsDto> findAll(final Optional<String> id, Pageable pageable);
}
