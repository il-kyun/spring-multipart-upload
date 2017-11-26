package com.ik.app.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositoryRetrievalService implements RetrievalService {
    @Override
    public Set<String> retrieve(String field, Set<String> ids) {
        List<String> list = Arrays.asList(new String[]{"repository1", "repository2", "repository3"});
        return new HashSet<>(list);
    }
}
