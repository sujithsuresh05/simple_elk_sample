package com.simple.elk.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NewsDtoTest {
	
	@Test
	public void testConstructor() {
		
		NewsDto newsDto = new NewsDto("12", "good news");
		assertEquals("12", newsDto.getId());
		assertEquals("good news", newsDto.getNews());
	}
	
	@Test
	public void testSetters() {
		NewsDto newsDto = new NewsDto();
		newsDto.setId("abc");
		newsDto.setNews("badnews");
		assertEquals("abc", newsDto.getId());
		assertEquals("badnews", newsDto.getNews());
	}

}
