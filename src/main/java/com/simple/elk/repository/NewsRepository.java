package com.simple.elk.repository;

import com.simple.elk.document.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NewsRepository extends ElasticsearchRepository<News, String> {
}
