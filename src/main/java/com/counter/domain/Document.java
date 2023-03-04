package com.counter.domain;

import com.counter.enums.DocumentFormat;

public interface Document {
    Integer getQuantityPages(String path);
    DocumentFormat getDocumentFormat();
}
