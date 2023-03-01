package com.simple.elk.exception;

import lombok.Getter;

@Getter
public class NewsIdNotFoundException extends IllegalArgumentException {

    private final String newsId;
    
    public NewsIdNotFoundException(String newsId) {
		super(String.format("News with given newsid %s is not exist", newsId));
		this.newsId = newsId;
	}

}
