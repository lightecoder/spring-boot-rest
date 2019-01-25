package com.ray.parker.demo.converters;

import com.ray.parker.demo.commands.DocumentForm;
import com.ray.parker.demo.domain.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by RP on 25/01/18.
 */
@Component
public class DocumentToDocumentForm implements Converter<Document, DocumentForm> {

    @Override
    public DocumentForm convert(Document document) {
        DocumentForm documentForm = new DocumentForm();
        documentForm.setId(document.getId());
        documentForm.setHash(document.getHash());
        documentForm.setDescription(document.getDescription());
        documentForm.setHash(document.getHash());
        documentForm.setFormat(document.getFormat());
        documentForm.setUrl(document.getUrl());
        documentForm.setTitle(document.getTitle());
        documentForm.setDocumentOf(document.getDocumentOf());
        documentForm.setDatePublished(document.getDatePublished());
        documentForm.setDateModified(document.getDateModified());
        documentForm.setDocumentType(document.getDocumentType());
        documentForm.setRelatedItem(document.getRelatedItem());
        return documentForm;
    }
}
