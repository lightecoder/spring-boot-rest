package com.ray.parker.demo.converters;

import com.ray.parker.demo.commands.DocumentForm;
import com.ray.parker.demo.domain.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by RP on 25/01/18.
 */
@Component
public class DocumentFormToDocument implements Converter<DocumentForm, Document> {

    @Override
    public Document convert(DocumentForm documentForm) {
        Document document = new Document();
        if (documentForm.getId() != null  && !StringUtils.isEmpty(documentForm.getId())) {
            document.setId(documentForm.getId());
        }
        document.setHash(documentForm.getHash());
        document.setDescription(documentForm.getDescription());
        document.setHash(documentForm.getHash());
        document.setFormat(documentForm.getFormat());
        document.setUrl(documentForm.getUrl());
        document.setTitle(documentForm.getTitle());
        document.setDocumentOf(documentForm.getDocumentOf());
        document.setDatePublished(documentForm.getDatePublished());
        document.setDateModified(documentForm.getDateModified());
        document.setDocumentType(documentForm.getDocumentType());
        document.setRelatedItem(documentForm.getRelatedItem());
        return document;
    }
}
