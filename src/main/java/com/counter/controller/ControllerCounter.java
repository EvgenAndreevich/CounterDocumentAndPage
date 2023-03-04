package com.counter.controller;

import com.counter.dto.DocumentDto;
import com.counter.dto.PageDto;
import com.counter.dto.PathDto;
import com.counter.service.impl.ServiceCounterImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/counter")
public class ControllerCounter {
    private final ServiceCounterImpl serviceCounter;

    @PostMapping("get-quantity-pages")
    public ResponseEntity<PageDto> getQuantityPages(@RequestBody PathDto pathToRootFolder) {
        log.info("Post /counter/get-quantity-pages");
        return ResponseEntity.ok(new PageDto(serviceCounter.getQuantityPages(pathToRootFolder.getPath())));
    }

    @PostMapping("get-quantity-documents")
    public ResponseEntity<DocumentDto> getQuantityDocuments(@RequestBody PathDto pathToRootFolder) {
        log.info("Post /counter/get-quantity-documents");
        return ResponseEntity.ok(new DocumentDto(serviceCounter.getQuantityDocuments(pathToRootFolder.getPath())));
    }
}
