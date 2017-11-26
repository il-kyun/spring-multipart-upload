package com.ik.app.service;

import lombok.Setter;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Setter
public class ConcurrentExecutionManager implements ExecutionManager {

    private RequestSimple requestSimple;

    private int threadSize;

    // Partition actor : partition


    // thread actor :

    //


    @Override
    public void setRequest(RequestSimple request) {
        this.requestSimple = request;
    }

    public Set<String> execute(RetrievalService retrievalService){
        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                set.addAll(retrievalService.retrieve(requestSimple.fieldName, requestSimple.ids));
            }
        });


        return set;
    }
}
