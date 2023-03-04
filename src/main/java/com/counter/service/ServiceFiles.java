package com.counter.service;

import java.io.File;
import java.util.List;

public interface ServiceFiles {
    List<File> getFilesInRootDirectory(String path);
}
