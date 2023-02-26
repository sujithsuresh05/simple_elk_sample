package com.simple.elk.service;

import com.simple.elk.document.News;
import com.simple.elk.dto.NewsDto;

public interface NewsService {

    void save(final NewsDto newsDto);

    NewsDto findById(final String id);
}
