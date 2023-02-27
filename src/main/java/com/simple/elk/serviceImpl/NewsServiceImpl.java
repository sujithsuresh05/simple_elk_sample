package com.simple.elk.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.elk.document.News;
import com.simple.elk.dto.NewsDto;
import com.simple.elk.exception.NewsIdNotFoundException;
import com.simple.elk.helper.MapperUtil;
import com.simple.elk.repository.NewsRepository;
import com.simple.elk.search.DefaultPaging;
import com.simple.elk.service.NewsService;

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

	@Override
	public void save(NewsDto newsDto) {
		News news = modelMapper.map(newsDto, News.class);
		newsRepository.save(news);
	}

	public NewsDto findById(final String id) {
		LOG.info("find news with id " + id);
		News news = newsRepository.findById(id).orElseThrow(() -> new NewsIdNotFoundException(id));
		return modelMapper.map(news, NewsDto.class);
	}

	@Override
	public List<NewsDto> findAll(Optional<String> id, Pageable pageable) {

		List<NewsDto> newsDtos = new ArrayList<>();
		if (id.isPresent()) {
			newsDtos.add(findById(id.get()));
		} else {
			if (pageable == null) {
				pageable = DefaultPaging.INSTANCE;
			}
			Page<News> newsPage = newsRepository.findAll(pageable);
			List<News> newList = newsPage.getContent();

			if (newList != null && newList.size() > 0)
				newsDtos = MapperUtil.mapUtil(newList, NewsDto.class, modelMapper);
		}

		return newsDtos;
	}

}
