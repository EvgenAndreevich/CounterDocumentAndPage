package com.counter.service.impl;

import com.counter.domain.Document;
import com.counter.service.ServiceCounter;
import com.counter.service.ServiceFiles;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ServiceCounterImpl implements ServiceCounter {
    private final List<Document> documents;
    private final ServiceFiles serviceFiles;

    @Override
    public Integer getQuantityPages(String pathToRootFolder) {
        List<File> fileList = serviceFiles.getFilesInRootDirectory(pathToRootFolder);
        Integer pageCount = 0;
        for (File file : fileList) {
            String fileFormat = getExtensionByApacheCommonLib(file.getName());
            for (Document document : documents) {
                if (document.getDocumentFormat().getFormat().equals(fileFormat)) {
                    pageCount += document.getQuantityPages(file.getAbsolutePath());
                }
            }
        }
        return pageCount;
    }

    @Override
    public Integer getQuantityDocuments(String pathToRootFolder) {
        return serviceFiles.getFilesInRootDirectory(pathToRootFolder).size();
    }

    private String getExtensionByApacheCommonLib(String filename) {
        return FilenameUtils.getExtension(filename);
    }
}

