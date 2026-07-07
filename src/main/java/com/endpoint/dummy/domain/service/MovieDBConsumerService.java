package com.endpoint.dummy.domain.service;


import com.endpoint.dummy.domain.model.Empleado;
import com.endpoint.dummy.domain.model.Movie;
import com.endpoint.dummy.domain.model.ResponseAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDBConsumerService {
//    @Value("${moviedb.url}")
	@Value("${empleado.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseAll getLastMovie() {
        return restTemplate.getForObject(url, ResponseAll.class);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
