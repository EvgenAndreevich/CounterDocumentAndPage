package com.counter.domain;

import com.counter.enums.DocumentFormat;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

@Component
public class DocxDocument implements Document {
    @Override
    public Integer getQuantityPages(String path) {
        try (OPCPackage opcPackage = POIXMLDocument.openPackage(path)) {
            return new XWPFDocument(opcPackage)
                    .getProperties()
                    .getExtendedProperties()
                    .getUnderlyingProperties()
                    .getPages();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DocumentFormat getDocumentFormat() {
        return DocumentFormat.DOCX;
    }
}
