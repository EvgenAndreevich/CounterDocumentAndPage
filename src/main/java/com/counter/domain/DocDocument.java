package com.counter.domain;

import com.counter.enums.DocumentFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DocDocument implements Document {
    private final DocxDocument docxDocument;

    @Override
    public Integer getQuantityPages(String path) {
        return docxDocument.getQuantityPages(path);
    }

    @Override
    public DocumentFormat getDocumentFormat() {
        return DocumentFormat.DOC;
    }
}

