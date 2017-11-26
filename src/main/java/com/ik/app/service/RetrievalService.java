package com.ik.app.service;

import java.util.Set;

public interface RetrievalService {
    Set<String> retrieve(String field, Set<String> ids);

}
