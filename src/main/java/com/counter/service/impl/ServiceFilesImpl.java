package com.counter.service.impl;

import com.counter.domain.Document;
import com.counter.exception.NotFoundDirectoryException;
import com.counter.service.ServiceFiles;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ServiceFilesImpl implements ServiceFiles {
    private final List<Document> documents;

    @Override
    public List<File> getFilesInRootDirectory(String path) {
        File rootDirectory = new File(path);
        if (!rootDirectory.isDirectory()) {
            throw new NotFoundDirectoryException("Каталога по данному пути не найдено!!!");
        }

        String[] extensions = documents.stream().map(e -> e.getDocumentFormat().getFormat()).toArray(String[]::new);
        Iterator<File> files = FileUtils.iterateFiles(rootDirectory, extensions, true);

        List<File> fileList = new ArrayList<>();
        while (files.hasNext()) {
            fileList.add(files.next());
        }
        return fileList;
    }
}
