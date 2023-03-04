package com.counter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DocumentFormat {
    DOCX("docx"),
    DOC("doc"),
    PDF("pdf");

    private final String format;
}
