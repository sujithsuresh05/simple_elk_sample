package com.simple.elk.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.elk.document.News;
import com.simple.elk.dto.NewsDto;
import com.simple.elk.repository.NewsRepository;
import com.simple.elk.service.NewsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(NewsServiceImpl.class);
	private final NewsRepository newsRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
		this.newsRepository = newsRepository;
		this.modelMapper = modelMapper;
	}

	public void save(final News news) {
		newsRepository.save(news);
	}

	@Override
	public void save(NewsDto newsDto) {

	}

	// TODO implementation of findbyId
	public NewsDto findById(final String id) {
		News news = newsRepository.findById(id).orElse(null);
		if(news != null) {

		}
		modelMapper.map(news, NewsDto.class);
		return null;
	}

}
