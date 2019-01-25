package com.ray.parker.demo.services;


import com.ray.parker.demo.commands.DocumentForm;
import com.ray.parker.demo.domain.Document;

import java.util.List;

/**
 * Created by RP on 25/01/18.
 */
public interface DocumentService {

    List<Document> listAll();

    Document getById(String id);

    Document saveOrUpdate(Document document);

    void delete(String id);

    void saveAll(List<Document> documents);

    Document saveOrUpdateDocumentForm(DocumentForm documentForm);
}
