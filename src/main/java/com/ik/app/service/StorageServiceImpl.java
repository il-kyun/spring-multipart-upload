package com.ik.app.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {

    }

    @Override
    public Stream<Path> loadAll() {

        RequestSimple requestSimple = new RequestSimple();
        requestSimple.fieldName = "id";
        Set<String> set = new HashSet<>();
        set.add("http1");
        set.add("http2");
        set.add("http3");
        requestSimple.ids = set;

        ExecutionManager em = new ConcurrentExecutionManager();
        em.setRequest(requestSimple);

        RetrievalExecutor retrievalExecutor = RetrievalExecutor.builder()
                .executionManager(em)
                .retrievalService(new HttpRetrievalService()).build();


        Set<String> result = retrievalExecutor.exectue();
        result.stream().forEach(r -> System.out.println(r));
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Future asyncTest() throws InterruptedException {
        System.out.println("come");
        Thread.sleep(5000);
        System.out.println("time done");
        return new Future() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return true;
            }

            @Override
            public Object get() throws InterruptedException, ExecutionException {
                return "done!!";
            }

            @Override
            public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };

    }

    @Override
    public String asyncTest1() throws InterruptedException {
        Thread.sleep(3000);
        return "done!!";
    }


}
