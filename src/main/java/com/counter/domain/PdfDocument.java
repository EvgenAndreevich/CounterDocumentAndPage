package com.counter.domain;

import com.counter.enums.DocumentFormat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PdfDocument implements Document {

    @Override
    public Integer getQuantityPages(String path) {
        try (PDDocument doc = PDDocument.load(new File(path))) {
            return doc.getNumberOfPages();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DocumentFormat getDocumentFormat() {
        return DocumentFormat.PDF;
    }
}
