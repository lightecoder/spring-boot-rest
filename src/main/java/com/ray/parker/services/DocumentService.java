package com.ray.parker.services;

import com.ray.parker.model.Document;

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

}
