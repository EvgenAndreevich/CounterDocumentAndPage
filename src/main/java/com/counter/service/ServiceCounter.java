package com.counter.service;

public interface ServiceCounter {
    Integer getQuantityPages(String pathToRootFolder);
    Integer getQuantityDocuments(String pathToRootFolder);
}
