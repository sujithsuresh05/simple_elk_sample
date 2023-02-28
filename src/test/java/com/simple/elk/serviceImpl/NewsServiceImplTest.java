package com.simple.elk.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.simple.elk.document.News;
import com.simple.elk.dto.NewsDto;
import com.simple.elk.exception.NewsIdNotFoundException;
import com.simple.elk.repository.NewsRepository;

@ExtendWith(MockitoExtension.class)
public class NewsServiceImplTest {
	
	private static final String NEWS_ID = "123";
	
	private static final String NEWS_TEXT = "test_news";
	
	@Mock
	private NewsRepository newsRepository;

	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private NewsServiceImpl newsService;
	
	private Optional<News> newsOptional;
	
	@BeforeEach
	public void initialize() {
		News news = new News();
		news.setId(NEWS_ID);
		news.setNews(NEWS_TEXT);
		newsOptional = Optional.ofNullable(news);
	}

	//unhappy path test 
	@Test
	public void testSearchWithInValidNewsIdThrowsException() {
		when(newsRepository.findById(any())).thenReturn(Optional.empty());
		assertThrows(NewsIdNotFoundException.class, () -> newsService.findAll(Optional.ofNullable(NEWS_ID), null));
			
	}
	
	// happy path test
	@Test
	public void testSearchWithValidNewsId() {
		when(newsRepository.findById(NEWS_ID)).thenReturn(newsOptional);
		when(modelMapper.map(any(), any())).thenReturn(new NewsDto(NEWS_ID, NEWS_TEXT));			
		List<NewsDto> newsDtoList = newsService.findAll(Optional.ofNullable(NEWS_ID), null);
		assertEquals(1, newsDtoList.size());	
	}
	
}
