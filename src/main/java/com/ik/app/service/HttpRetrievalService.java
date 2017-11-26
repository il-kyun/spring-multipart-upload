package com.ik.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HttpRetrievalService implements RetrievalService{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Set<String> retrieve(String field, Set<String> ids) {

//        restTemplate.exchange()
        List<String> list = Arrays.asList(new String[]{"http1", "http2", "http3"});
        return new HashSet<>(list);
    }
}
