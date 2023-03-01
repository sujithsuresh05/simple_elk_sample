package com.simple.elk.configs;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.simple.elk.repository")
@Component("com.elk.simple")
public class ElkConfiguration {

    @Value("${config.elk.hostname}")
    public String elasticSearchHostname;
    
    // placeholder with default value
    @Value("${config.elk.port:9200}")
    public Integer elasticSearchPort;

    public ElasticsearchClient elasticsearchClient() {
        // Create the low-level client
        RestClient restClient = RestClient.builder(
                new HttpHost(elasticSearchHostname, elasticSearchPort)).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
