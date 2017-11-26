package com.ik.app.service;

import lombok.Builder;

import java.util.Set;


@Builder
public class RetrievalExecutor {

    private RetrievalService retrievalService;
    private ExecutionManager executionManager;




    public Set<String> exectue(){
        return executionManager.execute(retrievalService);
    }
}
