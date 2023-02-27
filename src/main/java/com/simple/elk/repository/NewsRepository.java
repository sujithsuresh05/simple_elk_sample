package com.simple.elk.repository;

import com.simple.elk.document.News;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NewsRepository extends ElasticsearchRepository<News, String> {
	
	List<News> findByNews(String serachText);
	
	Page<News> findAll(Pageable pageable);
}
