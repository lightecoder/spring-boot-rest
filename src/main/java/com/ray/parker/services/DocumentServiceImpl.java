package com.ray.parker.services;

import com.ray.parker.model.Document;
import com.ray.parker.dao.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RP on 25/01/18.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Override
    public List<Document> listAll() {
        List<Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(documents::add);
        return documents;
    }

    @Override
    public Document getById(String id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public Document saveOrUpdate(Document document) {
        documentRepository.save(document);
        return document;
    }

    @Override
    public void delete(String id) {
        documentRepository.deleteById(id);

    }

    @Override
    public void saveAll(List<Document> documents) {
        documentRepository.saveAll(documents);
    }

}
