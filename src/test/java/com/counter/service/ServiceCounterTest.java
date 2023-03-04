package com.counter.service;

import com.counter.domain.DocDocument;
import com.counter.domain.DocxDocument;
import com.counter.domain.PdfDocument;
import com.counter.enums.DocumentFormat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ServiceCounterTest {
    @Autowired
    private ServiceCounter serviceCounter;
    @MockBean
    private ServiceFiles serviceFiles;
    @MockBean
    private DocxDocument docxDocument;
    @MockBean
    private PdfDocument pdfDocument;
    @MockBean
    private DocDocument docDocument;

    @Before
    public void setup(){
        when(docxDocument.getDocumentFormat()).thenReturn(DocumentFormat.DOCX);
        when(pdfDocument.getDocumentFormat()).thenReturn(DocumentFormat.PDF);
        when(docDocument.getDocumentFormat()).thenReturn(DocumentFormat.DOC);
    }

    @Test
    public void checkQuantityPagesEqualsZeroTest() {
        when(serviceFiles.getFilesInRootDirectory(any())).thenReturn(new ArrayList<>());
        int quantityPages = serviceCounter.getQuantityPages("C:/Users");
        assertEquals(quantityPages, 0);
    }

    @Test
    public void checkQuantityPagesEqualsNotZeroTest() {
        List<File> files = List.of(new File("C:/Users/1.docx"), new File("C:/Users/2.pdf"));
        when(serviceFiles.getFilesInRootDirectory(any())).thenReturn(files);
        when(docxDocument.getQuantityPages(any())).thenReturn(5);
        when(pdfDocument.getQuantityPages(any())).thenReturn(3);

        int quantityPages = serviceCounter.getQuantityPages("C:/Users");
        assertEquals(quantityPages, 8);
    }

    @Test
    public void checkQuantityDocumentEqualsZeroTest() {
        when(serviceFiles.getFilesInRootDirectory(any())).thenReturn(new ArrayList<>());
        int quantityDocuments = serviceCounter.getQuantityDocuments("C:/Users");
        assertEquals(quantityDocuments, 0);
    }

    @Test
    public void checkQuantityDocumentEqualsNotZeroTest() {
        List<File> files = List.of(new File("C:/Users/1.docx"), new File("C:/Users/2.pdf"));
        when(serviceFiles.getFilesInRootDirectory(any())).thenReturn(files);
        int quantityDocuments = serviceCounter.getQuantityDocuments("C:/Users");
        assertEquals(quantityDocuments, 2);
    }
}
